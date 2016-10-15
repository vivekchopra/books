package com.wrox.begjsp.ch23.football;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * RosterProcessingCommand
 */
public class RosterProcessingCommand extends AbstractProcessingCommand
{
    private static final Logger LOG               = Logger.getLogger(RosterProcessingCommand.class);

    private static final String ROSTER_PAGE       = "roster.jsp";

    public static final String  ACTION_ROSTER     = "ROSTER_LIST";
    private static final String ACTION_ROSTER_ADD = "ROSTER_ADD";
    private static final String ACTION_ROSTER_MOD = "ROSTER_MODIFY";
    private static final String ACTION_ROSTER_DEL = "ROSTER_DELETE";

    private FootyJDBCHelper     _helper           = null;

    public RosterProcessingCommand(FootyJDBCHelper helper)
    {
        _helper = helper;
    }

    public void execute(HttpServletRequest request, HttpServletResponse response, String action)
            throws ServletException, IOException
    {
        if (ACTION_ROSTER_ADD.equals(action))
        {
            String newNameString = request.getParameter("teamname");
            if (isValidString(newNameString))
            {
                processRosterAdd(newNameString);
            }
        }
        else if (ACTION_ROSTER_DEL.equals(action))
        {
            String deleteIDs[] = request.getParameterValues("DELETE_LIST");
            if (deleteIDs != null)
            {
                for (int i = 0; i < deleteIDs.length; i++)
                {
                    String idString = deleteIDs[i];
                    int id = Integer.parseInt(idString);
                    processRosterDelete(id);
                }
            }
        }
        else if (ACTION_ROSTER_MOD.equals(action))
        {
            String modIdString = request.getParameter("teamid");
            int modId = Integer.parseInt(modIdString);
            String modTeamName = request.getParameter("teamname");
            if (isValidString(modTeamName) && (modId > 0))
            {
                processRosterModify(new Team(modId, modTeamName));
            }
        }
        processRosterList(request);
        performRedirect(ROSTER_PAGE, request, response);
    }

    private void processRosterModify(Team team)
    {
        RosterManager manager = null;
        try
        {
            manager = getRosterManager();
            manager.modifyTeamInRoster(team);
        }
        catch (DataException unexpected)
        {
            LOG.error("Error modifying team in roster : " + unexpected);
        }
        finally
        {
            if (manager != null)
            {
                manager.releaseResources();
            }
        }
    }

    private void processRosterDelete(int teamId)
    {
        RosterManager manager = null;
        try
        {
            manager = getRosterManager();
            manager.deleteTeamFromRoster(teamId);
        }
        catch (DataException unexpected)
        {
            LOG.error("Error adding new team to roster : " + unexpected);
        }
        finally
        {
            if (manager != null)
            {
                manager.releaseResources();
            }
        }
    }

    private void processRosterAdd(String newTeam)
    {
        RosterManager manager = null;
        try
        {
            manager = getRosterManager();
            manager.addNewTeamToRoster(new Team(0, newTeam));
        }
        catch (DataException unexpected)
        {
            LOG.error("Error adding new team to roster : " + unexpected);
        }
        finally
        {
            if (manager != null)
            {
                manager.releaseResources();
            }
        }
    }

    private void processRosterList(HttpServletRequest request)
    {
        RosterManager manager = null;
        try
        {
            manager = getRosterManager();
            List teams = manager.getTeamsInRoster();
            request.setAttribute("roster", teams);
        }
        catch (DataException unexpected)
        {
            LOG.error("Error processing roster list : " + unexpected);
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