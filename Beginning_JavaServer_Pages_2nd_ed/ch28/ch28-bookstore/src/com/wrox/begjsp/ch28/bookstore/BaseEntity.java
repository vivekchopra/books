package com.wrox.begjsp.ch28.bookstore;

public abstract class BaseEntity
{
    private int _id = 0;

    public int getId()
    {
        return _id;
    }

    public void setId(int id)
    {
        _id = id;
    }
}
