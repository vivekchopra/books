package com.wrox.begjsp.ch23.football;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * AbstractProcessingCommand
 */
public abstract class AbstractProcessingCommand implements ProcessingCommand
{
    public abstract void execute(HttpServletRequest request, HttpServletResponse response,
            String action) throws ServletException, IOException;
    

    public final boolean isValidString(String input)
    {
        return ((input != null) && (input.length() > 0));
    }

    public final void performRedirect(String path, HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        if (path != null)
        {
            request.setAttribute("SERVLET_PATH", request.getContextPath()
                    + request.getServletPath());
            RequestDispatcher dispatch = request.getRequestDispatcher(path);
            dispatch.forward(request, response);
        }
    }

}
