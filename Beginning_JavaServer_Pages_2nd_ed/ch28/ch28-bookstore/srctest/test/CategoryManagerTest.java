package test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;

import junit.framework.TestCase;
import net.sf.hibernate.HibernateException;

import com.wrox.begjsp.ch28.bookstore.Book;
import com.wrox.begjsp.ch28.bookstore.Category;
import com.wrox.begjsp.ch28.bookstore.CustomerOrder;
import com.wrox.begjsp.ch28.bookstore.OrderItem;
import com.wrox.begjsp.ch28.bookstore.OrderStatus;
import com.wrox.begjsp.ch28.bookstore.persist.EntityManager;
import com.wrox.begjsp.ch28.bookstore.persist.EntityManagerFactory;


public class CategoryManagerTest extends TestCase
{
    public void ttestAddNewCategory() throws HibernateException
    {
        Category cat = new Category();
        cat.setDescription("My Description");
        cat.setName("My Name");

        EntityManager manager = EntityManagerFactory.getCategoryManagerInstance();
        manager.saveOrUpdate(cat);
        assertFalse(cat.getId() == 0);
    }

    public void ttestGetCategory() throws HibernateException
    {
        EntityManager manager = EntityManagerFactory.getCategoryManagerInstance();
        Category cat = (Category) manager.findById(1);
        assertEquals("Check ID of Catalogue", 1, cat.getId());
    }

    public void ttestUpdateCategory() throws HibernateException
    {
        EntityManager manager = EntityManagerFactory.getCategoryManagerInstance();
        Category cat = (Category) manager.findById(1);

        cat.setName("Rupert");
        manager.saveOrUpdate(cat);

        cat = (Category) manager.findById(1);
        assertEquals("Check New Name", "Rupert", cat.getName());
    }
    
    public void testGetOrder() throws HibernateException
    {
        EntityManager manager = EntityManagerFactory.getOrderManagerInstance();
        manager.findById(40);
    }
        
    public void ttestInsertOrder() throws HibernateException    
    {
        EntityManager manager = EntityManagerFactory.getOrderManagerInstance();
        EntityManager statusManager = EntityManagerFactory.getOrderStatusManagerInstance();
        EntityManager bookManager = EntityManagerFactory.getBookManagerInstance();
        //EntityManager itemManager = EntityManagerFactory.getOrderItemManagerInstance();
        Book book = (Book) bookManager.findById(1);

        OrderItem item = new OrderItem();
        item.setBook(book);
        item.setQty(2);
        item.setUnitPrice(120.0f);
        List items = new ArrayList();
        items.add(item);
         
        OrderStatus status = (OrderStatus) statusManager.findById(1);
        Calendar cal = Calendar.getInstance();
        CustomerOrder order = new CustomerOrder();
        order.setAddress("bah");
        order.setFirstName("gfe");
        order.setLastName("dda");
        order.setCardNumber("33233");
        order.setZipCode("4534");
        order.setStatus(status);
        order.setOrderItems(new HashSet(items));
        order.setOrderDate(new Date(cal.getTimeInMillis()));
        manager.saveOrUpdate(order);
    }
}
