
package com.wrox.begjsp.ch10;
public class ErrorGenerator {
    
    private Integer[] tpArray = new Integer[3];
    
    public ErrorGenerator() {
    }
  
    public String getOutOfRange() {
        tpArray[3] = tpArray[2];
        return "";
    }
    public String getDivideByZero() {
        tpArray[3] = new Integer(1/0);
        return "";
    }
    
    
}
