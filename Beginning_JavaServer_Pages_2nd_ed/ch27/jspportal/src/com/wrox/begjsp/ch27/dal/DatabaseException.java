package com.wrox.begjsp.ch27.dal;

import java.io.Serializable;


/**
 * The exception class for all database related exceptions.
 * This exception class allows for wrapping of nested exceptions
 */
public class DatabaseException extends Exception implements Serializable
{
    public DatabaseException(String message)
    {
        super(message);
    }

    public DatabaseException(Throwable wrapped)
    {
        super(wrapped);
    }

    public DatabaseException(String message, Throwable wrapped)
    {
        super(message, wrapped);
    }
}
