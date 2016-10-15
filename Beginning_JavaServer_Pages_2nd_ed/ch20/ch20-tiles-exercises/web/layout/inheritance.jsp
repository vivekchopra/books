<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
  <head>
    <title>Inheritance Example</title>	
  </head>
<body bgcolor="white">

<table border="1" width="100%" height="100%" border="1">
<tr>
  <td height="100" bgcolor="gray">
    	<tiles:getAsString name="title"/>
  </td>  
</tr>
<tr>
  <td valign="top"  align="left">
  	<tiles:insert attribute="body"/>
  </td>
</tr>
</table>
</body>
</html>