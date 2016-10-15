package com.wrox.begjsp.ch27.struts;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Form bean for the user registration page
 */
public final class RegistrationForm extends ActionForm
{
    /**
     * The maintenance action we are performing (Create or Edit).
     */
    private String action = "Create";

    /* The username for logging in */
    private String userName;

    /* The password for logging in */
    private String password;

    /* The display name on account, defaults to userName */
    private String displayName;

    /* The news feeds the user has subscribed to */
    private String subscriptions[];

    /* A list of keywords indicating user's interests */
    private String interests;

    /**
     * Return the maintenance action.
     */
    public String getAction()
    {
        return (this.action);
    }

    /**
     * Set the maintenance action.
     *
     * @param action The new maintenance action.
     */
    public void setAction(String action)
    {
        this.action = action;
    }

    /**
     * Reset all properties to their default values.
     *
     * @param mapping The mapping used to select this instance
     * @param request The servlet request we are processing
     */
    public void reset(ActionMapping mapping, HttpServletRequest request)
    {
        this.action = "Create";
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public String getInterests()
    {
        return interests;
    }

    public String getPassword()
    {
        return password;
    }

    public String[] getSubscriptions()
    {
        return subscriptions;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setDisplayName(String string)
    {
        displayName = string;
    }

    public void setInterests(String strings)
    {
        interests = strings;
    }

    public void setPassword(String string)
    {
        password = string;
    }

    public void setSubscriptions(String[] strings)
    {
        subscriptions = strings;
    }

    public void setUserName(String string)
    {
        userName = string;
    }
}
