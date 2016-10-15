<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="wxshop" uri="http://www.wrox.com/begjsp/eshop-functions-taglib" %>

<%@ page  session="true" %>
<c:if test="${empty cats}">
  <c:set var="cats" value="${wxshop:getCats()}" scope="application"/> 
</c:if>

<html>
<head>
<title>Wrox Shopping Mall</title>
<link rel=stylesheet type="text/css" href="store.css">
</head>
<body>
<table width="600">
<tr><td colspan="2" class="mainHead">Wrox JSTL Web Store</td></tr>

<tr>
<td width="20%">
<c:forEach var="curCat" items="${cats}">
 <c:url value="/example1/estore.jsp" var="localURL">
   <c:param name="catid" value="${curCat.id}"/>
 </c:url>
 <a href="${localURL}" class="category">${curCat.name}</a>
 </br>
</c:forEach>
</td>
<td width="*">
<h1></h1>
<table border="1" width="100%">
<tr><th align="left">Item</th><th align="left">Price</th><th align="left">Order</th></tr>
<c:set var="selectedCat"  value="${param.catid}"/>
<c:if test="${empty selectedCat}">
  <c:set var="selectedCat"  value="1"/>
</c:if>
<c:forEach var="curItem" items="${wxshop:getItems(selectedCat)}">
  <tr>
   <td>${curItem.name}</td>
   <td align="right">
       <fmt:formatNumber value="${curItem.price / 100}" type="currency"/>
   </td>
   <td>
     <c:url value="/example1/shopcart.jsp" var="localURL">
          <c:param name="action" value="buy"/>
          <c:param name="sku" value="${curItem.sku}"/>
     </c:url>
   <a href="${localURL}"><b>BUY</b></a>
  </td>
</tr>
</c:forEach>
</table>
</td>
</tr>
</table>

</body>
</html>
