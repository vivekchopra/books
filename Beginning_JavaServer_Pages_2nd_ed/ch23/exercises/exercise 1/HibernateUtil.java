package com.wrox.begjsp.ch23.football;

import java.sql.Connection;
import java.util.Properties;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.MappingException;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.cfg.Configuration;

/*
 * Basis of HibernateUtil from http://www.hibernate.org/ documentation
 */
public class HibernateUtil
{
    private static final SessionFactory _sessionFactory;

    static
    {
        Configuration configuration = new Configuration();
        try
        {
            configuration.addClass(Team.class);
            configuration.addClass(Venue.class);
            configuration.addClass(Round.class);
            configuration.addClass(Fixture.class);
        }
        catch (MappingException mappingFailure)
        {
            throw new IllegalArgumentException(
                "Cannot find required object classes, check CLASSPATH : " 
                + mappingFailure);
        }
        Properties props = new Properties();
        props.put("hibernate.dialect", "net.sf.hibernate.dialect.MySQLDialect");
        props.put("hibernate.statement_cache.size", "0");
        configuration.setProperties(props);

        try
        {
            _sessionFactory = configuration.buildSessionFactory();
        }
        catch (HibernateException sessionFailure)
        {
            throw new IllegalArgumentException(
                "Cannot build session factory, check configuration : " 
                + sessionFailure);
        }
    }

    public static final ThreadLocal     _session = new ThreadLocal();

    public static Session currentSession(Connection connection)
    {
        Session s = (Session)_session.get();
        if (s == null)
        {
            s = _sessionFactory.openSession(connection);
            _session.set(s);
        }
        return s;
    }
   
    public static void closeSession() throws HibernateException
    {
        Session s = (Session)_session.get();
        _session.set(null);
        if (s != null)
        {
            s.close();
        }
    }
}
