package com.wrox.begjsp.ch27.service;

import com.wrox.begjsp.ch27.dto.NewsFeed;
import com.wrox.begjsp.ch27.dto.NewsItem;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeedI;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * An implementation of the NewsService
 */
public class NewsServiceImpl implements NewsService
{
    private static final Pattern CHARSET_PATTERN = Pattern.compile(
            "charset=([.[^; ]]*)");

    public NewsFeed getNewsFeed(String subscription) throws WroxServiceException
    {
        NewsFeed newsFeed = new NewsFeed();
        URL channelUrl = null;

        try
        {
            channelUrl = new URL(subscription);
        }
        catch (MalformedURLException e)
        {
            throw new WroxServiceException("Invalid RSS feed URL " + subscription, e);
        }

        SyndFeedInput input = new SyndFeedInput();

        SyndFeedI feed = null;

        try
        {
            feed = input.build(getFeedReader(channelUrl));
        }
        catch (IllegalArgumentException e)
        {
            throw new WroxServiceException(e);
        }
        catch (FeedException e)
        {
            throw new WroxServiceException(e);
        }
        catch (IOException e)
        {
            throw new WroxServiceException(e);
        }

        newsFeed.setTitle(feed.getTitle());
        newsFeed.setDescription(feed.getDescription());

        List entries = feed.getEntries();

        ListIterator listIterator = entries.listIterator(0);
        NewsItem[] newsItems = new NewsItem[entries.size()];

        int i = 0;

        while (listIterator.hasNext())
        {
            SyndEntry entry = (SyndEntry) listIterator.next();
            NewsItem item = new NewsItem();
            item.setHeadline(entry.getTitle());

            item.setDescription((entry.getDescription()).getValue());
            item.setNewsURL(entry.getLink());
            newsItems[i] = item;
            i++;
        }

        newsFeed.setItems(newsItems);

        return newsFeed;
    }

    private static Reader getFeedReader(URL feedUrl) throws IOException
    {
        Reader reader;
        URLConnection conn = feedUrl.openConnection();

        if (feedUrl.getProtocol().equals("http") ||
              feedUrl.getProtocol().equals("https"))
        {
            // Finds out server charset encoding based on HTTP spec
            String contentTypeHeader = conn.getContentType();
            String encoding = "ISO-8859-1";

            if (contentTypeHeader != null)
            {
                Matcher matcher = CHARSET_PATTERN.matcher(contentTypeHeader);

                if (matcher.find())
                {
                    encoding = matcher.group(1);
                }
            }

            reader = new InputStreamReader(conn.getInputStream(), encoding);
        }
        else
        {
            // Goes with platform's default charset encoding
            reader = new InputStreamReader(conn.getInputStream());
        }

        return reader;
    }
}
