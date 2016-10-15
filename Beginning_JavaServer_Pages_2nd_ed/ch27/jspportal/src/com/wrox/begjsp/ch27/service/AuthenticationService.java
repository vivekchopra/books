package com.wrox.begjsp.ch27.service;

import com.wrox.begjsp.ch27.dto.UserProfile;


/**
 * AuthenticationService Service Interface
 */
public interface AuthenticationService
{
    /**
     * Check user credentials, and return profile
     * @param username The username
     * @param password The password
     * @return User profile object
     */
    public UserProfile login(String username, String password)
        throws WroxServiceException;
}
