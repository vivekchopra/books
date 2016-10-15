package com.wrox.begjsp.ch28.bookstore.controller;

import com.wrox.begjsp.ch28.bookstore.Category;
import com.wrox.begjsp.ch28.bookstore.OrderItem;
import com.wrox.begjsp.ch28.bookstore.ShoppingCart;
import com.wrox.begjsp.ch28.bookstore.persist.SessionProvider;

import net.sf.hibernate.HibernateException;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public abstract class BookstoreController extends Action
{
    private final static String CART_NAME = "cart";

    public abstract ActionForward doAction(ActionMapping mapping,
        ActionForm form, HttpServletRequest request,
        HttpServletResponse response) throws Exception;

    public ActionForward execute(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        intialize(request);

        ActionForward fwd = doAction(mapping, form, request, response);
        cleanUp();

        return fwd;
    }

    protected void cleanUp() throws HibernateException
    {
        SessionProvider.closeSession();
    }

    protected void intialize(HttpServletRequest request)
    {
        getOrCreateCart(request);
    }

    protected ShoppingCart getOrCreateCart(HttpServletRequest request)
    {
        HttpSession session = request.getSession(true);
        ShoppingCart cart = (ShoppingCart) session.getAttribute(CART_NAME);

        if (cart == null)
        {
            cart = new ShoppingCart();
            session.setAttribute(CART_NAME, cart);
        }

        return cart;
    }

    protected void addItemToCart(HttpServletRequest request, OrderItem item)
    {
        ShoppingCart cart = getOrCreateCart(request);
        cart.addOrIncrementItem(item);
    }

    protected void removeItemFromCart(HttpServletRequest request, OrderItem item)
    {
        ShoppingCart cart = getOrCreateCart(request);
        cart.removeItem(item);
    }

    protected void clearCart(HttpServletRequest request)
    {
        ShoppingCart cart = getOrCreateCart(request);
        cart.clear();
    }

    protected void prepareForBrowseCategory(HttpServletRequest request,
        Category cat)
    {
        List books = cat.getBooks();
        request.setAttribute("category", cat);
        request.setAttribute("books", books);
        request.setAttribute("bookCount", String.valueOf(books.size()));
    }
}
