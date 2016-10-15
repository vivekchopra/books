<!--
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
-->

<jsp:useBean id="footy" class="com.wrox.begjsp.ch22.jdbc.JDBCHelper" />
<c:set value="This Weeks Results" var="title" />

<html>
  <head>
    <title><c:out value="${title}" /></title>
  </head>
  <body>
    <h1><c:out value="${title}" /></h1>
    <table>
      <tr><th>Home Team</th><th>Away Team</th></tr>
      <c:forEach var="game" items="${footy.results}" >
      <tr><td <c:if test="${game.homeWinner}">bgcolor="yellow"</c:if> >${game.home}</td>
          <td <c:if test="${!game.homeWinner}">bgcolor="yellow"</c:if> >${game.away}</td>
      </c:forEach>
    </table>
  </body>
</html>