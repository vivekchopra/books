/*
 * Gallows.java
 *
 * Created on August 30, 2004, 11:21 PM
 */

package com.wrox.jsp;


/**
 *
 * @author  jtbell
 */
public class Gallows
{
    
    private static String[] gallowsEnd =
    {
        "+----+",
        "|    |",
        "|    O",
        "|   /|\\",
        "|    | ",
        "|   / \\",
        "|",
        "+------+",
        "+------+"
    };
    private static String[] gallows =
    {
        "+----+",
        "|",
        "|",
        "|",
        "|",
        "|",
        "|",
        "+------+",
        "+------+"
    };
    
    private int height = 0;
    /** Creates a new instance of Gallows */
    public Gallows()
    {
    }
    
    public void setHeight(int missCount)
    {
        height = missCount;
    }
    
    public String[] getGallows()
    {
        if(height >= 10)
            return gallowsEnd;
        String[] built = new String[(gallows.length)];
        for( int i = 0; i < gallows.length; i++)
        {
            if( i < gallows.length-height )
                built[i] = "&nbsp<BR/>";
            else
                built[i] = gallows[i];
        }
        return built;
    }
}
