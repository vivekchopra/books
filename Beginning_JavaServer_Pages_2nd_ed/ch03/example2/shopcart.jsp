<%@ page language="java" 
import = "com.wrox.begjsp.ch03.*,java.util.*" %>


<%!   
private static String EXAMPLE = "/example2";
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
  int quan = 1;
  String action =  request.getParameter("action");
  if (action.equals("inc")) {
     String oldQuan = request.getParameter("quan");
     quan = Integer.parseInt(oldQuan);
     quan++;
   }  // else - action=buy
               
%>
<table width="600">
<tr>
<td>
<h1></h1>
<table border="1">
<tr><th colspan="5">Your Shopping Cart</th></tr>
<tr><th align="left">Quantity</th><th align="left">Item</th><th align="right">Price</th>
<th align="right">Extended</th>
<th align="left">Add</th></tr>

<%
  String sku = request.getParameter("sku");
  Product item = null;
  if (sku != null)
      item = EShop.getItem(sku);
%>

<tr>
   <td><%= quan %></td>
   <td><%= item.getName()   %></td>
   <td align="right"><%= dispPrice(String.valueOf(item.getPrice()))  %></td>
   <td align="right"><%= dispPrice(String.valueOf(item.getPrice() * quan))  %></td>
   <td>
<a href="<%= request.getContextPath() + EXAMPLE + CART_PAGE + "?action=inc&quan=" + quan + "&sku=" + sku %>">
         <b>Add 1</b></a>
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
