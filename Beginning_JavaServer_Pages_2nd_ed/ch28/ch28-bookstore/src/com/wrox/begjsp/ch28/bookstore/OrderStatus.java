package com.wrox.begjsp.ch28.bookstore;

public class OrderStatus extends BaseEntity
{
    private String _name;

    public String getName()
    {
        return _name;
    }

    public void setName(String name)
    {
        _name = name;
    }
}
