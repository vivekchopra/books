package com.wrox.begjsp.ch28.bookstore.controller;

import com.wrox.begjsp.ch28.bookstore.persist.EntityManager;
import com.wrox.begjsp.ch28.bookstore.persist.EntityManagerFactory;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SalesReportAction extends BookstoreController
{
    public ActionForward doAction(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        EntityManager manager = EntityManagerFactory.getOrderManagerInstance();
        List orders = manager.findAllOrdered("status", true);
        request.setAttribute("orders", orders);

        return mapping.findForward("success");
    }
}
