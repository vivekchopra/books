package com.wrox.begjsp.ch17.mvc;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SimpleController extends HttpServlet
{
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException
    {
        String action = request.getParameter("action");
        String jspPage = "/index.jsp";

        if ((action == null) || (action.length() < 1))
        {
            action = "default";
        }

        if ("default".equals(action))
        {
            jspPage = "/index.jsp";
        }
        else if ("displaylist".equals(action))
        {
            CustomerManager manager = new CustomerManager();
            List customers = manager.getCustomers();
            request.setAttribute("customers", customers);

            jspPage = "/displayList.jsp";
        }
        else if ("displaycustomer".equals(action))
        {
            String id = request.getParameter("id");
            CustomerManager manager = new CustomerManager();
            Customer customer = manager.getCustomer(id);
            request.setAttribute("customer", customer);

            jspPage = "/displayCustomer.jsp";
        }
        else if ("editcustomer".equals(action))
        {
            String id = request.getParameter("id");
            CustomerManager manager = new CustomerManager();
            Customer customer = manager.getCustomer(id);
            request.setAttribute("customer", customer);

            jspPage = "/editCustomer.jsp";            
        }

        dispatch(jspPage, request, response);
    }

    protected void dispatch(String jsp, HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException
    {
        if (jsp != null)
        {
            RequestDispatcher rd = request.getRequestDispatcher(jsp);
            rd.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }
}
