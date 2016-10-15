package com.wrox.begjsp.ch09;
public class Bid {
    
    /** Holds value of property price. */
    private long price;
    
    /** Holds value of property item. */
    private String item;
    
    /** Creates a new instance of Bid */
    public Bid() {
    }
    
    /** Getter for property price.
     * @return Value of property price.
     *
     */
    public long getPrice() {
        return this.price;
    }
    
    /** Setter for property price.
     * @param price New value of property price.
     *
     */
    public void setPrice(long price) {
        this.price = price;
    }
    
    /** Getter for property item.
     * @return Value of property item.
     *
     */
    public String getItem() {
        return this.item;
    }
    
    /** Setter for property item.
     * @param item New value of property item.
     *
     */
    public void setItem(String item) {
        this.item = item;
    }
    
}
