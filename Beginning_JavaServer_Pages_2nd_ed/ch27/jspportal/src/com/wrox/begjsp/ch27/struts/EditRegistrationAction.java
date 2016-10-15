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


public final class EditRegistrationAction extends Action
{
    private static Logger logger = Logger.getLogger(EditRegistrationAction.class.getName());

    /**
     * Process the request before the registration form.
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
        if (logger.isDebugEnabled())
        {
            logger.debug("EditRegistration invoked");
        }

        form = new RegistrationForm();
        request.setAttribute(mapping.getAttribute(), form);

        // Save a new transaction token in the user's profile
        saveToken(request);

        List publisherList = DBFactory.getPublisherDB().getPublishers();

        request.setAttribute(WebappConstants.PUBLISHER_INFO_OBJECT,
            publisherList);

        return (mapping.findForward("success"));
    }
}
