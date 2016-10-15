<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<table cellspacing="0" width="100%" cellpadding="5" border="0">
<tr>
	<td valign="top">
	<tiles:insert attribute="menuTile">
		<tiles:put name="menuList" beanName="menuItems" beanScope="tile"/>
	</tiles:insert>
	</td>
</tr>
</table>