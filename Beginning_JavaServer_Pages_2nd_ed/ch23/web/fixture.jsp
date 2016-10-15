<!--
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
-->
<jsp:useBean id="fixtures" class="java.util.ArrayList" scope="request" />
<jsp:useBean id="teams" class="java.util.ArrayList" scope="request" />
<jsp:useBean id="rounds" class="java.util.ArrayList" scope="request" />
<jsp:useBean id="venues" class="java.util.ArrayList" scope="request" />
<jsp:useBean id="SERVLET_PATH" class="java.lang.String" scope="request" />

<c:set value="Team Fixture Management" var="title" />
<html>
  <head>
    <title><c:out value="${title}" /></title>
  </head>
  <body>
    <h1><c:out value="${title}" /></h1>
    <table border="1">
      <tr>
        <th>Fixture ID</th>
        <th>Round #</th>
        <th>Home Team</th>
        <th>Away Team</th>
        <th>Venue</th>
        <th colspan="2">&nbsp;</th>
      </tr>
      <form name="fixturelist" action="<c:out value="${SERVLET_PATH}" />" method="POST">
        <input type="hidden" name="ACTION" value="FIXTURE_DELETE" />
        <c:forEach var="fixture" items="${fixtures}" >
          <tr>
            <td>${fixture.id}</td>
            <td>${fixture.round.roundNumber}</td>
            <td>${fixture.homeTeam.name}</td>
            <td>${fixture.awayTeam.name}</td>
            <td>${fixture.venue.location}</td>
            <td><input name="DELETE_LIST" type="checkbox" value="${fixture.id}" /></td>
          </tr>
        </c:forEach>
        <tr>
          <td align="right" colspan="5">Delete selected items</td>
          <td><input name="DELETE_BUTTON" type="submit" value="Delete Checked" /></td>
        </tr>
      </form>
      <form action="<c:out value="${SERVLET_PATH}" />" method="POST">
      <input type="hidden" name="ACTION" value="FIXTURE_ADD" />
      <tr>
        <td>&nbsp;</td>
        <td>
          <select name="round_id">
            <c:forEach var="round" items="${rounds}" >
              <option value="${round.id}">${round.roundNumber}</option>
            </c:forEach></select>
        </td>
        <td>
          <select name="home_team_id">
            <c:forEach var="homeTeam" items="${teams}" >
              <option value="${homeTeam.id}">${homeTeam.name}</option>
            </c:forEach>
          </select>
        </td>
        <td>
          <select name="away_team_id">
            <c:forEach var="awayTeam" items="${teams}" >
              <option value="${awayTeam.id}">${awayTeam.name}</option>
            </c:forEach>
          </select>
        </td>
        <td>
          <select name="venue_id">
            <c:forEach var="venue" items="${venues}" >
              <option value="${venue.id}">${venue.location}</option>
            </c:forEach>
          </select>
        </td>
        <td><input name="ADD" type="submit" value="Add Fixture" /></td>
      </tr>
    </table>
    <a href="menu.html">Main Menu</a>
  </body>
</html>
