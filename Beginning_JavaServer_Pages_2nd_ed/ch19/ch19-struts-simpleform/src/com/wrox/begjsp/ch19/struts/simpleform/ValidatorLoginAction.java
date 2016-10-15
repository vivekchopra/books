package com.wrox.begjsp.ch19.struts.simpleform;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;


public class ValidatorLoginAction extends Action
{
    public ActionForward execute(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        ActionMessages errors = new ActionMessages();
        ValidatorLoginForm loginForm = (ValidatorLoginForm) form;
        String userName = (String) loginForm.getUsername();
        String password = (String) loginForm.getPassword();

        ActionForward returnForward = null;

        if ("admin".equals(userName) && "opensesame".equals(password))
        {
            returnForward = mapping.findForward("success");
        }
        else
        {
            returnForward = mapping.getInputForward();
            errors.add(ActionMessages.GLOBAL_MESSAGE, 
                    new ActionMessage("error.login.invalid"));
        }

        if (!errors.isEmpty())
        {
            saveErrors(request, errors);
        }

        return returnForward;
    }
}
