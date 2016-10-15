<!--
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
-->
<jsp:useBean id="rounds" class="java.util.ArrayList" scope="request" />
<jsp:useBean id="SERVLET_PATH" class="java.lang.String" scope="request" />
<c:set value="Team Round Listing With Fixtures" var="title" />
<html>
  <head>
    <title><c:out value="${title}" /></title>
  </head>
  <body>
    <h1><c:out value="${title}" /></h1>
    <table border="1">
      <c:forEach var="round" items="${rounds}" >
        <form name="round" action="<c:out value="${SERVLET_PATH}" />" method="POST">
        <input type="hidden" name="ACTION" value="ROUND_DELETE" />
        <tr>
          <td>Round #${round.roundNumber}</td>
          <td>${round.startDate}</td>
          <td>${round.endDate}</td>
          <td><input name="DELETE_LIST" type="checkbox" value="${round.id}" /></td>
        </tr>
        <c:forEach var="fixture" items="${round.fixtures}" >
          <tr bgcolor="lightblue" >
            <td>${fixture.homeTeam.name}</td>
            <td>${fixture.awayTeam.name}</td>
            <td>${fixture.venue.location}</td>
            <td>&nbsp;</td>
          </tr>
        </c:forEach>
      </c:forEach>
      <tr>
        <td align="right" colspan="3">Delete selected items</td>
        <td><input name="DELETE_BUTTON" type="submit" value="Delete Checked" /></td>
      </tr></form>
    </table>
  <a href="menu.html">Main Menu</a>
  </body>
</html>
