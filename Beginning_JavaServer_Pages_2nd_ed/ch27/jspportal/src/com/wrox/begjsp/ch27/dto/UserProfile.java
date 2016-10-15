package com.wrox.begjsp.ch27.dto;

import java.io.Serializable;


/**
 * User Profile
 */
public class UserProfile implements Serializable
{
    /* The values of the status codes */
    final public static int STATUS_ERROR            = -1;
    final public static int STATUS_INVALID_USER     = 1;
    final public static int STATUS_INVALID_PASSWORD = 2;
    final public static int STATUS_LOGGED_IN        = 3;
    final public static int STATUS_NOT_LOGGED_IN    = 4;

    /* Status of a user- used to indicate invalid,logged in or not 
     * logged in users 
     */
    private int status;

    /* The username for logging in */
    private String userName;

    /* The password for logging in */
    private String password;

    /* The display name on account, defaults to userName */
    private String displayName;

    /* The news feeds the user has subscribed to */
    private String[] subscriptions;

    /* A list of keywords indicating user's interests */
    private String[] interests;

    public String getDisplayName()
    {
        return displayName;
    }

    public String[] getInterests()
    {
        return interests;
    }

    public String getPassword()
    {
        return password;
    }

    public int getStatus()
    {
        return status;
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

    public void setInterests(String[] strings)
    {
        interests = strings;
    }

    public void setPassword(String string)
    {
        password = string;
    }

    public void setStatus(int i)
    {
        status = i;
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
