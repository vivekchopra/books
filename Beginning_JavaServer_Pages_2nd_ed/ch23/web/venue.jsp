<!--
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
-->
<jsp:useBean id="venues" class="java.util.ArrayList" scope="request" />
<jsp:useBean id="SERVLET_PATH" class="java.lang.String" scope="request" />
<c:set value="Team Venue Management" var="title" />
<html>
  <head>
    <script type="text/javascript" >
      function modifyVenue(id) {
      var venue = document.venuelist;
      venue.ACTION.value="VENUE_MODIFY";
      venue.venueid.value=id;
      var elementName = "venue_"+id;
      var name = venue.elements[elementName].value;
      venue.venuename.value=name;
      venue.submit();
      }
      function deleteVenue() {
      document.venuelist.ACTION.value="VENUE_DELETE";
      document.venuelist.submit();
      }
    </script>
    <title><c:out value="${title}" /></title>
  </head>
  <body>
    <h1><c:out value="${title}" /></h1>
    <table border="1">
      <tr>
        <th>Venue ID</th>
        <th>Venue Name</th>
        <th colspan="2">&nbsp;</th>
      </tr>
      <form name="venuelist" action="<c:out value="${SERVLET_PATH}" />" method="POST">
        <input type="hidden" name="ACTION" value="VENUE" />
        <input type="hidden" name="venueid" value="" />
        <input type="hidden" name="venuename" value="" />
        <c:forEach var="venue" items="${venues}" >
          <tr>
            <td>${venue.id}</td>
            <td>${venue.location}</td>
            <td><input id="venue_${venue.id}" type="text" size="20" /></td>
            <td><input type="button" value="Modify" onclick="modifyVenue('${venue.id}')" /></td>
            <td><input name="DELETE_LIST" type="checkbox" value="${venue.id}" /></td>
          </tr>
        </c:forEach>
        <tr>
          <td align="right" colspan="4">Delete selected items</td>
          <td><input name="DELETE_BUTTON" type="button" value="Delete Checked" onclick="deleteVenue()" /></td>
        </tr>
      </form>
      <form action="<c:out value="${SERVLET_PATH}" />" method="POST">
      <input type="hidden" name="ACTION" value="VENUE_ADD" />
      <tr>
        <td colspan="2"><b>Add new Venue</b></td>
        <td><input name="venuename" type="text" size="20" /></td>
        <td><input name="ADD" type="submit" value="Add" /></td>
        <td>&nbsp;</td>
      </tr>
    </table>
    <a href="menu.html">Main Menu</a>
  </body>
</html>
