package com.wrox.begjsp.ch23.football;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class RoundProcessingCommand extends AbstractProcessingCommand
{
    private static final Logger LOG                = Logger
                                                           .getLogger(RoundProcessingCommand.class);

    private static final String FIXTURE_PAGE       = "round.jsp";

    // for the dropdown menus
    private static final String ROUND_LIST_TOKEN   = "rounds";
    private static final String ACTION_ROUND_DEL   = "ROUND_DELETE";

    private FootyJDBCHelper     _helper            = null;

    public RoundProcessingCommand(FootyJDBCHelper helper)
    {
        _helper = helper;
    }

    public void execute(HttpServletRequest request, HttpServletResponse response, String action)
            throws ServletException, IOException
    {
        if (ACTION_ROUND_DEL.equals(action))
        {
            String deleteIDs[] = request.getParameterValues("DELETE_LIST");
            if (deleteIDs != null)
            {
                for (int i = 0; i < deleteIDs.length; i++)
                {
                    String idString = deleteIDs[i];
                    int id = Integer.parseInt(idString);
                    processRoundDelete(id);
                }
            }
        }
        processFixtureList(request);
        performRedirect(FIXTURE_PAGE, request, response);
    }

    private void processRoundDelete(int id)
    {
        RosterManager manager = null;
        try
        {
            manager = getRosterManager();
            manager.deleteRoundFromRoster(id);
        }
        catch (DataException unexpected)
        {
            LOG.error("Error deleting venue : " + unexpected);
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
            
            List rounds = manager.getRoundsInRoster();
            
            request.setAttribute(ROUND_LIST_TOKEN, rounds);
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