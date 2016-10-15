package com.wrox.begjsp.ch27.struts;

import com.wrox.begjsp.ch27.dto.ItemFeed;
import com.wrox.begjsp.ch27.dto.NewsFeed;
import com.wrox.begjsp.ch27.dto.NewsItem;
import com.wrox.begjsp.ch27.dto.UserProfile;
import com.wrox.begjsp.ch27.service.AuthenticationService;
import com.wrox.begjsp.ch27.service.ItemService;
import com.wrox.begjsp.ch27.service.NewsService;
import com.wrox.begjsp.ch27.service.WroxServiceException;
import com.wrox.begjsp.ch27.service.WroxServiceLocator;

import org.apache.commons.beanutils.PropertyUtils;

import org.apache.log4j.Logger;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;
import org.apache.struts.util.ModuleException;

import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Implementation of an Action that authenticates a user and pulls up
 * the user profile
 */
public final class LogonAction extends Action
{
    private Logger logger = Logger.getLogger(LogonAction.class.getName());

    /**
     * Process the specified HTTP request, and create the corresponding HTTP
     * response (or forward to another web component that will create it).
     * Return an ActionForward instance describing where and how
     * control should be forwarded, or null if the response has
     * already been completed.
     *
     * @param mapping The ActionMapping used to select this instance
     * @param form The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     *
     * @exception Exception if business logic throws an exception
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        HttpSession session = request.getSession();

        // Is there a currently logged on user?
        UserProfile userProfile = (UserProfile) session.getAttribute(WebappConstants.PROFILE_OBJECT);

        String username = null;

        if (userProfile == null)
        {
            String error = null;
            username = (String) PropertyUtils.getSimpleProperty(form, "username");

            String password = (String) PropertyUtils.getSimpleProperty(form,
                    "password");
                    
            if (logger.isDebugEnabled())
            {
                logger.debug("Attempting to log in " + username);
            }

            try
            {
                userProfile = authenticateUser(username, password);

                if ((userProfile == null) ||
                      (userProfile.getStatus() != UserProfile.STATUS_LOGGED_IN))
                {
                    error = (userProfile.getStatus() == UserProfile.STATUS_INVALID_USER)
                        ? "Invalid user" : "Invalid password";
                    logger.info("Logon for user " + username +
                        " failed. Reason: " + error);
                }
            }
            catch (WroxServiceException e)
            {
                logger.error("Error accessing Authentication service " +
                    e.getLocalizedMessage());
                error = "Portal unavailable";
            }

            // Report any errors
            if (error != null)
            {
                request.setAttribute(WebappConstants.ERROR_INFO, error);

                return (mapping.findForward("failure"));
            }

            // Save our logged-in user in the session
            session.setAttribute(WebappConstants.PROFILE_OBJECT, userProfile);
        }

        // Get the news subscriptions for the user, and save them in the request
        ArrayList news = ServiceHelper.getSubscriptions(userProfile, logger);
        request.setAttribute(WebappConstants.NEWS_OBJECT, news);

        // Get the items matching the user interest and save them in the request
        ArrayList items = ServiceHelper.getItems(userProfile, logger);
        request.setAttribute(WebappConstants.ITEMS_OBJECT, items);

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

                if (logger.isDebugEnabled())
                {
                        logger.debug("User " + username + " logged in.");
                }

        // Forward control to the specified success URI
        return (mapping.findForward("success"));
    }

    /**
     * Look up the user, throwing an exception to simulate business logic
     * rule exceptions.
     *
     * @param username Username specified on the logon form
     * @param username Username specified on the logon form
     *
     * @exception WroxServiceException If the authentication service throes
     */
    private UserProfile authenticateUser(String username, String password)
        throws WroxServiceException
    {
        AuthenticationService authService = WroxServiceLocator.getAuthenticationService();
        UserProfile userProfile = authService.login(username, password);

        return userProfile;
    }
}
