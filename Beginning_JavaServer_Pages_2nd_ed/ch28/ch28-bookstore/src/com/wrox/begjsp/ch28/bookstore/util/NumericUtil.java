package com.wrox.begjsp.ch28.bookstore.util;

public class NumericUtil
{
    public static boolean isInteger(String value)
    {
        if ((value == null) || (value.length() < 1))
        {
            return false;
        }

        try
        {
            new Integer(value);
        }
        catch (NumberFormatException nfe)
        {
            return false;
        }

        return true;
    }

    public static int getInt(String value)
    {
        return new Integer(value).intValue();
    }
}
