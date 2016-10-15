<%@ page language="java" 
import = "com.wrox.begjsp.ch03.*,java.util.*" %>


<%!   
public void jspInit() {
   getServletContext().setAttribute("cats", EShop.getCats());
}

public void jspDestroy() {
   getServletContext().removeAttribute("cats");
}

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
<title>Wrox Shopping Mall</title>
</head>
<body>
<table width="600">
<tr>
<td width="20%">
<%
   
   ArrayList cats = (ArrayList) application.getAttribute("cats");
   for (int i=0; i< cats.size(); i++) {
          Category curCat = (Category) cats.get(i);
%>
<a href="<%= request.getRequestURL() + "?catid=" + curCat.getId() %>">
         <%=  curCat.getName()  %>
</a>
<br/>
<%
    }
%>
</td>
<td>
<h1></h1>
<table border="1">
<tr><th align="left">Item</th><th align="left">Price</th><th align="left">Order</th></tr>
<%
   String selectedCat = request.getParameter("catid");
   if (selectedCat == null) 
     selectedCat = "1";
   ArrayList items = (ArrayList) EShop.getItems(selectedCat);
for (int i=0; i< items.size(); i++)  {
     Product curItem = (Product) items.get(i);
%>
<tr>
   <td><%= curItem.getName()   %></td>
   <td><%= dispPrice(String.valueOf(curItem.getPrice()))  %></td>
   <td><a href="<%= request.getContextPath() + "/example2/shopcart.jsp?action=buy&sku=" + curItem.getSku() %>">
         <b>BUY</b></a>
   </td>
</tr>

<%
  }
%>

</table>
</td>
</tr>
</table>

</body>
</html>
