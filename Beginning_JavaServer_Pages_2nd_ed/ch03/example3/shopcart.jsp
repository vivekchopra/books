<%@ page language="java" 
import = "com.wrox.begjsp.ch03.*,java.util.*" session="true" %>


<%!   
private static String EXAMPLE = "/example3";
private static String SHOP_PAGE = "/estore.jsp";
private static String CART_PAGE = "/shopcart.jsp";

private  String dispPrice( String price) {
   int len = price.length();
   if (len <= 2)
          return price;
   else 
      return "$" + price.substring(0,len -2) + "." + price.substring(len-2);
}
%>

<html>
<head>
<title>Wrox Shopping Mall - Shopping Cart</title>
</head>
<body>

<%
  ArrayList items = (ArrayList) session.getAttribute("lineitems");
  String action =  request.getParameter("action");
  String sku = request.getParameter("sku");
  Product prod = null;
  if (sku != null)
    prod = EShop.getItem(sku);

  if (items == null)  {  // add first item
    items = new ArrayList();
    items.add(new LineItem(1,sku,prod.getName(),
                  prod.getPrice() ));
    session.setAttribute("lineitems", items);
    }
  else  if (action.equals("clear")) {
         items.clear();     
    }
  else {
     boolean itemFound = false;
     // check to see if sku exists
     for (int i=0; i<items.size(); i++) {
         LineItem curItem = (LineItem) items.get(i);
         if (curItem.getSku().equals(sku))  {
              itemFound = true;
              curItem.setQuantity(curItem.getQuantity() + 1);
              break;
         }  // of if
       } //of for

     if (!itemFound) 
        items.add(new LineItem(1,sku,prod.getName(),
                  prod.getPrice() ));
      
   } // of final else
                 
  int total = 0;
%>
<table width="600">
<tr>
<td>
<h1></h1>
<table border="1" width="600">
<tr><th colspan="5">Your Shopping Cart</th></tr>
<tr><th align="left">Quantity</th><th align="left">Item</th><th align="right">Price</th>
<th align="right">Extended</th>
<th align="left">Add</th></tr>

<%
  for (int i=0; i< items.size(); i++)  {
    LineItem curItem = (LineItem) items.get(i);
    int quan = curItem.getQuantity();
    long price = curItem.getPrice();
    long extended = quan * price;
    total += extended;
%>

<tr>
   <td><%= quan %></td>
   <td><%= curItem.getDesc()   %></td>
   <td align="right"><%= dispPrice(String.valueOf(price))  %></td>
   <td align="right"><%= dispPrice(String.valueOf(extended))  %></td>
   <td>
<a href="<%= request.getContextPath() + EXAMPLE + CART_PAGE + "?action=inc&sku=" + curItem.getSku() %>">
         <b>Add 1</b></a>
   </td>
</tr>
<% 
    }
%>
<tr>
<td colspan="5"> &nbsp;
</td>
</tr>
<tr>
<td colspan="3" align="right"><b>Total:</b></td>
<td align="right"><%= dispPrice(String.valueOf(total)) %></td>
<td>&nbsp;</td>
</tr>

<tr>
<td colspan="5">
<a href="<%= request.getContextPath() + EXAMPLE + CART_PAGE + "?action=clear" %>">
Clear the cart</a>
</td>
</tr>


<tr>
<td colspan="5">
<a href="<%= request.getContextPath() + EXAMPLE + SHOP_PAGE %>">
Return to Shopping</a>
</td>
</tr>

</table>
</td>
</tr>
</table>
</body>
</html>
