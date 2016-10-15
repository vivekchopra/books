package com.wrox.begjsp.ch23.football;

public class Team
{
    private int    _id;
    private String _name;

    public Team(int id, String name)
    {
        _id = id;
        _name = name;
    }

    public int getId()
    {
        return _id;
    }

    public String getName()
    {
        return _name;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof Team)
        {
            Team compare = (Team)obj;
            return (_id == compare.getId());
        }
        return false;
    }

    public int hashCode()
    {
        return _name.hashCode();
    }

    public String toString()
    {
        return getClass() + "[" + _id + "] : [" + _name + "]";
    }

    private Team()
    {
        // required for hibernate
    }

    private void setId(int id)
    {
        _id = id;
    }

    private void setName(String name)
    {
        _name = name;
    }
}