package com.wrox.begjsp.ch22.example1;

import javax.naming.Binding;

/**
 * JNDIElement
 */
public class JNDIElement
{
    private String  _contextName;
    private Binding _binding;

    public JNDIElement(String contextName, Binding binding)
    {
        _contextName = contextName;
        _binding = binding;
    }

    public String getClassName()
    {
        return _binding.getClassName();
    }

    public Object getObject()
    {
        return _binding.getObject();
    }

    public String getContextName()
    {
        return _contextName;
    }

    public String getName()
    {
        return _binding.getName();
    }
}