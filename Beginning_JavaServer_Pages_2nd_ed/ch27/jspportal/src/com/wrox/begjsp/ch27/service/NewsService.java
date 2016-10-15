package com.wrox.begjsp.ch27.service;

import com.wrox.begjsp.ch27.dto.NewsFeed;


/**
 * NewsService Service Interface
 */
public interface NewsService
{
    public NewsFeed getNewsFeed(String subscription) throws WroxServiceException;
}
