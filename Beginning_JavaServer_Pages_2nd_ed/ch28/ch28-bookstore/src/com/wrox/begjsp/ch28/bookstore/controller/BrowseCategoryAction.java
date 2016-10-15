package com.wrox.begjsp.ch28.bookstore.controller;

import com.wrox.begjsp.ch28.bookstore.Category;
import com.wrox.begjsp.ch28.bookstore.persist.EntityManager;
import com.wrox.begjsp.ch28.bookstore.persist.EntityManagerFactory;
import com.wrox.begjsp.ch28.bookstore.util.NumericUtil;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BrowseCategoryAction extends BookstoreController
{
    public ActionForward doAction(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        String category = request.getParameter("cat");

        if (!NumericUtil.isInteger(category))
        {
            return mapping.findForward("home");
        }

        int categoryId = NumericUtil.getInt(category);
        EntityManager manager = EntityManagerFactory.getCategoryManagerInstance();

        Category cat = (Category) manager.findById(categoryId);
        prepareForBrowseCategory(request, cat);

        return mapping.findForward("success");
    }
}
