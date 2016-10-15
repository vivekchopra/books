package com.wrox.begjsp.ch22.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JDBCHelper
{
    private DataSource _dataSource;
    private GameManager _manager;
    
    public JDBCHelper() throws Exception
    {
        Context context = new InitialContext();
        Context applicationEnv = (Context)context.lookup("java:comp/env");
        _dataSource = (DataSource)applicationEnv.lookup("jdbc/FootyDB");
        
        _manager = new GameManager(getConnection());
    }

    private Connection getConnection() throws SQLException
    {
        return _dataSource.getConnection();
    }

    public List getResults() 
    {
        List results;
        try
        {
            results = _manager.getResults();
        }
        catch (Exception unexpected)
        {
            results = new ArrayList();
        }
        return results;
    }
}