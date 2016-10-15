package com.wrox.begjsp.ch19.struts.simpleform;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import javax.servlet.http.HttpServletRequest;


public class LoginForm extends ActionForm
{
    private String _username;
    private String _password;

    public LoginForm()
    {
    }

    public String getPassword()
    {
        return _password;
    }

    public void setPassword(String password)
    {
        _password = password;
    }

    public String getUsername()
    {
        return _username;
    }

    public void setUsername(String username)
    {
        _username = username;
    }

    public ActionErrors validate(ActionMapping mapping,
        HttpServletRequest request)
    {
        ActionErrors errors = new ActionErrors();

        if ((_username == null) || (_username.length() < 1))
        {
            errors.add("username",
                new ActionMessage("error.login.username.missing"));
        }

        if ((_password == null) || (_password.length() < 1))
        {
            errors.add("password",
                new ActionMessage("error.login.password.missing"));
        }

        return errors;
    }
}
