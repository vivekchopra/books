package com.wrox.begjsp.ch27.dto;

import java.io.Serializable;

/**
 * A news item
 */
public class NewsItem implements Serializable
{
    /* The headline for the news item */
    private String headline;

    /* A short description for the news item */
    private String description;

    /* The URL for the complete news item */
    private String newsURL; 

    public String getDescription()
    {
        return description;
    }

    public String getHeadline()
    {
        return headline;
    }

    public String getNewsURL() {
        return newsURL;
    }
    
    public void setDescription(String string)
    {
        description = string;
    }

    public void setHeadline(String string)
    {
        headline = string;
    }

    public void setNewsURL(String string) {
        newsURL = string;
    }

}
