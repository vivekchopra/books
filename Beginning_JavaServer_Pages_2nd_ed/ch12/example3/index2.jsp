<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags/wroxtags" %>
<%@page contentType="text/xml" %>
<?xml version="1.0"?>
<entry>
  <my:getInfo/>

  <name>
    ${fn:escapeXml(name)}  
  </name>
  <comment>
   ${fn:escapeXml(comment)}
  </comment>
  <code>
   ${fn:escapeXml(code)}
  </code>
</entry>
