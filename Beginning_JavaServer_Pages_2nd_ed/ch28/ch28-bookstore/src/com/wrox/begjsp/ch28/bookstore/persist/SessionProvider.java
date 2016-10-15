package com.wrox.begjsp.ch28.bookstore.persist;

import net.sf.hibernate.FlushMode;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.cfg.Configuration;


public class SessionProvider
{
    private static final SessionFactory sessionFactory;
    public static final ThreadLocal session = new ThreadLocal();

    static
    {
        try
        {
            Configuration config = new Configuration();
            config = config.configure("/hibernate.cfg.xml");
            sessionFactory = config.buildSessionFactory();
        }
        catch (HibernateException ex)
        {
            throw new RuntimeException("Exception building SessionFactory: " +
                ex.getMessage(), ex);
        }
    }

    public static Session currentSession() throws HibernateException
    {
        Session s = (Session) session.get();

        // Open a new Session, if this Thread has none yet
        if (s == null)
        {
            s = sessionFactory.openSession();
            s.setFlushMode(FlushMode.COMMIT);
            session.set(s);
        }

        return s;
    }

    public static void closeSession() throws HibernateException
    {
        Session s = (Session) session.get();
        session.set(null);

        if (s != null)
        {
            s.close();
        }
    }
}
