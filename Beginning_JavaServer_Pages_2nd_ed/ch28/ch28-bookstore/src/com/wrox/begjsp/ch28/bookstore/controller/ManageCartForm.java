package com.wrox.begjsp.ch28.bookstore.controller;

import org.apache.struts.action.ActionForm;

import java.util.HashMap;
import java.util.Map;


public class ManageCartForm extends ActionForm
{
    private Map values = new HashMap();
    private String command = "";

    public String getCommand()
    {
        return command;
    }

    public void setCommand(String value)
    {
        command = value;
    }

    public void setValue(String key, Object value)
    {
        values.put(key, value);
    }

    public Object getValue(String key)
    {
        return values.get(key);
    }

    public Map getValues()
    {
        return values;
    }
}
