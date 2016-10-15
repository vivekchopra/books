package com.wrox.begjsp.ch27.service;

import com.wrox.begjsp.ch27.dto.ItemFeed;


/**
 * ItemService Service Interface
 */
public interface ItemService
{
    public ItemFeed getItemFeed(String interest) throws WroxServiceException;
}
