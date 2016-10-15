package com.wrox.begjsp.ch27.dto;

import java.io.Serializable;


/**
 * A publisher entry registered with the website
 */
public class Publisher implements Serializable
{
    /* Name of the publisher */
    private String name;

    /* Description of the news feed */
    private String description;

    /* The RSS URL for the news feed */
    private String feedUrl;

    /* The category this news feed can be classified under */
    private String category;

    public Publisher()
    {
        // Do nothing
    }

    public Publisher(String name, String description, String category,
        String feedUrl)
    {
        this.name = name;
        this.description = description;
        this.category = category;
        this.feedUrl = feedUrl;
    }

    public String getCategory()
    {
        return category;
    }

    public String getDescription()
    {
        return description;
    }

    public String getFeedUrl()
    {
        return feedUrl;
    }

    public String getName()
    {
        return name;
    }

    public void setCategory(String string)
    {
        category = string;
    }

    public void setDescription(String string)
    {
        description = string;
    }

    public void setFeedUrl(String string)
    {
        feedUrl = string;
    }

    public void setName(String string)
    {
        name = string;
    }
}
