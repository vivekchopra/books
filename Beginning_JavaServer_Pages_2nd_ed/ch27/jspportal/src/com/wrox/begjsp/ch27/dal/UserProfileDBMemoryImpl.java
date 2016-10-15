package com.wrox.begjsp.ch27.dal;

import com.wrox.begjsp.ch27.dto.UserProfile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import java.net.URL;
import java.net.URLConnection;

import java.util.HashMap;


/**
 * A database access layer implementation for UserProfile objects.
 * This implementation uses a memory-based database backed by a file
 */
public class UserProfileDBMemoryImpl extends GenericDB implements UserProfileDB
{
    static private UserProfileDBMemoryImpl singleton;

    private UserProfileDBMemoryImpl(String databasePath)
    {
        databaseFile = "UserProfile.ser";
        genericDBInit (databasePath);
    }

    private UserProfileDBMemoryImpl()
    {

      try
        {
            Class clazz = Class.forName(
                    "com.wrox.begjsp.ch27.dal.UserProfileDBMemoryImpl");
            URL url = clazz.getResource("UserProfileDBMemoryImpl.class");
            String classFullPath = url.getPath();
            String classWithPack = "com/wrox/begjsp/ch27/dal/UserProfileDBMemoryImpl.class";
            int idx = classFullPath.indexOf(classWithPack);
            databasePath = classFullPath.substring(1, idx);
            System.out.println("*** Loading DB file: " + databasePath +
                databaseFile);
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
    static public UserProfileDBMemoryImpl getInstance()
    {
        if (singleton == null)
        {
            singleton = new UserProfileDBMemoryImpl();
        }

        return singleton;
    }

	/**
	 * Return the instance of PublisherDB
	 * Caveat: Not thread-safe
	 */
	static public UserProfileDBMemoryImpl getInstance(String databasePath)
	{
		if (singleton == null)
		{
			singleton = new UserProfileDBMemoryImpl(databasePath);
		}

		return singleton;
	}
	
    public UserProfile getUserProfile(String username)
        throws DatabaseException
    {
        UserProfile userProfile = (UserProfile) memoryDatabase.get(username);

        if (userProfile == null)
        {
            userProfile = new UserProfile();
            userProfile.setStatus(UserProfile.STATUS_INVALID_USER);
        }

        return userProfile;
    }

    public void updateUserProfile(UserProfile userProfile)
        throws DatabaseException
    {
        memoryDatabase.remove(userProfile.getUserName());
        memoryDatabase.put(userProfile.getUserName(), userProfile);
        sync(memoryDatabase, databasePath + databaseFile);
    }

    public void insertUserProfile(UserProfile userProfile)
        throws DatabaseException
    {
        memoryDatabase.put(userProfile.getUserName(), userProfile);
        sync(memoryDatabase, databasePath + databaseFile);
    }

    public void deleteUserProfile(String username) throws DatabaseException
    {
        memoryDatabase.remove(username);
        sync(memoryDatabase, databasePath + databaseFile);
    }
}
