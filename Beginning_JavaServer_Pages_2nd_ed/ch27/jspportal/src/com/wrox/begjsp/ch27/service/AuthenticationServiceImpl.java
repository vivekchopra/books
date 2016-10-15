package com.wrox.begjsp.ch27.service;

import com.wrox.begjsp.ch27.dto.UserProfile;
import com.wrox.begjsp.ch27.dal.DatabaseException;
import com.wrox.begjsp.ch27.dal.UserProfileDB;
import com.wrox.begjsp.ch27.dal.UserProfileDBMemoryImpl;


/**
 * An implementation of authentication service
 */
public class AuthenticationServiceImpl implements AuthenticationService
{
    /**
     * Check user credentials, and return profile on successful login. If
     * login is unsuccessful, an empty user profile is returned with status
     * set to UserProfile.STATUS_INVALID_USER.
     *
     * @param username The username
     * @param password The password
     * @return User profile object
     */
    public UserProfile login(String username, String password)
        throws WroxServiceException
    {
        UserProfile userProfile = null;

        int status = UserProfile.STATUS_LOGGED_IN;

        try
        {
            userProfile = UserProfileDBMemoryImpl.getInstance().getUserProfile(username);

            if (userProfile == null)
            {
                status = UserProfile.STATUS_INVALID_USER;
            }
            else if (!password.equals(userProfile.getPassword()))
            {
                status = UserProfile.STATUS_INVALID_PASSWORD;
            }
        }
        catch (DatabaseException e)
        {
            // log database error
            status = UserProfile.STATUS_ERROR;
        }

        if (userProfile == null)
        {
            userProfile = new UserProfile();
        }

        userProfile.setStatus(status);

        return userProfile;
    }
}
