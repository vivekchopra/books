package com.wrox.begjsp.ch23.football;

public class Fixture
{
    private int   _id;
    private Round _round;
    private Team  _homeTeam;
    private Team  _awayTeam;
    private Venue _venue;

    public Fixture(int id, Round round, Team homeTeam, Team awayTeam, Venue venue)
    {
        _id = id;
        _round = round;
        _homeTeam = homeTeam;
        _awayTeam = awayTeam;
        _venue = venue;
    }

    public Team getAwayTeam()
    {
        return _awayTeam;
    }

    public Team getHomeTeam()
    {
        return _homeTeam;
    }

    public int getId()
    {
        return _id;
    }

    public Round getRound()
    {
        return _round;
    }

    public Venue getVenue()
    {
        return _venue;
    }
    
    // addition for exercise 2
    public void deleteFixtureFromRound()
    {
        _round = null;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof Fixture)
        {
            Fixture compare = (Fixture)obj;
            return (_id == compare.getId());
        }
        return false;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = 31 * hash + _id;
        hash = 31 * hash + (_round == null ? 0 : _round.hashCode());
        hash = 31 * hash + (_homeTeam == null ? 0 : _homeTeam.hashCode());
        hash = 31 * hash + (_awayTeam == null ? 0 : _awayTeam.hashCode());
        hash = 31 * hash + (_venue == null ? 0 : _venue.hashCode());
        return hash;
    }

    public String toString()
    {
        return getClass() + "[" + _id + "]";
    }

    private Fixture()
    {
        // required for hibernate
    }

    private void setAwayTeam(Team awayTeam)
    {
        _awayTeam = awayTeam;
    }

    private void setHomeTeam(Team homeTeam)
    {
        _homeTeam = homeTeam;
    }

    private void setId(int id)
    {
        _id = id;
    }

    private void setRound(Round round)
    {
        _round = round;
    }

    private void setVenue(Venue venue)
    {
        _venue = venue;
    }
}