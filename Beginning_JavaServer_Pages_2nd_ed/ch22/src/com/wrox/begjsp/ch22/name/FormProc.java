package com.wrox.begjsp.ch22.name;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormProc extends HttpServlet
{
    private static final String INPUT_JSP  = "/input.jsp";
    private static final String OUTPUT_JSP = "/output.jsp";

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String userName = request.getParameter("userName");

        if ((userName == null) || (userName.length() == 0))
        {
            forwardToJSP(FormProc.INPUT_JSP, request, response);
        }
        else
        {
            request.setAttribute("user", userName);
            request.setAttribute("now", new Date());
            forwardToJSP(FormProc.OUTPUT_JSP, request, response);
        }
    }

    private void forwardToJSP(String target, HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        RequestDispatcher dispatcher = request.getRequestDispatcher(target);
        dispatcher.forward(request, response);
    }
}