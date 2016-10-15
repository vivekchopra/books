package com.wrox.begjsp.ch27.dal;


/**
 * Returns instances of Database Access Objects
 */
public class DBFactory
{
    public static PublisherDB getPublisherDB()
    {
        return PublisherDBMemoryImpl.getInstance();
    }

    public static UserProfileDB getUserProfileDB()
    {
        return UserProfileDBMemoryImpl.getInstance();
    }
}
