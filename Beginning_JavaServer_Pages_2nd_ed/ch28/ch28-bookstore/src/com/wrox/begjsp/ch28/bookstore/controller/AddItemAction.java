package com.wrox.begjsp.ch28.bookstore.controller;

import com.wrox.begjsp.ch28.bookstore.Book;
import com.wrox.begjsp.ch28.bookstore.Category;
import com.wrox.begjsp.ch28.bookstore.OrderItem;
import com.wrox.begjsp.ch28.bookstore.persist.EntityManager;
import com.wrox.begjsp.ch28.bookstore.persist.EntityManagerFactory;
import com.wrox.begjsp.ch28.bookstore.util.NumericUtil;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddItemAction extends BookstoreController
{
    public ActionForward doAction(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        String book = request.getParameter("book");

        if (!NumericUtil.isInteger(book))
        {
            return mapping.findForward("home");
        }

        int bookId = NumericUtil.getInt(book);
        EntityManager manager = EntityManagerFactory.getBookManagerInstance();
        Book bookToAdd = (Book) manager.findById(bookId);
        OrderItem item = getOrderItem(bookToAdd, 1);
        addItemToCart(request, item);

        Category category = bookToAdd.getCategory();
        prepareForBrowseCategory(request, category);

        return mapping.findForward("success");
    }

    private OrderItem getOrderItem(Book book, int qty)
    {
        OrderItem item = new OrderItem();
        item.setBook(book);
        item.setQty(qty);
        item.setUnitPrice(book.getUnitPrice());

        return item;
    }
}
