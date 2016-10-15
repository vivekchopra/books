package com.wrox.begjsp.ch27.dto;

import java.io.Serializable;


/**
 * A news feed from a publisher that the user has subscribed to
 */
public class NewsFeed implements Serializable
{
    /* The name/title of the news provider */
    private String title;

    /* A short description for the news provider */
    private String description;

    /* A group of news items from this news provider */
    private NewsItem[] items;

    public String getDescription()
    {
        return description;
    }

    public String getTitle()
    {
        return title;
    }

    public NewsItem[] getItems()
    {
        return items;
    }

    public void setDescription(String string)
    {
        description = string;
    }

    public void setTitle(String string)
    {
        title = string;
    }

    public void setItems(NewsItem[] newsItem)
    {
        items = newsItem;
    }
}
