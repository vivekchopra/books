<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/app.tld" prefix="app" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<c:catch var="exception">
  <c:forEach items="${items}" var="itemgroups">
    <jsp:useBean id="itemgroups" type="com.wrox.begjsp.ch27.dto.ItemFeed"/>
    
  <table width="100%" border="0">
    <tr> 
      <td bgcolor="#CCCCCC"><div align="center"> <strong>
          <jsp:getProperty name="itemgroups" property="itemFeedName"/>
          </strong>
          </div></td>
    </tr>
    <c:forEach items="${itemgroups.interestItem}" var="interestitem"> 
    <jsp:useBean id="interestitem" type="com.wrox.begjsp.ch27.dto.InterestItem"/>
    <tr> 
      <td><div align="left"><a href="${interestitem.itemUrl}" target=_blank><img src="${interestitem.imageUrl}"/></a></div></td>
    </tr>
    <tr> 
      <td><div align="left"><em><a href="${interestitem.itemUrl}" target=_blank>${interestitem.itemName}</a></em></div></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
    </tr>
    </c:forEach> 
  </table>
  </c:forEach>
</c:catch>
<c:if test="${not empty exception}">
  Sorry, the store is closed. Cause: ${exception}
</c:if>
