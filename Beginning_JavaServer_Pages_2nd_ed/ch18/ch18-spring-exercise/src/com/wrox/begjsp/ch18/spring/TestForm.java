package com.wrox.begjsp.ch18.spring;

import java.io.Serializable;

public class TestForm implements Serializable
{
    private String _name = "";
    private String _comments = "";
    private int _age = 0;

    public String getComments()
    {
        return _comments;
    }

    public void setComments(String comments)
    {
        _comments = comments;
    }

    public String getName()
    {
        return _name;
    }

    public void setName(String name)
    {
        _name = name;
    }

    public int getAge()
    {
        return _age;
    }

    public void setAge(int age)
    {
        _age = age;
    }
}
