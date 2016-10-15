package com.wrox.begjsp.ch27.service;

import com.wrox.begjsp.ch27.dto.InterestItem;
import com.wrox.begjsp.ch27.dto.ItemFeed;
import com.wrox.begjsp.ch27.wsproxy.AmazonStore;
import com.wrox.begjsp.ch27.wsproxy.WebserviceStore;

import java.net.MalformedURLException;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;


/**
 * An implementation of the ItemService
 */
public class ItemServiceImpl implements ItemService
{
    private WebserviceStore webserviceStore;

    public ItemServiceImpl() throws WroxServiceException
    {
        // Set the web service store to Amazon.com
        try
        {
            webserviceStore = new AmazonStore();
        }
        catch (MalformedURLException e)
        {
            throw new WroxServiceException(e);
        }
        catch (ServiceException e)
        {
            throw new WroxServiceException(e);
        }
    }

    public ItemFeed getItemFeed(String interest) throws WroxServiceException
    {
        ItemFeed itemFeed = new ItemFeed();
        itemFeed.setItemFeedName(interest + " books");

        InterestItem[] items = null;

        try
        {
            items = webserviceStore.searchByKeyword(interest);
        }
        catch (RemoteException e)
        {
            throw new WroxServiceException(e.getCause());
        }
        catch (Exception e)
        {
			throw new WroxServiceException(e);
        }

        itemFeed.setInterestItem(items);

        return itemFeed;
    }
}
