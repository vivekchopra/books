<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
  <head>
    <title>International Example</title>	
  </head>
<body bgcolor="white">

<table border="1" width="100%" height="100%" border="1">
<tr>
  <td colspan="2" height="100" bgcolor="gray">
    	<tiles:insert attribute="header"/>
  </td>  
</tr>
<tr>
  <td width="20%" valign="top" bgcolor="lightgrey">
  	<tiles:insert attribute="menu"/>
  </td>
  <td valign="top"  align="left">
  	<tiles:insert attribute="body"/>
  </td>
</tr>
<tr>
	<td colspan="2"><center><tiles:insert attribute="footer"/></center></td>
</tr>
</table>
</body>
</html>
