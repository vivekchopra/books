package com.wrox.begjsp.ch27.dto;

import java.io.Serializable;


/**
 * Items that the user might be interested in
 */
public class InterestItem implements Serializable
{
    /* The URL to the image for the item */
    private String imageUrl;

    /* The name of the item */
    private String itemName;

    /* The URL to the item */
    private String itemUrl;

    public String getImageUrl()
    {
        return imageUrl;
    }

    public String getItemName()
    {
        return itemName;
    }

    public String getItemUrl()
    {
        return itemUrl;
    }

    public void setImageUrl(String string)
    {
        imageUrl = string;
    }

    public void setItemName(String string)
    {
        itemName = string;
    }

    public void setItemUrl(String string)
    {
        itemUrl = string;
    }
}
