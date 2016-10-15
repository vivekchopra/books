<!--
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
-->

<jsp:useBean id="env" class="com.wrox.begjsp.ch22.jndi.JNDIHelper" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title> <c:out value="${env.title}" /></title>
  </head>
  <body>
    <h1><c:out value="${env.title}" /></h1>
    <table>
      <tr>
        <td>This is version number: </td>
        <td>
          <b>
            <c:out value="${env.version}" />
          </b>
        </td>
      </tr>
    </table>
  </body>
</html>