package com.wrox.begjsp.ch22.example2;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JDBCShowHelper
{
    private DataSource _dataSource;
    
    public JDBCShowHelper() throws NamingException 
    {
        Context context = new InitialContext();
        Context applicationEnv = (Context)context.lookup("java:comp/env");
        _dataSource = (DataSource)applicationEnv.lookup("jdbc/FootyDB");
    }

    public Connection getConnection() throws SQLException
    {
        return _dataSource.getConnection();
    }
    
}