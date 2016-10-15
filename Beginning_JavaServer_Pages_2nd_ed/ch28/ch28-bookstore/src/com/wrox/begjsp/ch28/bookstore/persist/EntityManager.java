package com.wrox.begjsp.ch28.bookstore.persist;

import com.wrox.begjsp.ch28.bookstore.BaseEntity;

import net.sf.hibernate.Criteria;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;


public class EntityManager
{
    private Class _cl;

    protected EntityManager(Class cl)
    {
        _cl = cl;
    }

    public List findAll() throws HibernateException
    {
        List rv = new ArrayList();

        Session session = SessionProvider.currentSession();
        Criteria criteria = session.createCriteria(_cl);
        rv = criteria.list();

        return rv;
    }

    public List findAllOrdered(String orderBy, boolean desc)
        throws HibernateException
    {
        String direction = (desc ? "desc" : "asc");
        Session session = SessionProvider.currentSession();
        String qry = "from " + _cl.getName() + " as e order by e." + orderBy +
            " " + direction;
        Query q = session.createQuery(qry);
        List result = q.list();

        return result;
    }

    public BaseEntity findById(int id) throws HibernateException
    {
        Session session = SessionProvider.currentSession();
        BaseEntity rv = (BaseEntity) session.get(_cl, new Integer(id));

        return rv;
    }

    public BaseEntity saveOrUpdate(BaseEntity entity) throws HibernateException
    {
        Session session = SessionProvider.currentSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(entity);
        tx.commit();

        return entity;
    }
}
