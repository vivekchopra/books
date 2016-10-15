package com.wrox.begjsp.ch27.struts;

import org.apache.struts.config.ModuleConfig;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;


/**
 * Check for a valid User logged on in the current session.  If there is no
 * such user, forward control to the logon page.
 */
public final class CheckLogonTag extends TagSupport
{
    private String name = WebappConstants.PROFILE_OBJECT;

    /**
     * The page to which we should forward for the user to log on.
     */
    private String page = "/logon.jsp";

    /**
     * Return the bean name.
     */
    public String getName()
    {
        return (this.name);
    }

    /**
     * Set the bean name.
     *
     * @param name The new bean name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Return the forward page.
     */
    public String getPage()
    {
        return (this.page);
    }

    /**
     * Set the forward page.
     *
     * @param page The new forward page
     */
    public void setPage(String page)
    {
        this.page = page;
    }

    /**
    * Defer our checking until the end of this tag is encountered.
    *
    * @exception JspException if a JSP exception has occurred
    */
    public int doStartTag() throws JspException
    {
        return (SKIP_BODY);
    }

    /**
     * Perform our logged-in user check by looking for the existence of
     * a session scope bean under the specified name.  If this bean is not
     * present, control is forwarded to the specified logon page.
     *
     * @exception JspException if a JSP exception has occurred
     */
    public int doEndTag() throws JspException
    {
        // Is there a valid user logged on?
        boolean valid = false;
        HttpSession session = pageContext.getSession();

        if ((session != null) && (session.getAttribute(name) != null))
        {
            valid = true;
        }

        // Forward control based on the results
        if (valid)
        {
            return (EVAL_PAGE);
        }
        else
        {
            ModuleConfig config = (ModuleConfig) pageContext.getServletContext()
                                                            .getAttribute(org.apache.struts.Globals.MODULE_KEY);

            try
            {
                pageContext.forward(config.getPrefix() + page);
            }
            catch (ServletException e)
            {
                throw new JspException(e.toString());
            }
            catch (IOException e)
            {
                throw new JspException(e.toString());
            }

            return (SKIP_PAGE);
        }
    }

    /**
     * Release any acquired resources.
     */
    public void release()
    {
        super.release();
        this.name = WebappConstants.PROFILE_OBJECT;
        this.page = "/logon.jsp";
    }
}
