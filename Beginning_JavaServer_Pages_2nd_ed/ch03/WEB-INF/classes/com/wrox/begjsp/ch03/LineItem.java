
package com.wrox.begjsp.ch03;
public class LineItem {
    
    private int quantity;
    
    private String sku;
    
    private String desc;
    
    private long price;
    
    public LineItem() {
    }
    public LineItem( int quantity, String sku, String desc, long price) {
    this.quantity = quantity;
    this.sku = sku;
    this.desc = desc;
    this.price = price;
    }
    
    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public String getSku() {
        return this.sku;
    }
    
    public void setSku(String sku) {
        this.sku = sku;
    }
    
    public String getDesc() {
        return this.desc;
    }
    
    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public long getPrice() {
        return this.price;
    }
    
    public void setPrice(long price) {
        this.price = price;
    }
    
}
