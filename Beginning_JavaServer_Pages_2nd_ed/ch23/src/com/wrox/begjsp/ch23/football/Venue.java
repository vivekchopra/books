package com.wrox.begjsp.ch23.football;

public class Venue
{
    private int    _id;
    private String _location;

    public Venue(int id, String location)
    {
        _id = id;
        _location = location;
    }

    public int getId()
    {
        return _id;
    }

    public String getLocation()
    {
        return _location;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof Venue)
        {
            Venue compare = (Venue)obj;
            return (_id == compare.getId());
        }
        return false;
    }

    public int hashCode()
    {
        return _location.hashCode();
    }

    public String toString()
    {
        return getClass() + "[" + _id + "] : [" + _location + "]";
    }

    private Venue()
    {
        // required for hibernate
    }

    private void setId(int id)
    {
        _id = id;
    }

    private void setLocation(String location)
    {
        _location = location;
    }

}