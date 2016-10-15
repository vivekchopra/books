package com.wrox.begjsp.ch23.football;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCRosterManager implements RosterManager
{
    private Connection _connection;

    public JDBCRosterManager(Connection connection)
    {
        _connection = connection;
    }

    public List getTeamsInRoster() throws DataException
    {
        List results = new ArrayList();
        Statement statement = null;
        try
        {
            statement = _connection.createStatement();
            ResultSet teams = statement.executeQuery("SELECT * FROM roster ORDER BY id ASC");
            if (teams != null)
            {
                while (teams.next())
                {
                    int id = teams.getInt("id");
                    String name = teams.getString("teamname");
                    Team team = new Team(id, name);
                    results.add(team);
                }
            }
        }
        catch (SQLException unexpected)
        {
            throw new DataException(unexpected.getMessage());
        }
        finally
        {
            safeClose(statement);
        }
        return results;
    }

    private void safeClose(Statement statement)
    {
        try
        {
            if (statement != null)
            {
                statement.close();
            }
        }
        catch (SQLException unexpected)
        {
            // ignore this
        }
    }

    public void releaseResources()
    {
        if (_connection != null)
        {
            try
            {
                _connection.close();
            }
            catch (SQLException unexpected)
            {
                // ignore this
            }
        }
    }

    public boolean addNewTeamToRoster(Team newTeam) throws DataException
    {
        PreparedStatement statement = null;
        boolean result = false;
        try
        {
            statement = _connection.prepareStatement("INSERT INTO roster (teamname) values (?)");
            statement.setString(1, newTeam.getName());

            result = statement.execute();
        }
        catch (SQLException unexpected)
        {
            throw new DataException(unexpected.getMessage());
        }
        finally
        {
            safeClose(statement);
        }
        return result;
    }

    public boolean modifyTeamInRoster(Team modifyTeam) throws DataException
    {
        PreparedStatement statement = null;
        boolean result = false;
        try
        {
            statement = _connection.prepareStatement("UPDATE roster set teamname = ? where id = ?");
            statement.setString(1, modifyTeam.getName());
            statement.setInt(2, modifyTeam.getId());

            result = statement.execute();
        }
        catch (SQLException unexpected)
        {
            throw new DataException(unexpected.getMessage());
        }
        finally
        {
            safeClose(statement);
        }
        return result;
    }

    public boolean deleteTeamFromRoster(int teamId) throws DataException
    {
        PreparedStatement statement = null;
        boolean result = false;
        try
        {
            statement = _connection.prepareStatement("DELETE from roster where id = ?");
            statement.setInt(1, teamId);

            result = statement.execute();
        }
        catch (SQLException unexpected)
        {
            throw new DataException(unexpected.getMessage());
        }
        finally
        {
            safeClose(statement);
        }
        return result;
    }

    /*-- Unsupported operations --*/
    public List getVenuesInRoster() throws DataException
    {
        throw new UnsupportedOperationException("getVenuesInRoster() not supported in JDBC");
    }

    public boolean addNewVenueToRoster(Venue venue) throws DataException
    {
        throw new UnsupportedOperationException("addNewVenueToRoster() not supported in JDBC");
    }

    public boolean deleteVenueFromRoster(int teamId) throws DataException
    {
        throw new UnsupportedOperationException("deleteVenueFromRoster() not supported in JDBC");
    }

    public boolean modifyVenueInRoster(Venue venue) throws DataException
    {
        throw new UnsupportedOperationException("modifyVenueInRoster() not supported in JDBC");
    }

    public List getFixturesInRoster() throws DataException
    {
        throw new UnsupportedOperationException("getFixturesInRoster() not supported in JDBC");
    }

    public boolean addNewFixtureToRoster(Fixture fixture) throws DataException
    {
        throw new UnsupportedOperationException("addNewFixtureToRoster() not supported in JDBC");
    }

    public boolean deleteFixtureFromRoster(int fixtureId) throws DataException
    {
        throw new UnsupportedOperationException("deleteFixtureFromRoster() not supported in JDBC");
    }

    public boolean modifyFixtureInRoster(Fixture fixture) throws DataException
    {
        throw new UnsupportedOperationException("modifyFixtureInRoster() not supported in JDBC");
    }

    public List getRoundsInRoster() throws DataException
    {
        throw new UnsupportedOperationException("getRoundsInRoster() not supported in JDBC");
    }

    public Round getRoundById(int id) throws DataException
    {
        throw new UnsupportedOperationException("getRoundById() not supported in JDBC");
    }

    public Team getTeamById(int id) throws DataException
    {
        throw new UnsupportedOperationException("getTeamById() not supported in JDBC");
    }

    public Venue getVenueById(int id) throws DataException
    {
        throw new UnsupportedOperationException("getVenueById() not supported in JDBC");
    }
}