package com.wrox.begjsp.ch27.struts;

import org.apache.log4j.Logger;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Implementation of the Action that processes a
 * user logoff.
 */
public final class LogoffAction extends Action
{
    private static Logger logger = Logger.getLogger(LogoffAction.class.getName());

    public ActionForward execute(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        if (logger.isDebugEnabled())
        {
            logger.debug("User logged out");
        }

        HttpSession session = request.getSession();
        session.removeAttribute(WebappConstants.PROFILE_OBJECT);
        session.invalidate();

        return (mapping.findForward("success"));
    }
}
