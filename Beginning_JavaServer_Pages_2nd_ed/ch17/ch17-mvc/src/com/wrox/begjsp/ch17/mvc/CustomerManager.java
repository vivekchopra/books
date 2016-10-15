package com.wrox.begjsp.ch17.mvc;

import java.util.ArrayList;
import java.util.List;


public class CustomerManager
{
    public List getCustomers()
    {
        return generateCustomers();
    }

    private List generateCustomers()
    {
        List rv = new ArrayList();

        for (int i = 0; i < 10; i++)
        {
            rv.add(getCustomer(String.valueOf(i)));
        }

        return rv;
    }

    public Customer getCustomer(String id)
    {
        return new Customer(id, id + "First", "Last" + id,
            "123 Caroline Road Fooville");
    }
}
