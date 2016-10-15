<!--
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
-->

<jsp:scriptlet>
  Context context = new InitialContext();
  Context applicationEnv = (Context)context.lookup("java:comp/env");
  String title = (String)applicationEnv.lookup("pageTitle");
  Integer version = (Integer)applicationEnv.lookup("versionNumber");
  
  pageContext.setAttribute("title", title);
  pageContext.setAttribute("version", version);
</jsp:scriptlet>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title> <c:out value="${title}" /></title>
  </head>
  <body>
    <h1><c:out value="${title}" /></h1>
    <table>
      <tr>
        <td>This is version number: </td>
        <td>
          <b>
            <c:out value="${version}" />
          </b>
        </td>
      </tr>
    </table>
  </body>
</html>