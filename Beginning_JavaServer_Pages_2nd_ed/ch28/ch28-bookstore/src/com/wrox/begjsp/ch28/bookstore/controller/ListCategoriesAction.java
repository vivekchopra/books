package com.wrox.begjsp.ch28.bookstore.controller;

import com.wrox.begjsp.ch28.bookstore.persist.EntityManager;
import com.wrox.begjsp.ch28.bookstore.persist.EntityManagerFactory;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ListCategoriesAction extends BookstoreController
{
    public ActionForward doAction(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        EntityManager manager = EntityManagerFactory.getCategoryManagerInstance();
        List categories = manager.findAll();
        request.setAttribute("categories", categories);

        return mapping.findForward("success");
    }
}
