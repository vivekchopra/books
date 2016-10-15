<%@ taglib prefix="my" tagdir="/WEB-INF/tags/wroxtags" %>
<%@page contentType="text/xml" %>
<?xml version="1.0"?>
<entry>
  <my:getInfo/>

  <name>
   ${name}
  </name>
  <comment>
   ${comment}
  </comment>
  <code>
   ${code}
  </code>
</entry>
