package com.wrox.begjsp.ch23.football;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class FixtureProcessingCommand extends AbstractProcessingCommand
{
    private static final Logger LOG                = Logger
                                                           .getLogger(FixtureProcessingCommand.class);

    private static final String FIXTURE_PAGE       = "fixture.jsp";

    // for the dropdown menus
    private static final String ROUND_LIST_TOKEN   = "rounds";
    private static final String TEAM_LIST_TOKEN    = "teams";
    private static final String VENUE_LIST_TOKEN   = "venues";
    private static final String FIXTURE_LIST_TOKEN = "fixtures";

    private static final String ACTION_FIXTURE_ADD = "FIXTURE_ADD";
    private static final String ACTION_FIXTURE_DEL = "FIXTURE_DELETE";

    private FootyJDBCHelper     _helper            = null;

    public FixtureProcessingCommand(FootyJDBCHelper helper)
    {
        _helper = helper;
    }

    public void execute(HttpServletRequest request, HttpServletResponse response, String action)
            throws ServletException, IOException
    {
        if (ACTION_FIXTURE_ADD.equals(action))
        {
            String roundIdString = request.getParameter("round_id");
            String awayTeamIdString = request.getParameter("away_team_id");
            String homeTeamIdString = request.getParameter("home_team_id");
            String venueIdString = request.getParameter("venue_id");
            
            processFixtureAdd(Integer.parseInt(roundIdString),
                        Integer.parseInt(awayTeamIdString),
                        Integer.parseInt(homeTeamIdString),
                        Integer.parseInt(venueIdString));
            
        }
        else if (ACTION_FIXTURE_DEL.equals(action))
        {
            String deleteIDs[] = request.getParameterValues("DELETE_LIST");
            if (deleteIDs != null)
            {
                for (int i = 0; i < deleteIDs.length; i++)
                {
                    String idString = deleteIDs[i];
                    int id = Integer.parseInt(idString);
                    processFixtureDelete(id);
                }
            }
        }
        processFixtureList(request);
        performRedirect(FIXTURE_PAGE, request, response);
    }

    private void processFixtureDelete(int fixtureId)
    {
        RosterManager manager = null;
        try
        {
            manager = getRosterManager();
            manager.deleteFixtureFromRoster(fixtureId);
        }
        catch (DataException unexpected)
        {
            LOG.error("Error deleting fixture : " + unexpected);
        }
        finally
        {
            if (manager != null)
            {
                manager.releaseResources();
            }
        }
    }

    private void processFixtureAdd(int roundId, int homeTeamId, int awayTeamId, int venueId)
    {
        RosterManager manager = null;
        try
        {
            manager = getRosterManager();
            
            Round round = manager.getRoundById(roundId);
            Team homeTeam = manager.getTeamById(homeTeamId);
            Team awayTeam = manager.getTeamById(awayTeamId);
            Venue venue = manager.getVenueById(venueId);
            
            manager.addNewFixtureToRoster(new Fixture(0, round, homeTeam, awayTeam, venue));
        }
        catch (DataException unexpected)
        {
            LOG.error("Error adding new fixture : " + unexpected);
        }
        finally
        {
            if (manager != null)
            {
                manager.releaseResources();
            }
        }
    }

    private void processFixtureList(HttpServletRequest request)
    {
        RosterManager manager = null;
        try
        {
            manager = getRosterManager();
            
            List venues  = manager.getVenuesInRoster();
            List teams = manager.getTeamsInRoster();
            List rounds = manager.getRoundsInRoster();
            List fixtures = manager.getFixturesInRoster();
            
            request.setAttribute(FIXTURE_LIST_TOKEN, fixtures);
            request.setAttribute(TEAM_LIST_TOKEN, teams);
            request.setAttribute(ROUND_LIST_TOKEN, rounds);
            request.setAttribute(VENUE_LIST_TOKEN, venues);
        }
        catch (DataException unexpected)
        {
            LOG.error("Error processing fixture list : " + unexpected);
        }
        finally
        {
            if (manager != null)
            {
                manager.releaseResources();
            }
        }
    }

    private RosterManager getRosterManager() throws DataException
    {
        RosterManager manager;
        try
        {
            manager = RosterManagerFactory.createRosterManager(_helper.getConnection());
        }
        catch (SQLException connectionFailure)
        {
            throw new DataException(connectionFailure.getMessage());
        }
        return manager;
    }
}