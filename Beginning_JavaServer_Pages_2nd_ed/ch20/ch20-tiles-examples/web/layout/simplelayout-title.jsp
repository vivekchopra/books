<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<html>
  <head>
    <title><tiles:getAsString name="title"/></title>	
  </head>
<body bgcolor="white">

<table border="1" width="100%" height="100%" border="1">
<tr>
  <td colspan="2" height="100" bgcolor="gray">
  	<tiles:insert attribute="header">  	
  		<tiles:put name="headerTitle" beanName="title"/>
  	</tiles:insert>
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
  	<tiles:insert attribute="footer"/>
  </td>
</tr>
</table>
</body>
</html>
