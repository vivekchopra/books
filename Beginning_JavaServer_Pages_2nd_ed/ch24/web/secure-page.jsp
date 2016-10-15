<!--
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
-->
<c:set value="Secure Page" var="title" />
<html>
  <head>
    <title>
      <c:out value="${title}" />
    </title>
  </head>
  <body>
    <h1>
      <c:out value="${title}" />
    </h1>
    This is a secure page ! <p/>
    Hello, <b>${pageContext.request.remoteUser}</b>
    
    <p/>
    
    As a principal : <p/>
    
    Hello, <b>${pageContext.request.userPrincipal.name}</b>
    
  </body>
</html>