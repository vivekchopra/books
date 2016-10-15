package com.wrox.begjsp.ch19.struts;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginExeAction extends Action
{
    public ActionForward execute(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        HttpSession session = request.getSession();

        if (authenticated(form))
        {
            session.setAttribute("loginKey", "admin");

            return mapping.findForward("success");
        }

        return mapping.findForward("failure");
    }

    private boolean authenticated(ActionForm form)
    {
        DynaActionForm loginForm = (DynaActionForm) form;
        String userName = (String) loginForm.get("username");
        String password = (String) loginForm.get("password");

        if ("admin".equals(userName) && "password".equals(password))
        {
            return true;
        }

        return false;
    }
}
