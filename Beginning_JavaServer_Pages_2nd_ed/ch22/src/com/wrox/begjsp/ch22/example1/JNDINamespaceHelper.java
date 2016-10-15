package com.wrox.begjsp.ch22.example1;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Binding;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

public class JNDINamespaceHelper
{
    public List getNamespace() throws NamingException
    {
        Context context = new InitialContext();
        return getNamespaceElements(context, "java:comp/env");
    }

    private List getNamespaceElements(Context context, String contextName) throws NamingException
    {
        Context newContext = (Context)context.lookup(contextName);
        NamingEnumeration enum = newContext.listBindings("");
        List results = new ArrayList();
        while (enum.hasMore())
        {
            Binding binding = (Binding)enum.next();
            if ((binding.getObject() instanceof Context))
            {
                String subContextName = binding.getName();
                List subContextElements = getNamespaceElements(context, contextName + "/"
                        + subContextName);
                results.addAll(subContextElements);
            }
            else
            {
                JNDIElement element = new JNDIElement(contextName, binding);
                results.add(element);
            }
        }
        return results;
    }

}