package com.wrox.begjsp.ch27.dal;

import com.wrox.begjsp.ch27.dto.Publisher;

import java.util.List;


/**
 * Interface for the database access layer for Publishers
 */
public interface PublisherDB
{
    public List getPublishers() throws DatabaseException;

    public Publisher getPublisher(String feedUrl) throws DatabaseException;
}
