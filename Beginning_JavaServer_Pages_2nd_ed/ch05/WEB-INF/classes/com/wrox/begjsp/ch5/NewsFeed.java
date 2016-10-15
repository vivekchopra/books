
package com.wrox.begjsp.ch5;

import java.beans.*;
import java.util.*;


public class NewsFeed extends Object implements java.io.Serializable {
    
    private String topic;
    
    private String value;
    
    private HashMap values;
    
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
            values = new HashMap();
            values.put("Mumbai", "30 C");
            values.put("Tokyo", "18 C");
            values.put("Hong Kong", "28 C");

            
        }
        
    }
    
    public String getValue() {
        return this.value;
    }
    
    public Map getValues() {
        return this.values;
    }
    
}
