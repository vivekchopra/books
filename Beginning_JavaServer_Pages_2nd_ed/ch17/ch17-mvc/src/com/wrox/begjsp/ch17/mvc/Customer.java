package com.wrox.begjsp.ch17.mvc;

public class Customer
{
    private String _id;
    private String _firstName;
    private String _lastName;
    private String _address;

    public Customer(String id, String firstName, String lastName, String address)
    {
        _id = id;
        _firstName = firstName;
        _lastName = lastName;
        _address = address;
    }

    public String getAddress()
    {
        return _address;
    }

    public void setAddress(String address)
    {
        _address = address;
    }

    public String getFirstName()
    {
        return _firstName;
    }

    public void setFirstName(String firstName)
    {
        _firstName = firstName;
    }

    public String getLastName()
    {
        return _lastName;
    }

    public void setLastName(String lastName)
    {
        _lastName = lastName;
    }

    public String getId()
    {
        return _id;
    }

    public void set_id(String id)
    {
        _id = id;
    }
}
