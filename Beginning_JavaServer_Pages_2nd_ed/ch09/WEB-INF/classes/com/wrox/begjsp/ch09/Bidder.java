package com.wrox.begjsp.ch09;

public class Bidder {
    
    /** Holds value of property item. */
    private String item;
    
    /** Holds value of property price. */
    private long price;
    
    /** Holds value of property result. */
    private String result;
    
    /** Creates a new instance of Bidder */
    public Bidder() {
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
    
    /** Getter for property result.
     * @return Value of property result.
     *
     */
    public String getResult() {
        /* simulate bid result */
        this.result = "Sorry your bid did not win. The successful bidder was joe1233.";
        return this.result;
    }
    
}
