package com.wrox.begjsp.ch27.wsproxy;

import com.amazon.soap.AmazonSearchPort;
import com.amazon.soap.AmazonSearchService;
import com.amazon.soap.AmazonSearchServiceLocator;
import com.amazon.soap.Details;
import com.amazon.soap.KeywordRequest;
import com.amazon.soap.ProductInfo;

import com.wrox.begjsp.ch27.dto.InterestItem;
import com.wrox.begjsp.ch27.dto.ItemFeed;

import java.net.MalformedURLException;
import java.net.URL;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;


/**
 * Proxy class for retrieving data from Amazon.com's web store
 */
public class AmazonStore implements WebserviceStore
{
    /* The Web service endpoint */
    private final static String AMAZON_ENDPOINT = "http://soap.amazon.com/onca/soap3";

    /* The Amazon associate id */
    private final static String ASSOCIATE_ID = "webservices-20";

    /* The developer token from Amazon */
    private final static String DEVELOPER_TOKEN = "D3FJ4BIG9V30Z8";

    /* The page number to retrieve */
    private final static String PAGE_NUMBER = "1";

    /* Search for books */
    private final static String MODE = "books";

    /* Amount of information to return- 'lite' mode or 'heavy' */
    private final static String TYPE = "lite";

    /* Web service version to invoke */
    private final static String VERSION = "1.0";

    /* Axis SOAP objects for making Web service call */
    private AmazonSearchService service;
    private AmazonSearchPort port;

    public AmazonStore() throws MalformedURLException, ServiceException
    {
        service = new AmazonSearchServiceLocator();
        port = service.getAmazonSearchPort(new URL(AMAZON_ENDPOINT));
    }

    public InterestItem[] searchByKeyword(String keyword)
        throws RemoteException
    {
        KeywordRequest request = new KeywordRequest();

        /* Set search parameters */
        request.setKeyword(keyword);
        request.setPage(PAGE_NUMBER);
        request.setMode(MODE);
        request.setTag(ASSOCIATE_ID);
        request.setType(TYPE);
        request.setDevtag(DEVELOPER_TOKEN);
        

        //request.setVersion(VERSION);
        ProductInfo productInfo = port.keywordSearchRequest(request);

        Details[] details = productInfo.getDetails();
        int productCount = details.length;
        InterestItem[] items = new InterestItem[productCount];

        for (int i = 0; i < productCount; i++)
        {
            InterestItem item = new InterestItem();
            item.setItemName(details[i].getProductName());
            item.setImageUrl(details[i].getImageUrlSmall());
            item.setItemUrl(details[i].getUrl());
            items[i] = item;
        }

        return items;
    }
}
