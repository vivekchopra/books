package com.wrox.begjsp.ch27.dal;

import com.wrox.begjsp.ch27.dto.Publisher;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import java.net.URL;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;


/**
 * A database access layer implementation for Publisher objects.
 * This implementation uses a memory-based database backed by a file
 */
public class PublisherDBMemoryImpl extends GenericDB implements PublisherDB
{
    static private PublisherDBMemoryImpl singleton;

	private PublisherDBMemoryImpl(String databasePath)
	{
		databaseFile = "Publisher.ser";
		genericDBInit (databasePath);
	}

    private PublisherDBMemoryImpl()
    {
        databaseFile = "Publisher.ser";
        memoryDatabase = null;

        try
        {
            Class clazz = Class.forName(
                    "com.wrox.begjsp.ch27.dal.PublisherDBMemoryImpl");
            URL url = clazz.getResource("PublisherDBMemoryImpl.class");
            String classFullPath = url.getPath();
            String classWithPack = "com/wrox/begjsp/ch27/dal/PublisherDBMemoryImpl.class";
            int idx = classFullPath.indexOf(classWithPack);
            databasePath = classFullPath.substring(1, idx);
            System.out.println("*** Loading DB file: " + databasePath + databaseFile);
        }
        catch (ClassNotFoundException e1)
        {
            e1.printStackTrace();
        }

        InputStream stream = null;

        try
        {
            stream = new FileInputStream(databasePath + databaseFile);
        }
        catch (IOException e)
        {
            System.out.println("Unable to read database " + e.getMessage());
            memoryDatabase = new HashMap();
        }

        if (stream != null)
        {
            try
            {
                ObjectInputStream objstream = new ObjectInputStream(stream);
                memoryDatabase = (HashMap) objstream.readObject();
                objstream.close();
            }
            catch (IOException e)
            {
                System.out.println("Unable to read database " + e.getMessage());
                memoryDatabase = new HashMap();
            }
            catch (ClassNotFoundException e)
            {
                System.out.println("Unable to read database " + e.getMessage());
                memoryDatabase = new HashMap();
            }
        }
    }

    /**
     * Return the instance of PublisherDB
     * Caveat: Not thread-safe
     */
    static public PublisherDBMemoryImpl getInstance()
    {
        if (singleton == null)
        {
            singleton = new PublisherDBMemoryImpl();
        }

        return singleton;
    }
    
	/**
	 * Return the instance of PublisherDB
	 * Caveat: Not thread-safe
	 */
	static public PublisherDBMemoryImpl getInstance(String databasePath)
	{
		if (singleton == null)
		{
			singleton = new PublisherDBMemoryImpl(databasePath);
		}

		return singleton;
	}

    /**
     * Return a list of all Publisher, so that the UI can display it
     * @throws DatabaseException
     */
    public List getPublishers() throws DatabaseException
    {
        return new ArrayList(memoryDatabase.values());
    }

    /**
     * Return a Publisher matching the RSS URL. The RSS URL is a unique way to identify
     * a news feed
     * @param feedUrl RSS URL
     * @throws DatabaseException
     */
    public Publisher getPublisher(String feedUrl) throws DatabaseException
    {
        return (Publisher) memoryDatabase.get(feedUrl);
    }

    /**
     * Add a Publisher
     * @param feedUrl RSS URL
     * @throws DatabaseException
     */
    public void addPublisher(Publisher publisher) throws DatabaseException
    {
        // If publisher already exists, it will be overwritten
        memoryDatabase.put(publisher.getFeedUrl(), publisher);
        sync(memoryDatabase, databasePath + databaseFile);
    }

    public static void main(String[] args) throws DatabaseException
    {
 
        // Initialize list of publisher
        Publisher[] publishers = 
        {
            new Publisher("IBM developerWorks", "Java Technology",
                "Technology",
                "http://www.ibm.com/developerworks/news/dw_java.rss"),
            new Publisher("IBM developerWorks", "Linux", "Technology",
                "http://www.ibm.com/developerworks/news/dw_linux.rss"),
            new Publisher("IBM developerWorks", "XML", "Technology",
                "http://www.ibm.com/developerworks/news/dw_xml.rss"),
            new Publisher("Wired News", "Technology Stories", "News:Tech",
                "http://www.wired.com/news/feeds/rss2/0,2610,3,00.xml"),
            new Publisher("Slashdot", "News for Nerds:Stuff that matters",
                "News:Tech", "http://slashdot.org/index.rss"),
            new Publisher("Yahoo News", "Top Stories", "News:General",
                "http://rss.news.yahoo.com/rss/topstories"),
            new Publisher("Yahoo News", "Entertainment", "News:Entertainment",
                "http://rss.news.yahoo.com/rss/entertainment"),
            new Publisher("Yahoo News", "Health", "News:Health",
                "http://rss.news.yahoo.com/rss/health"),
            new Publisher("Yahoo News", "Sports", "News:Sports",
                "http://rss.news.yahoo.com/rss/sports")
        };

        PublisherDBMemoryImpl publisherDBImpl = PublisherDBMemoryImpl.getInstance();

        // Add them to the database
        for (int i = 0; i < publishers.length; i++)
        {
            publisherDBImpl.addPublisher(publishers[i]);
        }

        // Check added publishers
        List list = publisherDBImpl.getPublishers();
        ListIterator li = list.listIterator(0);

        while (li.hasNext())
        {
            Publisher publisher = (Publisher) li.next();
            System.out.println("Found: " + publisher.getName() + ":" +
                publisher.getFeedUrl());
        }
    }
}
