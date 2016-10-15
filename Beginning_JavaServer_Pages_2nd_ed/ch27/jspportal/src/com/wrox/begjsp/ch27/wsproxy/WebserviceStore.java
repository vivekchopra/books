package com.wrox.begjsp.ch27.wsproxy;

import com.wrox.begjsp.ch27.dto.InterestItem;

import java.rmi.RemoteException;


/**
 * Interface to proxy class for retrieving data
 */
public interface WebserviceStore
{
    /**
     * Search for items by keyword
     * @param keyword Keyword to search by
     * @return Matching items
     */
    public InterestItem[] searchByKeyword(String keyword)
        throws RemoteException;
}
