
package com.wrox.begjsp.ch2;

import java.beans.*;
import java.util.*;


public class NewsFeed extends Object implements java.io.Serializable {
    
    private String topic;
    
    private String value;
    
    private ArrayList values;
    
    public NewsFeed() {

    }
    
    
    public void setTopic(String topic) {
        value = "";
        values = null;
        if (topic.equals("news"))  {
            value = "JSP Programmer Won 10 Million in Lottery";
        }
        if (topic.equals("entertainment")) {
            value = "Reality TV Show Ratings Falling";
        }
        if (topic.equals("weather")){
            values = new ArrayList();
            HashMap tmap = new HashMap();
            tmap.put("city", "Mumbai");
            tmap.put("temp", "30 C");
            values.add(tmap);
            tmap = new HashMap();
            tmap.put("city", "Tokyo");
            tmap.put("temp", "18 C");
            values.add(tmap);
            tmap = new HashMap();
            tmap.put("city", "Hong Kong");
            tmap.put("temp", "28 C");
            values.add(tmap);
            
        }
        
    }
    
    public String getValue() {
        return this.value;
    }
    
    public ArrayList getValues() {
        return this.values;
    }
    
}
