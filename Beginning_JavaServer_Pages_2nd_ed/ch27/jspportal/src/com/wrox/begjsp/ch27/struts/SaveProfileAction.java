package com.wrox.begjsp.ch27.struts;

import com.wrox.begjsp.ch27.dal.DBFactory;
import com.wrox.begjsp.ch27.dto.ItemFeed;
import com.wrox.begjsp.ch27.dto.NewsFeed;
import com.wrox.begjsp.ch27.dto.UserProfile;
import com.wrox.begjsp.ch27.service.AuthenticationService;
import com.wrox.begjsp.ch27.service.ItemService;
import com.wrox.begjsp.ch27.service.NewsService;
import com.wrox.begjsp.ch27.service.WroxServiceException;
import com.wrox.begjsp.ch27.service.WroxServiceLocator;

import org.apache.log4j.Logger;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;

import java.lang.reflect.InvocationTargetException;

import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Processes the uuser profile change entered by the user.
 */
public final class SaveProfileAction extends Action
{
    private Logger logger = Logger.getLogger(SaveProfileAction.class.getName());

    /**
    * Processes the user profile change information
     *
     * @param mapping The ActionMapping used to select this instance
     * @param actionForm The ActionForm bean for this request
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     *
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        HttpSession session = request.getSession();
        RegistrationForm regform = (RegistrationForm) form;
        String action = regform.getAction();

        // Is there a currently logged on user
        UserProfile userProfile = (UserProfile) session.getAttribute(WebappConstants.PROFILE_OBJECT);

        if (userProfile == null)
        {
            String errorMessage = "Trying to edit profile when session does not exist";
            logger.error(errorMessage);
            request.setAttribute(WebappConstants.ERROR_INFO, errorMessage);

            return (mapping.findForward("failure"));
        }

        if (logger.isDebugEnabled())
        {
            logger.debug("Edit profile called for " + regform.getUserName() +
                " with interests " + regform.getInterests() +
                " and subscription [" + regform.getSubscriptions() + "]");
        }

        userProfile.setUserName(regform.getUserName());
        userProfile.setPassword(regform.getPassword());
        userProfile.setDisplayName(regform.getDisplayName());
        userProfile.setStatus(UserProfile.STATUS_LOGGED_IN);

        String interestString = regform.getInterests();

        if (interestString != null)
        {
            StringTokenizer tokenizer = new StringTokenizer(interestString, ",");
            String[] interests = new String[tokenizer.countTokens()];

            int i = 0;

            while (tokenizer.hasMoreTokens())
            {
                interests[i] = tokenizer.nextToken();
                i++;
            }

            userProfile.setInterests(interests);
        }

        String[] subscriptions = regform.getSubscriptions();

        if ((subscriptions != null) && (subscriptions.length != 0))
        {
            userProfile.setSubscriptions(regform.getSubscriptions());
        }

        session.setAttribute(WebappConstants.PROFILE_OBJECT, userProfile);

        (DBFactory.getUserProfileDB()).updateUserProfile(userProfile);

        // Get the news subscriptions for the user, and save them in the request
        ArrayList news = ServiceHelper.getSubscriptions(userProfile, logger);
        request.setAttribute(WebappConstants.NEWS_OBJECT, news);

        // Get the items matching the user interest and save them in the request
        ArrayList items = ServiceHelper.getItems(userProfile, logger);
        request.setAttribute(WebappConstants.ITEMS_OBJECT, items);

        // Remove the obsolete form bean
        if (mapping.getAttribute() != null)
        {
            if ("request".equals(mapping.getScope()))
            {
                request.removeAttribute(mapping.getAttribute());
            }
            else
            {
                session.removeAttribute(mapping.getAttribute());
            }
        }

        // Forward control to the specified success URI
        request.setAttribute(WebappConstants.SUCCESS_INFO,
            "User account for " + regform.getUserName() + " modified.");

        return (mapping.findForward("success"));
    }
}
