package com.wrox.begjsp.ch23.football;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

public class HibernateRosterManager implements RosterManager
{
    private static final String ADD_DATA_ACTION    = "ADD";
    private static final String MODIFY_DATA_ACTION = "MODIFY";

    private Connection          _connection;
    private Session             _currentSession;

    public HibernateRosterManager(Connection connection)
    {
        _connection = connection;
    }

    /*-- getting objects --*/
    public List getTeamsInRoster() throws DataException
    {
        return getAllItems("from Team as team order by team.name asc");
    }

    public List getVenuesInRoster() throws DataException
    {
        return getAllItems("from Venue as venue order by venue.location asc");
    }

    public List getRoundsInRoster() throws DataException
    {
        return getAllItems("from Round as round order by round.roundNumber asc");
    }

    public List getFixturesInRoster() throws DataException
    {
        return getAllItems("from Fixture as fixture order by fixture.id asc");
    }

    private List getAllItems(String query) throws DataException
    {
        initSession();
        List list = null;
        try
        {
            Query allTeams = _currentSession.createQuery(query);
            list = allTeams.list();
        }
        catch (HibernateException unexpected)
        {
            throw new DataException(unexpected.getMessage());
        }
        finally
        {
            flushSession();
        }
        return list;
    }

    /*-- loading by id --*/
    public Round getRoundById(int id) throws DataException
    {
        return (Round)loadObjectById(Round.class, id);
    }

    public Team getTeamById(int id) throws DataException
    {
        return (Team)loadObjectById(Team.class, id);
    }

    public Venue getVenueById(int id) throws DataException
    {
        return (Venue)loadObjectById(Venue.class, id);
    }

    public Fixture getFixtureById(int id) throws DataException
    {
        return (Fixture)loadObjectById(Fixture.class, id);
    }
    
    private Object loadObjectById(Class clazz, int id) throws DataException
    {
        initSession();
        Object rv = null;
        try
        {
            rv = _currentSession.load(clazz, new Integer(id));
        }
        catch (HibernateException unexpected)
        {
            throw new DataException(unexpected.getMessage());
        }
        finally
        {
            flushSession();
        }
        return rv;
    }

    /*-- adding and modifying objects --*/
    public boolean addNewTeamToRoster(Team team) throws DataException
    {
        return addOrModifyObject(team, ADD_DATA_ACTION);
    }

    public boolean addNewVenueToRoster(Venue venue) throws DataException
    {
        return addOrModifyObject(venue, ADD_DATA_ACTION);
    }

    public boolean modifyTeamInRoster(Team team) throws DataException
    {
        return addOrModifyObject(team, MODIFY_DATA_ACTION);
    }

    public boolean modifyVenueInRoster(Venue venue) throws DataException
    {
        return addOrModifyObject(venue, MODIFY_DATA_ACTION);
    }

    public boolean addNewFixtureToRoster(Fixture newFixture) throws DataException
    {
        return addOrModifyObject(newFixture, ADD_DATA_ACTION);
    }

    public boolean modifyFixtureInRoster(Fixture fixture) throws DataException
    {
        throw new UnsupportedOperationException(
                "Modify a Fixture not supported, use delete, then add");
    }

    private boolean addOrModifyObject(Object object, String action) throws DataException
    {
        initSession();
        Transaction tx = null;
        try
        {
            tx = _currentSession.beginTransaction();
            _currentSession.saveOrUpdate(object);
            tx.commit();
        }
        catch (HibernateException cannotSaveOrUpdate)
        {
            try
            {
                tx.rollback();
            }
            catch (HibernateException cannotRollback)
            {
                // log this error
            }
            throw new DataException("Unable to " + action + " : " + cannotSaveOrUpdate.getMessage());
        }
        finally
        {
            flushSession();
        }

        return false;
    }

    /*-- delete objects --*/
    public boolean deleteTeamFromRoster(int id) throws DataException
    {
        return deleteObject(Team.class, id);
    }

    public boolean deleteVenueFromRoster(int id) throws DataException
    {
        return deleteObject(Venue.class, id);
    }

    public boolean deleteFixtureFromRoster(int id) throws DataException
    {
        return deleteObject(Fixture.class, id);
    }
    
    public boolean deleteRoundFromRoster(int id) throws DataException
    {
        return deleteObject(Round.class, id);
    }

    private boolean deleteObject(Class clazz, int id) throws DataException
    {
        initSession();
        Transaction tx = null;
        try
        {
            tx = _currentSession.beginTransaction();
            Object aboutToBeDeleted = loadObjectById(clazz, id);
            _currentSession.delete(aboutToBeDeleted);
            tx.commit();
        }
        catch (HibernateException cannotDelete)
        {
            try
            {
                tx.rollback();
            }
            catch (HibernateException cannotRollback)
            {
                // log this error
            }
            throw new DataException("Unable to delete  : " + cannotDelete.getMessage());
        }
        finally
        {
            flushSession();
        }
        return false;
    }

    /*-- utility methods --*/
    private void initSession()
    {
        if (_currentSession == null)
        {
            _currentSession = HibernateUtil.currentSession(_connection);
        }
    }

    private void flushSession()
    {
        try
        {
            if (_currentSession != null)
            {
                _currentSession.flush();
            }
        }
        catch (HibernateException sessionFlushFailure)
        {
            // log this error
        }
    }

    public void releaseResources()
    {
        if (_connection != null)
        {
            try
            {
                if (_currentSession != null)
                {
                    _currentSession.connection().close();
                    HibernateUtil.closeSession();
                }
                _connection.close();

            }
            catch (HibernateException sessionCloseFailure)
            {
                // log this error
            }
            catch (SQLException connectionCloseFailure)
            {
                // log this error
            }
        }
    }

}