package com.wrox.begjsp.ch27.dal;

import com.wrox.begjsp.ch27.dto.UserProfile;


/**
 * Interface for the database access layer for UserProfile objects
 */
public interface UserProfileDB
{
    public UserProfile getUserProfile(String username)
        throws DatabaseException;

    public void updateUserProfile(UserProfile userProfile)
        throws DatabaseException;

    public void insertUserProfile(UserProfile userProfile)
        throws DatabaseException;

    public void deleteUserProfile(String username) throws DatabaseException;
}
