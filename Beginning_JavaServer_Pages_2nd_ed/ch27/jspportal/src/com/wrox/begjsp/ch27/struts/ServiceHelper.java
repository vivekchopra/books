package com.wrox.begjsp.ch27.struts;

import com.wrox.begjsp.ch27.dto.ItemFeed;
import com.wrox.begjsp.ch27.dto.NewsFeed;
import com.wrox.begjsp.ch27.dto.UserProfile;
import com.wrox.begjsp.ch27.service.ItemService;
import com.wrox.begjsp.ch27.service.NewsService;
import com.wrox.begjsp.ch27.service.WroxServiceException;
import com.wrox.begjsp.ch27.service.WroxServiceLocator;

import org.apache.log4j.Logger;

import java.util.ArrayList;


/**
 * Helper class for accessing services
 */
public class ServiceHelper
{
    static public ArrayList getSubscriptions(UserProfile profile, Logger logger)
    {
        String[] subscriptions = profile.getSubscriptions();
        ArrayList list = new ArrayList();
        NewsService newsService = null;

        try
        {
            newsService = WroxServiceLocator.getNewsService();
        }
        catch (WroxServiceException e)
        {
            // Can't get to any of the subscriptions
            logger.error("Unable to access news service:" +
                e.getLocalizedMessage());
            errorSubscriptions(list, subscriptions);

            return list;
        }

        for (int i = 0; i < subscriptions.length; i++)
        {
            NewsFeed newsFeed = null;

            try
            {
                newsFeed = newsService.getNewsFeed(subscriptions[i]);
            }
            catch (WroxServiceException e)
            {
                // Can't get to this subscription
                logger.error("Unable to access subscription:" +
                    subscriptions[i] + ": reason: " + e.getLocalizedMessage());

                String[] thisSubscription = { subscriptions[i] };
                errorSubscriptions(list, thisSubscription);
            }

            list.add(newsFeed);
        }

        return list;
    }

    static public ArrayList getItems(UserProfile profile, Logger logger)
    {
        ItemService itemService;
        ArrayList list = new ArrayList();

        try
        {
            itemService = WroxServiceLocator.getItemService();

            String[] interests = profile.getInterests();

            for (int i = 0; i < interests.length; i++)
            {
                ItemFeed itemFeed = null;
                itemFeed = itemService.getItemFeed(interests[i]);
                list.add(itemFeed);
            }
        }
        catch (WroxServiceException e)
        {
            // Can't get to any items from store
            logger.error("Unable to access items:" + e.getLocalizedMessage());
        }

        return list;
    }

    static private void errorSubscriptions(ArrayList list,
        String[] subscriptions)
    {
        for (int i = 0; i < subscriptions.length; i++)
        {
            NewsFeed newsFeed = new NewsFeed();
            newsFeed.setTitle("Unable to get news from " + subscriptions[i]);
            newsFeed.setDescription(
                "Possible causes- network error, news site down, or behind proxy");
            newsFeed.setItems(null);
            list.add(newsFeed);
        }
    }
}
