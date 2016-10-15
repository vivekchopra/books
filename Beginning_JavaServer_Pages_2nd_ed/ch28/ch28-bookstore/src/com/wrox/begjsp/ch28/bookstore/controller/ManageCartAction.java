package com.wrox.begjsp.ch28.bookstore.controller;

import com.wrox.begjsp.ch28.bookstore.OrderItem;
import com.wrox.begjsp.ch28.bookstore.ShoppingCart;
import com.wrox.begjsp.ch28.bookstore.util.NumericUtil;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ManageCartAction extends BookstoreController
{
    public ActionForward doAction(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        ManageCartForm cartForm = (ManageCartForm) form;
        String command = cartForm.getCommand();

        if ("update".equals(command))
        {
            updateCart(request, cartForm);
        }
        else if ("clear".equals(command))
        {
            clearCart(request);

            return mapping.findForward("home");
        }

        ShoppingCart cart = getOrCreateCart(request);

        initializeForm(cartForm, cart);

        return mapping.findForward("success");
    }

    private void updateCart(HttpServletRequest request, ManageCartForm form)
    {
        ShoppingCart cart = getOrCreateCart(request);
        Map values = form.getValues();
        Set items = cart.getItems();
        List itemsArr = new ArrayList(items);
        Iterator it = itemsArr.iterator();

        while (it.hasNext())
        {
            OrderItem item = (OrderItem) it.next();
            String newQty = (String) values.get(String.valueOf(item.getBookId()));

            if (NumericUtil.isInteger(newQty))
            {
                int qty = Integer.parseInt(newQty);

                if (qty > 0)
                {
                    item.setQty(qty);
                    cart.replaceItem(item);
                }
                else
                {
                    cart.removeItem(item);
                }
            }
        }
    }

    private void initializeForm(ManageCartForm form, ShoppingCart cart)
    {
        Set items = cart.getItems();
        Iterator it = items.iterator();

        while (it.hasNext())
        {
            OrderItem item = (OrderItem) it.next();
            form.setValue(String.valueOf(item.getBookId()),
                new Integer(item.getQty()));
        }
    }
}
