<!--
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
-->

<sql:setDataSource dataSource="jdbc/FootyDB" />
<c:set value="This Weeks Results" var="title" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title><c:out value="${title}" /></title>
  </head>
  <body>
    <h1><c:out value="${title}" /></h1>
    <table>
      <tr><th>Home Team</th><th>Away Team</th></tr>
      <sql:query var="results" scope="page">
        SELECT * from games
      </sql:query>
      <c:forEach items="${results.rows}" var="game" >
        <tr>
          <td <c:if test="${game.winner == 1}">bgcolor="yellow"</c:if>>${game.home_team}</td>
          <td <c:if test="${game.winner == 2}">bgcolor="yellow"</c:if>>${game.away_team}</td>
        </tr>
      </c:forEach>

    </table>
  </body>
</html>