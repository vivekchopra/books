package com.wrox.begjsp.ch22.jdbc;

/**
 * GameResult
 */
public class GameResult
{
    private String  _home;
    private String  _away;
    private String  _winner;
    private boolean _homeWinner;

    public GameResult(String home, String away, String winner)
    {
        _home = home;
        _away = away;
        _winner = winner;
        _homeWinner = _home.equals(_winner);
    }
    
    public String getAway()
    {
        return _away;
    }
    public String getHome()
    {
        return _home;
    }
    public String getWinner()
    {
        return _winner;
    }
    
    public boolean isHomeWinner()
    {
        return _homeWinner;
    }
}
