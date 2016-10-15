package com.wrox.begjsp.ch27.service;


/**
 * Returns instances of the services
 */
public class WroxServiceLocator
{
    public static AuthenticationService getAuthenticationService()
        throws WroxServiceException
    {
        return new AuthenticationServiceImpl();
    }

    public static ItemService getItemService() throws WroxServiceException
    {
        return new ItemServiceImpl();
    }

    public static NewsService getNewsService() throws WroxServiceException
    {
        return new NewsServiceImpl();
    }
}
