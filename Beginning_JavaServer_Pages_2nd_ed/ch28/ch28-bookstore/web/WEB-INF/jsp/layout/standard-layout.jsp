<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<html>
  <head>
    <title>Online Bookstore</title>	
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
  <td colspan="2" height="50" bgcolor="gray">
  	<tiles:insert attribute="base"/>
  </td>
</tr>
</table>
</body>
</html>