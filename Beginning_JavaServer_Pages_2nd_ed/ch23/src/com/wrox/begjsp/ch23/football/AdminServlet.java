package com.wrox.begjsp.ch23.football;

import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminServlet extends HttpServlet
{
    private static final String DEFAULT_PAGE    = "menu.html";

    private static final String ACTION_TOKEN    = "ACTION";

    private static final String ROSTER_ACTIONS  = "ROSTER";
    private static final String VENUE_ACTIONS   = "VENUE";
    private static final String FIXTURE_ACTIONS = "FIXTURE";

    private FootyJDBCHelper     _jdbcHelper     = null;

    public void init() throws ServletException
    {
        RosterManagerFactory.setRosterManagerType(RosterManagerFactory.HIBERNATE_MANAGER);
        try
        {
            _jdbcHelper = new FootyJDBCHelper();
        }
        catch (NamingException unexpected)
        {
            throw new ServletException("Cannot locate required database : " + unexpected);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String action = findAction(request);

        ProcessingCommand command = null;
        if (action != null)
        {
            if (action.startsWith(ROSTER_ACTIONS))
            {
                command = new RosterProcessingCommand(_jdbcHelper);
            }

            if (action.startsWith(VENUE_ACTIONS))
            {
                command = new VenueProcessingCommand(_jdbcHelper);
            }

            if (action.startsWith(FIXTURE_ACTIONS))
            {
                command = new FixtureProcessingCommand(_jdbcHelper);
            }

            if (command != null)
            {
                command.execute(request, response, action);
                return;
            }
        }
        RequestDispatcher dispatch = request.getRequestDispatcher(DEFAULT_PAGE);
        dispatch.forward(request, response);
    }

    private String findAction(HttpServletRequest request)
    {
        return request.getParameter(ACTION_TOKEN);
    }
}