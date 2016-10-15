
package com.wrox.begjsp.ch03;

public class Product {
    
    private String sku;
    
    private String name;
    
    private String desc;
    
    private long price;
    
    public Product() {
    }
    public Product( String sku, String name, String desc, long price) {
     this.sku = sku;
     this.name = name;
     this.desc = desc;
     this.price = price;
    }
    public String getSku() {
        return this.sku;
    }
    
    public void setSku(String sku) {
        this.sku = sku;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
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
