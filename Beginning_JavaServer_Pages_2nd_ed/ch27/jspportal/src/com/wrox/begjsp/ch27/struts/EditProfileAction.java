package com.wrox.begjsp.ch27.struts;

import com.wrox.begjsp.ch27.dal.DBFactory;
import com.wrox.begjsp.ch27.dto.UserProfile;

import org.apache.log4j.Logger;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;

import java.lang.reflect.InvocationTargetException;

import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public final class EditProfileAction extends Action
{
    private static Logger logger = Logger.getLogger(EditProfileAction.class.getName());

    /**
     * Process the request before the edit profile form.
    *
     * @param mapping The ActionMapping used to select this instance
     * @param actionForm The ActionForm bean for this request
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        HttpSession session = request.getSession();

        if (logger.isDebugEnabled())
        {
            logger.debug("EditProfileAction called");
        }

        UserProfile userProfile = (UserProfile) session.getAttribute(WebappConstants.PROFILE_OBJECT);

        // If we can't find the user profile object, then send to logon page
        if (userProfile == null)
        {
            logger.error("Session for user expired; redirecting to logon page");

            return (mapping.findForward("logon"));
        }

        // Populate the user profile
        if (form == null)
        {
            form = new RegistrationForm();
        }

        /* Populate the registration form */
        RegistrationForm regform = (RegistrationForm) form;

        regform.setUserName(userProfile.getUserName());
        regform.setPassword(userProfile.getPassword());
        regform.setDisplayName(userProfile.getDisplayName());

        String interestStr = "";
        String[] interests = userProfile.getInterests();

        for (int i = 0; i < interests.length; i++)
        {
            if (i == 0)
            {
                interestStr = interests[0];
            }
            else
            {
                interestStr += ("," + interests[i]);
            }
        }

        regform.setInterests(interestStr);
        regform.setSubscriptions(regform.getSubscriptions());

        request.setAttribute(mapping.getAttribute(), form);

        //saveToken(request);
        List publisherList = DBFactory.getPublisherDB().getPublishers();
        request.setAttribute(WebappConstants.PUBLISHER_INFO_OBJECT,
            publisherList);

        return (mapping.findForward("success"));
    }
}
