package com.wrox.begjsp.ch19.struts.simpleform;

import org.apache.struts.validator.ValidatorForm;


public class ValidatorLoginForm extends ValidatorForm
{
    private String _username;
    private String _password;

    public ValidatorLoginForm()
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
}
