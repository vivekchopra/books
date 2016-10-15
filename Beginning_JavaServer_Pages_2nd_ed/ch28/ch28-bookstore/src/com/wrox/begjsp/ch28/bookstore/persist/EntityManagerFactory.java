package com.wrox.begjsp.ch28.bookstore.persist;

import com.wrox.begjsp.ch28.bookstore.Book;
import com.wrox.begjsp.ch28.bookstore.Category;
import com.wrox.begjsp.ch28.bookstore.CustomerOrder;
import com.wrox.begjsp.ch28.bookstore.OrderStatus;


public class EntityManagerFactory
{
    public static EntityManager getBookManagerInstance()
    {
        return new EntityManager(Book.class);
    }

    public static EntityManager getCategoryManagerInstance()
    {
        return new EntityManager(Category.class);
    }

    public static EntityManager getOrderManagerInstance()
    {
        return new EntityManager(CustomerOrder.class);
    }

    public static EntityManager getOrderStatusManagerInstance()
    {
        return new EntityManager(OrderStatus.class);
    }
}
