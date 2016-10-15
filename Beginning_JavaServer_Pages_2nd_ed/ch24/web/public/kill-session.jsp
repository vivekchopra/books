<!--
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
-->

<jsp:scriptlet>
  session.invalidate(); 
</jsp:scriptlet>

<c:redirect url="../index.html" />