<!--
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
-->
<jsp:useBean id="now" class="java.util.Date" scope="request" />
<jsp:useBean id="user" class="java.lang.String" scope="request" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title> Form Data </title>
  </head>
  <body>
    <h1> Form Data </h1>
    <table>
      <tr>
        <td>The name entered was: </td>
        <td>
          <b>
            <c:out value="${user}" />
          </b>
        </td>
      </tr>
      <tr>
        <td>Date processed: </td>
        <td>
          <fmt:formatDate value="${now}" type="both" />
        </td>
      </tr>
    </table>
    <p/>
    <a href="name">Try Again!</a>
  </body>
</html>