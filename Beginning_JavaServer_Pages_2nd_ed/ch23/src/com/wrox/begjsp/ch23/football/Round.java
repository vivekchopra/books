package com.wrox.begjsp.ch23.football;

import java.util.Date;

public class Round
{
    private int  _id;
    private int  _roundNumber;
    private Date _startDate;
    private Date _endDate;

    public Round(int id, int roundNumber, Date startDate, Date endDate)
    {
        _id = id;
        _roundNumber = roundNumber;
        _startDate = startDate;
        _endDate = endDate;
    }

    public int getId()
    {
        return _id;
    }

    public Date getStartDate()
    {
        return _startDate;
    }

    public int getRoundNumber()
    {
        return _roundNumber;
    }

    public Date getEndDate()
    {
        return _endDate;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof Round)
        {
            Round compare = (Round)obj;
            return (_id == compare.getId());
        }
        return false;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = 31 * hash + _id;
        hash = 31 * hash + _roundNumber;
        return hash;
    }

    public String toString()
    {
        return getClass() + "[" + _id + "] : [" + _roundNumber + "]";
    }

    private Round()
    {
        // required for hibernate
    }

    private void setEndDate(Date endDate)
    {
        _endDate = endDate;
    }

    private void setRoundNumber(int roundNumber)
    {
        _roundNumber = roundNumber;
    }

    private void setStartDate(Date startDate)
    {
        _startDate = startDate;
    }

    private void setId(int id)
    {
        _id = id;
    }
}