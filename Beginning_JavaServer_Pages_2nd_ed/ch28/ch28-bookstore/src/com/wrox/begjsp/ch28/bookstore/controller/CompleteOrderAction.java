package com.wrox.begjsp.ch28.bookstore.controller;

import com.wrox.begjsp.ch28.bookstore.BookstoreConstants;
import com.wrox.begjsp.ch28.bookstore.CustomerOrder;
import com.wrox.begjsp.ch28.bookstore.OrderStatus;
import com.wrox.begjsp.ch28.bookstore.ShoppingCart;
import com.wrox.begjsp.ch28.bookstore.persist.EntityManager;
import com.wrox.begjsp.ch28.bookstore.persist.EntityManagerFactory;

import net.sf.hibernate.HibernateException;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;

import java.sql.Date;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CompleteOrderAction extends BookstoreController
{
    public ActionForward doAction(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        DynaValidatorForm validForm = (DynaValidatorForm) form;
        CustomerOrder order = getOrder(request, validForm);
        setCreditDecision(order);
        order = saveOrder(request, order);

        clearCartWhenApproved(request, order);

        request.setAttribute("order", order);

        return mapping.findForward("success");
    }

    private void clearCartWhenApproved(HttpServletRequest request,
        CustomerOrder order)
    {
        if (order.getStatus().getId() == BookstoreConstants.APPROVED_ID)
        {
            clearCart(request);
        }
    }

    private void setCreditDecision(CustomerOrder order)
        throws HibernateException
    {
        EntityManager statusManager = EntityManagerFactory.getOrderStatusManagerInstance();
        OrderStatus declined = (OrderStatus) statusManager.findById(BookstoreConstants.DECLINED_ID);
        OrderStatus approved = (OrderStatus) statusManager.findById(BookstoreConstants.APPROVED_ID);

        if (order.getCardNumber().equals("4111111111111111"))
        {
            order.setStatus(approved);
        }
        else
        {
            order.setStatus(declined);
        }
    }

    private CustomerOrder getOrder(HttpServletRequest request,
        DynaValidatorForm form)
    {
        Calendar cal = Calendar.getInstance();
        ShoppingCart cart = getOrCreateCart(request);

        String firstName = (String) form.get("firstName");
        String lastName = (String) form.get("lastName");
        String address = (String) form.get("address");
        String zipCode = (String) form.get("zipCode");
        String cardNumber = (String) form.get("cardNumber");

        CustomerOrder newOrder = new CustomerOrder();
        newOrder.setFirstName(firstName);
        newOrder.setLastName(lastName);
        newOrder.setAddress(address);
        newOrder.setZipCode(zipCode);
        newOrder.setCardNumber(cardNumber);
        newOrder.setOrderItems(cart.getItems());
        newOrder.setOrderDate(new Date(cal.getTimeInMillis()));

        return newOrder;
    }

    private CustomerOrder saveOrder(HttpServletRequest request,
        CustomerOrder order) throws HibernateException
    {
        EntityManager orderManager = EntityManagerFactory.getOrderManagerInstance();
        order = (CustomerOrder) orderManager.saveOrUpdate(order);

        return order;
    }
}
