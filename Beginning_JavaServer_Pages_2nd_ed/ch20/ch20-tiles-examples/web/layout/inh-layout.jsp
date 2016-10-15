<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:importAttribute />
<html>
  <head>
    <title>Inheritance Example</title>	
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
  	<tiles:insert attribute="menu.region"/>
  </td>
  <td valign="top"  align="left">
  <h3>Favorite Movies</h3>
	  <ul>
	  	<c:forEach items="${myMovies}" var="thisMovie">
				<li>${thisMovie}</li>
		  </c:forEach>
	  </ul>	  
  </td>
</tr>
<tr>
	<td colspan="2"><center><tiles:insert attribute="footer"/></center></td>
</tr>
</table>
</body>
</html>
