package com.wrox.begjsp.ch23.football;

import java.sql.Connection;

public class RosterManagerFactory
{
    public static final String JDBC_MANAGER      = "JDBC";
    public static final String HIBERNATE_MANAGER = "HIBERNATE";

    private static String      _currentManager   = JDBC_MANAGER;

    public static void setRosterManagerType(String type)
    {
        _currentManager = type;
    }

    public static RosterManager createRosterManager(Connection connection)
    {
        if (JDBC_MANAGER.equals(_currentManager))
        {
            return new JDBCRosterManager(connection);
        }
        else if (HIBERNATE_MANAGER.equals(_currentManager))
        {
            return new HibernateRosterManager(connection);
        }
        throw new IllegalStateException(_currentManager + " persistence not implemented");
    }
}