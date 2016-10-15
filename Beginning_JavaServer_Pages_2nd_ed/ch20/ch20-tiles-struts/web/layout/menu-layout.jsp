<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<tiles:importAttribute/>

<table cellspacing="0" cellpadding="5" height="200" border="1">
<tr height="10">
	<td><font face="verdana" size="2"><b>
			<tiles:getAsString name="menuTitle"/>
			</b></font>
	</td>
</tr>
<tr>
	<td valign="top">
	<tiles:insert attribute="menuTile">
		<tiles:put name="menuList" beanName="menuItems" beanScope="tile"/>
	</tiles:insert>
	</td>
</tr>
</table>