package com.wrox.begjsp.ch24.roster;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class SecurityFilter implements Filter
{
    private Map _roster = new HashMap();

    public void init(FilterConfig config)
    {
        _roster.put("staff1", "Monday");
        _roster.put("staff2", "Tuesday");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException
    {
        if (request instanceof HttpServletRequest)
        {
            HttpServletRequest httpRequest = (HttpServletRequest)request;

            httpRequest.setAttribute("staffRoster", _roster);
            
            boolean isAdmin = httpRequest.isUserInRole("manager");
            httpRequest.setAttribute("isAdmin", Boolean.valueOf(isAdmin));
            
            Calendar timeNow = Calendar.getInstance();
            int hour = timeNow.get(Calendar.HOUR_OF_DAY);

            boolean isBusiness = ((hour >= 9) && (hour <= 17));
            httpRequest.setAttribute("isBusiness", Boolean.valueOf(isBusiness));
        }

        chain.doFilter(request, response);
    }

    public void destroy()
    {
        // do nothing
    }

}