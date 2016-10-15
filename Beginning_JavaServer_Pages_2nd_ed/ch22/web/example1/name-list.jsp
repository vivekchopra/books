<!--
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
-->

<jsp:useBean id="namespace" class="com.wrox.begjsp.ch22.example1.JNDINamespaceHelper" />
<c:set var="title" value="Listing the JNDI Namespace" />

<html>
  <head>
    <title> <c:out value="${title}" /></title>
  </head>
  <body>
    <h1><c:out value="${title}" /></h1>
    <table border="1" width="90%">
      <tr><th>Context</th><th>Object Name</th><th>Object Class</th><th width="50%">Object Value</th></tr>
      <c:forEach items="${namespace.namespace}" var="element" >
        <tr>
          <td> <c:out value="${element.contextName}" /></td>
          <td> <c:out value="${element.name}" /></td>
          <td> <c:out value="${element.className}" /></td>
          <td> <c:out value="${fn:replace(element.object, ',', ', ')}" /></td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>