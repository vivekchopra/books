<!--
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
-->
<c:set value="Round Management" var="title" />

<sql:query var="roundlist" dataSource="jdbc/FootyDB" >
  SELECT * FROM round ORDER BY round.number ASC
</sql:query>

<html>
  <head>
    <title><c:out value="${title}" /></title>
  </head>
  <body>
    <h1><c:out value="${title}" /></h1>
    <table border="1">
      <tr>
        <th>Round Number</th>
        <th>Start Date</th>
        <th colspan="2">End Date</th>
      </tr>
      <c:forEach var="round" items="${roundlist.rows}" >
        <tr>
          <td>${round.number}</td>
          <td>${round.startdate}</td>
          <td colspan="2">${round.enddate}</td>
        </tr>
      </c:forEach><tr>
        <form name="round-input" action="round-process.jsp" method="POST">
          <td><input name="round_number" type="text" size="20" /></td>
          <td><input name="round_startdate" type="text" size="20" /></td>
          <td><input name="round_enddate" type="text" size="20" /></td>
          <td><input type="submit" value="Update" /></td>
        </form>
      </tr>
    </table>
    NOTE: Enter dates in YYYY-MM-DD format.
    <p/>
    <a href="menu.html">Main Menu</a>    
  </body>
</html>