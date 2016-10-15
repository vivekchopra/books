package com.wrox.begjsp.ch20.struts;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.tiles.beans.MenuItem;
import org.apache.struts.tiles.beans.SimpleMenuItem;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FooBarAction extends Action
{
    public ActionForward execute(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        request.setAttribute("actionMenuItems", getMenuItems());
        request.setAttribute("animatedMovies", getMovies());

        return mapping.findForward("success");
    }

    private List getMenuItems()
    {
        List menuItems = new ArrayList();
        menuItems.add(getMenuItem("http://java.sun.com/", "Java Home"));
        menuItems.add(getMenuItem("http://www.cnn.com/", "CNN"));
        menuItems.add(getMenuItem("http://slashdot.org/", "Slashdot"));

        return menuItems;
    }

    private MenuItem getMenuItem(String link, String value)
    {
        MenuItem item = new SimpleMenuItem();
        item.setLink(link);
        item.setValue(value);

        return item;
    }

    private List getMovies()
    {
        List movies = new ArrayList();
        movies.add("Shrek 2");
        movies.add("Finding Nemo");
        movies.add("Toy Story");
        movies.add("The Lion King");
        movies.add("Monsters Inc.");

        return movies;
    }
}
