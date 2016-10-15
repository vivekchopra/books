package com.wrox.begjsp.ch27.dto;

import java.io.Serializable;


/**
 * A group of items that the user might be interested in
 */
public class ItemFeed implements Serializable
{
    /* A descriptive name for the set of items */
    private String itemFeedName;

    /* The group of items the user might be interested in */
    private InterestItem[] interestItem;

    public InterestItem[] getInterestItem()
    {
        return interestItem;
    }

    public String getItemFeedName()
    {
        return itemFeedName;
    }

    public void setInterestItem(InterestItem[] items)
    {
        interestItem = items;
    }

    public void setItemFeedName(String string)
    {
        itemFeedName = string;
    }
}
