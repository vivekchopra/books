<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/app.tld" prefix="app" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<c:catch var="exception">
  <c:forEach items="${news}" var="publishers">
    <jsp:useBean id="publishers" type="com.wrox.begjsp.ch27.dto.NewsFeed"/>
    
     <table width="100%" border="0">
       <tr> 
          <td bgcolor="#CCCCCC"><div align="center"> <strong>
          <jsp:getProperty name="publishers" property="title"/>
          </strong> : 
          <jsp:getProperty name="publishers" property="description"/>
          </div></td>
       </tr>
     <c:forEach items="${publishers.items}" var="newsitem"> 
       <jsp:useBean id="newsitem" type="com.wrox.begjsp.ch27.dto.NewsItem"/>
       <tr> 
         <td><div align="left"><a href="${newsitem.newsURL}" target=_blank>${newsitem.headline}</a></div></td>
       </tr>
       <tr> 
         <td><div align="left"><em>${newsitem.description}</em></div></td>
       </tr>
       <tr>
         <td>&nbsp;</td>
       </tr>
     </c:forEach> 
    </table>
  </c:forEach>
</c:catch>
<c:if test="${not empty exception}">
  Sorry, no news. The RSS feeds are down. Cause: ${exception}
</c:if>
