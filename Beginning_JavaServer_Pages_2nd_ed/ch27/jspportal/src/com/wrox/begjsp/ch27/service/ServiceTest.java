package com.wrox.begjsp.ch27.service;

import com.wrox.begjsp.ch27.dto.InterestItem;
import com.wrox.begjsp.ch27.dto.ItemFeed;
import com.wrox.begjsp.ch27.dto.NewsFeed;
import com.wrox.begjsp.ch27.dto.NewsItem;
import com.wrox.begjsp.ch27.dto.UserProfile;


public class ServiceTest
{
    public static void main(String[] args) throws WroxServiceException
    {
        String username = "test";
        String password = "test";

        AuthenticationService authService = WroxServiceLocator.getAuthenticationService();
        System.out.println("Logging in with username=" + username +
            ", password=" + password);

        UserProfile profile = null;

        try
        {
            profile = authService.login(username, password);
        }
        catch (WroxServiceException e)
        {
            e.printStackTrace();
        }

        if (profile.getStatus() == UserProfile.STATUS_LOGGED_IN)
        {
            ItemService itemService = WroxServiceLocator.getItemService();
            NewsService newsService = WroxServiceLocator.getNewsService();

            System.out.println("Display Name = " + profile.getDisplayName());

            String[] interests = profile.getInterests();

            for (int i = 0; i < interests.length; i++)
            {
                System.out.println("Interest #" + (i + 1) + ". " +
                    interests[i]);

                ItemFeed itemFeed = null;

                try
                {
                    itemFeed = itemService.getItemFeed(interests[i]);
                }
                catch (WroxServiceException e)
                {
                    e.printStackTrace();
                }

                System.out.println("\tFeedName = " +
                    itemFeed.getItemFeedName());

                InterestItem[] items = itemFeed.getInterestItem();

                for (int j = 0; j < items.length; j++)
                {
                    System.out.println("\t\tItem name:" +
                        items[j].getItemName());
                    System.out.println("\t\tItem URL:" + items[j].getItemUrl());
                    System.out.println("\t\tItem image URL:" +
                        items[j].getImageUrl());
                }
            }

            String[] subscriptions = profile.getSubscriptions();

            for (int i = 0; i < subscriptions.length; i++)
            {
                System.out.println("Subscription #" + (i + 1) + ". " +
                    subscriptions[i]);

                NewsFeed newsFeed = null;

                try
                {
                    newsFeed = newsService.getNewsFeed(subscriptions[i]);
                }
                catch (WroxServiceException e)
                {
                    e.printStackTrace();
                }

                System.out.println("\tFeedTitle = " + newsFeed.getTitle());
                System.out.println("\tFeedDescription = " +
                    newsFeed.getDescription());

                NewsItem[] items = newsFeed.getItems();

                for (int j = 0; j < items.length; j++)
                {
                    System.out.println("\t\tHeadline:" +
                        items[j].getHeadline());
                    System.out.println("\t\tDescription:" +
                        items[j].getDescription());
                    System.out.println("\t\tItem URL:" + items[j].getNewsURL());
                }
            }
        }
        else
        {
            System.out.println("Login failed");
        }
    }
}
