<html>
<head>
</head>
<body>
  <jsp:useBean id="myProduct" class="com.wrox.begjsp.ch03.Product">
    <jsp:setProperty name="myProduct" property="sku" value="12345"/>
    <jsp:setProperty name="myProduct" property="name" value="DSL Modem"/>
  </jsp:useBean>
<table border="1">
 <tr>
    <td>Sku:</td><td><%= myProduct.getSku() %></td>
 </tr>
<tr>
    <td>Name:</td><td>${myProduct.name}</td>
 </tr>
</table>

  <jsp:useBean id="myMap"  class="java.util.HashMap" />
  <jsp:useBean id="myMap2"  class="java.util.HashMap"  type="java.util.Map"/>


 </body>
</html>
