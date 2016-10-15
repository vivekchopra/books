package com.wrox.book.chapt14;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.NDC;


public class NdcFilter implements Filter
{
    private FilterConfig filterConfig = null;
    
    public NdcFilter()
    {
    }
    
    public void init(FilterConfig fc)
    {
        filterConfig = fc;
    }
    
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException
    {
        // adds the session ID to the NDC
        HttpServletRequest hreq = null;
        if( request instanceof HttpServletRequest )
        {
            hreq = (HttpServletRequest)request;
            HttpSession session = hreq.getSession();
            if( session != null )
                NDC.push(session.getId());
            else
                NDC.push("No session present");
        }
        else
            NDC.push( "Not an HttpServlet request!" );
        chain.doFilter(request, response);
        NDC.pop();
    }

    public void destroy()
    {
    }
}
