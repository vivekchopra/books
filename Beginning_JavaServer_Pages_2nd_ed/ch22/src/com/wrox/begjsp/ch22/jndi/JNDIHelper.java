package com.wrox.begjsp.ch22.jndi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JNDIHelper
{
    private String  _title;
    private Integer _version;

    public JNDIHelper()
    {
        try
        {
            Context context = new InitialContext();
            Context applicationEnv = (Context)context.lookup("java:comp/env");
            _title = (String)applicationEnv.lookup("pageTitle");
            _version = (Integer)applicationEnv.lookup("versionNumber");
        }
        catch (NamingException unexpected)
        {
            _title = "Unknown";
            _version = new Integer(0);
        }
    }

    public String getTitle()
    {
        return _title;
    }

    public Integer getVersion()
    {
        return _version;
    }
}