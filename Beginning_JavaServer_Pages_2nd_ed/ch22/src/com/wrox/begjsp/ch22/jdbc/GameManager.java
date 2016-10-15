package com.wrox.begjsp.ch22.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GameManager
{
    private Connection _connection;
    
    public GameManager(Connection connection)
    {
        _connection = connection;
    }

    public List getResults() throws SQLException
    {
        Statement statement = _connection.createStatement();
        ResultSet games = statement.executeQuery("SELECT * FROM games");
        List results = new ArrayList();
        if (games != null)
        {
            while (games.next())
            {
                String home = games.getString("home_team");
                String away = games.getString("away_team");
                int winner = games.getInt("winner");
                String nameWinner = (winner == 1) ? home : away;

                GameResult game = new GameResult(home, away, nameWinner);
                results.add(game);
            }
        }

        return results;
    }
}