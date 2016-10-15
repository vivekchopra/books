<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags/wroxtags" %>
<%@page contentType="text/xml" %>
<?xml version="1.0"?>
<entry>
  <my:getInfo/>

  <name>
   <c:out value="${name}"/>
  </name>
  <comment>
   <c:out value="${comment}"/>
  </comment>
  <code>
   <c:out value="${code}"/>
  </code>
</entry>
