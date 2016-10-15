
package com.wrox.begjsp.ch03;
import java.util.*;

public class EShop {
    
    public EShop() {
    }
    
    public static ArrayList getCats() {
            ArrayList values = new ArrayList();

            values.add( new Category("1", "Systems"));
            values.add( new Category("2", "Software"));
            values.add( new Category("3", "Books"));
            return values;
    }
    
    public static ArrayList getItems(String catid)  {
        ArrayList values = new ArrayList();
        if (catid.equals("1"))  {
            values.add(new Product("232", "Pentium 4 - 4 GHz, 512 MB, 300 GB", 
               "",  98999));
            values.add(new Product("238", "AMD Opteron - 4 GHz, 1 GB, 300 GB", 
               "",  120099));
            
        } else if (catid.equals("2")) {
            values.add(new Product("872", "Tomcat 5 Server for Windows", 
               "",  9900));
            values.add(new Product("758", "Tomcat 5 Server for Linux", 
               "",  9900));
                       
        } else if (catid.equals("3")) {
           values.add(new Product("511", "Beginning JavaServer Pages", 
               "",  3999));
           values.add(new Product("188", "Professional Apache Tomcat 5", 
               "",  4999));
           values.add(new Product("148", "Apache Tomcat Bible", 
               "",  4999));
            
        }
        return values;
    }
    
        public static Product getItem(String sku)  {
         ArrayList cats = getCats();
         Product foundProd = null;
         for (int i=0; i < cats.size(); i++)  {
           Category curCat = (Category) cats.get(i);
           ArrayList items = getItems(curCat.getId());
             for (int j=0; j < items.size(); j++) {
                Product curProd = (Product) items.get(j);   
                if (curProd.getSku().equals(sku)) {
                 foundProd = curProd;
                 break;
                }   
             }
           if (foundProd != null)
               break;
         }
            
            
        return foundProd;    
            
            
        }    
}
