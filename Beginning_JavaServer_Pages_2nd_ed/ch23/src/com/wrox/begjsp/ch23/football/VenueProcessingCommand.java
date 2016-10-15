package com.wrox.begjsp.ch23.football;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class VenueProcessingCommand extends AbstractProcessingCommand
{
    private static final Logger LOG              = Logger.getLogger(VenueProcessingCommand.class);

    private static final String VENUE_PAGE       = "venue.jsp";
    private static final String VENUE_LIST_TOKEN = "venues";

    private static final String ACTION_VENUE_ADD = "VENUE_ADD";
    private static final String ACTION_VENUE_MOD = "VENUE_MODIFY";
    private static final String ACTION_VENUE_DEL = "VENUE_DELETE";

    private FootyJDBCHelper     _helper          = null;

    public VenueProcessingCommand(FootyJDBCHelper helper)
    {
        _helper = helper;
    }

    public void execute(HttpServletRequest request, HttpServletResponse response, String action)
            throws ServletException, IOException
    {
        if (ACTION_VENUE_ADD.equals(action))
        {
            String newNameString = request.getParameter("venuename");
            if (isValidString(newNameString))
            {
                processVenueAdd(newNameString);
            }
        }
        else if (ACTION_VENUE_DEL.equals(action))
        {
            String deleteIDs[] = request.getParameterValues("DELETE_LIST");
            if (deleteIDs != null)
            {
                for (int i = 0; i < deleteIDs.length; i++)
                {
                    String idString = deleteIDs[i];
                    int id = Integer.parseInt(idString);
                    processVenueDelete(id);
                }
            }
        }
        else if (ACTION_VENUE_MOD.equals(action))
        {
            String modIdString = request.getParameter("venueid");
            int modId = Integer.parseInt(modIdString);
            String modVenue = request.getParameter("venuename");
            if (isValidString(modVenue) && (modId > 0))
            {
                processVenueModify(new Venue(modId, modVenue));
            }
        }
        processVenueList(request);
        performRedirect(VENUE_PAGE, request, response);
    }

    private void processVenueModify(Venue venue)
    {
        RosterManager manager = null;
        try
        {
            manager = getRosterManager();
            manager.modifyVenueInRoster(venue);
        }
        catch (DataException unexpected)
        {
            LOG.error("Error modifying venue : " + unexpected);
        }
        finally
        {
            if (manager != null)
            {
                manager.releaseResources();
            }
        }
    }

    private void processVenueDelete(int teamId)
    {
        RosterManager manager = null;
        try
        {
            manager = getRosterManager();
            manager.deleteVenueFromRoster(teamId);
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

    private void processVenueAdd(String newVenue)
    {
        RosterManager manager = null;
        try
        {
            manager = getRosterManager();
            manager.addNewVenueToRoster(new Venue(0, newVenue));
        }
        catch (DataException unexpected)
        {
            LOG.error("Error adding new venue : " + unexpected);
        }
        finally
        {
            if (manager != null)
            {
                manager.releaseResources();
            }
        }
    }

    private void processVenueList(HttpServletRequest request)
    {
        RosterManager manager = null;
        try
        {
            manager = getRosterManager();
            List venue = manager.getVenuesInRoster();
            request.setAttribute(VENUE_LIST_TOKEN, venue);
        }
        catch (DataException unexpected)
        {
            LOG.error("Error processing venue list : " + unexpected);
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