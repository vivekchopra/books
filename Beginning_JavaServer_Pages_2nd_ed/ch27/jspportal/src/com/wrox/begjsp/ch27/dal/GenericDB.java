package com.wrox.begjsp.ch27.dal;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.HashMap;


/**
 * The base class of all DB Impl classes
 */
public abstract class GenericDB
{
    /* The name of the file where the database is serialized */
    protected String databaseFile;

    /* The memory resident database */
    protected HashMap memoryDatabase;

    /* The path to the filesystem where the database file is kept */
    protected String databasePath;

    public GenericDB()
    {
    }

    protected void genericDBInit(String databasePath)
    {
        // databaseFile = <SET IN DERIVED CLASS>;
        this.databasePath = databasePath;

        memoryDatabase = null;

        InputStream stream = null;

        try
        {
            stream = new FileInputStream(this.databasePath + databaseFile);
            System.out.println("*** Read database :" + this.databasePath +
                databaseFile);
        }
        catch (IOException e)
        {
            System.out.println("*** Unable to read database :" +
                this.databasePath + databaseFile + ":" + e.getMessage() +
                ":Initializing new file.");
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
            catch (Exception e)
            {
                System.out.println("*** Unable to read database contents:" +
                    this.databasePath + databaseFile + ":" + e.getMessage() +
                    ":Initializing new file.");

                memoryDatabase = new HashMap();
            }
        }
    }

    protected void sync(HashMap memoryDatabase, String filesystemPath)
        throws DatabaseException
    {
        try
        {
            FileOutputStream stream = new FileOutputStream(filesystemPath);

            ObjectOutputStream out = new ObjectOutputStream(stream);
            out.writeObject(memoryDatabase);

            out.close();
        }
        catch (IOException e)
        {
            throw new DatabaseException("Unable to write to db " +
                filesystemPath, e);
        }
    }
}
