package com.wrox.begjsp.ch27.service;

import java.io.Serializable;


/**
 * The exception class for all service related exceptions.
 * This exception class allows for wrapping of nested exceptions
 */
public class WroxServiceException extends Exception implements Serializable
{
    public WroxServiceException(String message)
    {
        super(message);
    }

    public WroxServiceException(Throwable wrapped)
    {
        super(wrapped);
    }

    public WroxServiceException(String message, Throwable wrapped)
    {
        super(message, wrapped);
    }
}
