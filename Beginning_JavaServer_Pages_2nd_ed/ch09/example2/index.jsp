<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
  <c:when test="${empty param.action}">
     <jsp:forward page="enterbid.jsp"/>
  </c:when>
  <c:when test="${param.action eq 'bid'}">
   <!--  validation code -->
   <c:if test="${(param.price <= 0) ||  (param.price >= 999)}">
       <jsp:useBean id="biderror" class="com.wrox.begjsp.ch09.BidError" scope="request">
        <jsp:setProperty name="biderror" property="msg" value="Sorry, your bid is not in range. Please enter again."/>
     </jsp:useBean>
     <jsp:forward page="enterbid.jsp"/>
  </c:if>
  <!-- data validated -->
       <jsp:useBean id="bidinfo" class="com.wrox.begjsp.ch09.Bid" scope="request">
        <jsp:setProperty name="bidinfo" property="*"/> 
     </jsp:useBean>

  <!-- perform bidding -->
      <jsp:useBean id="bidder" class="com.wrox.begjsp.ch09.Bidder" scope="request">
        <jsp:setProperty name="bidder" property="item"/>
        <jsp:setProperty name="bidder" property="price"/>
     </jsp:useBean>
     <c:set var="bidresult" value="${bidder.result}" scope="request"/>


     <jsp:forward page="showbid.jsp"/>   
</c:when>
</c:choose>
