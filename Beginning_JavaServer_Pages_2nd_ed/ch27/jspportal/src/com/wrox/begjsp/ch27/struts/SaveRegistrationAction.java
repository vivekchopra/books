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
 * Processes the user registration information entered by the user.
 */
public final class SaveRegistrationAction extends Action
{
    private Logger logger = Logger.getLogger(SaveRegistrationAction.class.getName());

    /**
     * Processes the user registration information
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
        UserProfile userProfile = new UserProfile();

        String username = regform.getUserName();

        // Check for duplicate user name; flag error
        UserProfile checkProfile = (DBFactory.getUserProfileDB()).getUserProfile(username);

        if ((checkProfile != null) &&
              (username.equals(checkProfile.getUserName())))
        {
            // Duplicate user!
            String errorMessage = "User " + username + " already exists";
            logger.error(errorMessage);
            request.setAttribute(WebappConstants.ERROR_INFO, errorMessage);

            return (mapping.findForward("failure"));
        }

        if (logger.isDebugEnabled())
        {
            logger.debug("Create user called for " + username +
                " with interests " + regform.getInterests() +
                " and subscription [" + regform.getSubscriptions() + "]");
        }

        userProfile.setUserName(username);
        userProfile.setPassword(regform.getPassword());
        userProfile.setDisplayName(regform.getDisplayName());

        String interestString = regform.getInterests();
        StringTokenizer tokenizer = new StringTokenizer(interestString, ",");
        String[] interests = new String[tokenizer.countTokens()];

        int i = 0;

        while (tokenizer.hasMoreTokens())
        {
            interests[i] = tokenizer.nextToken();
            i++;
        }

        userProfile.setInterests(interests);

        userProfile.setSubscriptions(regform.getSubscriptions());

        session.setAttribute(WebappConstants.PROFILE_OBJECT, userProfile);

        (DBFactory.getUserProfileDB()).insertUserProfile(userProfile);

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
            "User account for " + regform.getUserName() +
            " created. Please log in.");

        return (mapping.findForward("success"));
    }
}
