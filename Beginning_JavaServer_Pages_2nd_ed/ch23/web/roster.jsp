<!--
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
-->
<jsp:useBean id="roster" class="java.util.ArrayList" scope="request" />
<jsp:useBean id="SERVLET_PATH" class="java.lang.String" scope="request" />
<c:set value="Team Roster Management" var="title" />
<html>
  <head>
    <script type="text/javascript" >
      function modifyTeam(id) {
      var roster = document.rosterlist;
      roster.ACTION.value="ROSTER_MODIFY";
      roster.teamid.value=id;
      var elementName = "teamname_"+id;
      var name = roster.elements[elementName].value;
      roster.teamname.value=name;
      roster.submit();
      }
      function deleteTeam() {
      document.rosterlist.ACTION.value="ROSTER_DELETE";
      document.rosterlist.submit();
      }
    </script>
    <title><c:out value="${title}" /></title>
  </head>
  <body>
    <h1><c:out value="${title}" /></h1>
    <table border="1">
      <tr>
        <th>Team ID</th>
        <th>Team Name</th>
        <th>New Name</th>
        <th colspan="2">&nbsp;</th>
      </tr>
      <form name="rosterlist" action="<c:out value="${SERVLET_PATH}" />" method="POST">
        <input type="hidden" name="ACTION" value="ROSTER" />
        <input type="hidden" name="teamid" value="" />
        <input type="hidden" name="teamname" value="" />
        <c:forEach var="team" items="${roster}" >
          <tr>
            <td>${team.id}</td>
            <td>${team.name}</td>
            <td><input id="teamname_${team.id}" type="text" size="20" /></td>
            <td><input type="button" value="Modify" onclick="modifyTeam('${team.id}')" /></td>
            <td><input name="DELETE_LIST" type="checkbox" value="${team.id}" /></td>
          </tr>
        </c:forEach>
        <tr>
          <td align="right" colspan="4">Delete selected items</td>
          <td><input name="DELETE_BUTTON" type="button" value="Delete Checked" onclick="deleteTeam()" /></td>
        </tr>
      </form>
      <form action="<c:out value="${SERVLET_PATH}" />" method="POST">
      <input type="hidden" name="ACTION" value="ROSTER_ADD" />
      <tr>
        <td colspan="2"><b>Add new Team</b></td>
        <td><input name="teamname" type="text" size="20" /></td>
        <td><input name="ADD" type="submit" value="Add" /></td>
        <td>&nbsp;</td>
      </tr>
    </table>
    <a href="menu.html">Main Menu</a>
  </body>
</html>
