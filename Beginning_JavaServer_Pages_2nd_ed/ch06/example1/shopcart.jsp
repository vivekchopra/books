<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="wxshop" uri="http://www.wrox.com/begjsp/eshop-functions-taglib" %>

<%@ page session="true" %>

<c:set var="EXAMPLE" value="/example1"/>
<c:set var="SHOP_PAGE" value="/estore.jsp"/>
<c:set var="CART_PAGE" value="/shopcart.jsp"/>

<html>
<head>
<title>Wrox Shopping Mall - Shopping Cart</title>
<link rel=stylesheet type="text/css" href="store.css">
</head>
<body>
<c:if test="${!(empty param.sku)}">
  <c:set var="prod" value="${wxshop:getItem(param.sku)}"/>
</c:if>

<jsp:useBean id="lineitems" class="java.util.ArrayList" scope="session"/>

<c:choose>
    <c:when test="${param.action == 'clear'}">
       ${wxshop:clearList(lineitems)}
    </c:when>

    <c:when test="${param.action == 'inc' || param.action=='buy'}">
       <c:set var="found" value="false"/>
   
       <c:forEach var="curItem" items="${lineitems}">

            <c:if test="${(curItem.sku) == (prod.sku)}">
              <jsp:setProperty name="curItem" property="quantity" 
value="${curItem.quantity + 1}"/> 
              <c:set var="found" value="true" />
            </c:if>        
       </c:forEach>
       <c:if test="${!found}">
             <c:remove var="tmpitem"/>
             <jsp:useBean id="tmpitem" class="com.wrox.begjsp.ch03.LineItem">
             <jsp:setProperty name="tmpitem" property="quantity" value="1"/> 
             <jsp:setProperty name="tmpitem" property="sku" value="${prod.sku}"/> 
             <jsp:setProperty name="tmpitem" property="desc" value="${prod.name}"/> 
             <jsp:setProperty name="tmpitem" property="price" value="${prod.price}"/> 
              </jsp:useBean>
         ${wxshop:addList(lineitems, tmpitem)}
       </c:if>
      </c:when>
     </c:choose>  

<c:set var="total" value="0"/>
<table width="640">
    <tr><td class="mainHead">Wrox JSTL Web Store</td></tr>
<tr>
<td>
<h1></h1>
<table border="1" width="640">

<tr><th colspan="5" class="shopCart">Your Shopping Cart</th></tr>
<tr><th align="left">Quantity</th><th align="left">Item</th><th align="right">Price</th>
<th align="right">Extended</th>
<th align="left">Add</th></tr>
<c:forEach var="curItem" items="${lineitems}">
<c:set var="extended" value="${curItem.quantity * curItem.price}"/>
<c:set var="total" value="${total + extended}"/>   
<tr>
   <td>${curItem.quantity}</td>
   <td>${curItem.desc}</td>
   <td align="right">
     <fmt:formatNumber value="${curItem.price / 100}" type="currency"/>
   </td>
   <td align="right">
     <fmt:formatNumber value="${extended / 100}" type="currency"/>
   </td>
   <td>

 <c:url value="${EXAMPLE}${CART_PAGE}" var="localURL">
   <c:param name="action" value="inc"/>
   <c:param name="sku" value="${curItem.sku}"/>
 </c:url>
 <a href="${localURL}"><b>Add 1</b></a>
   </td>
</tr>
</c:forEach>
<tr>
<td colspan="5"> &nbsp;
</td>
</tr>
<tr>
<td colspan="3" align="right"><b>Total:</b></td>
<td align="right" class="grandTotal">
 <fmt:formatNumber value="${total / 100}" type="currency"/>
</td>
<td>&nbsp;</td>
</tr>

<tr>
<td colspan="5">
 <c:url value="${EXAMPLE}${CART_PAGE}" var="localURL">
   <c:param name="action" value="clear"/>
 </c:url>
 <a href="${localURL}">Clear the cart</a>
</td>
</tr>


<tr>
<td colspan="5">
 <c:url value="${EXAMPLE}${SHOP_PAGE}" var="localURL"/>
 <a href="${localURL}">Return to Shopping</a>
</td>
</tr>
</table>
</td></tr>
</table>
</body>
</html>
