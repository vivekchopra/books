<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/app.tld" prefix="app" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<jsp:useBean id="profile" scope="session" type="com.wrox.begjsp.ch27.dto.UserProfile"/>

<table width="100%" border="0">
  <tr> 
    <td width="25%">&nbsp;</td>
    <td width="50%"><h1 align="center"><bean:message key="portalPage.heading"/></h1></td>
    <td width="25%">&nbsp;</td>
  </tr>
  <tr> 
    <td><div align="left"><bean:message key="portalPage.greetings"/> <jsp:getProperty name="profile" property="displayName"/></div></td>
    <td>&nbsp;</td>
    <td><div align="right">[<html:link page="/editProfile.do"><bean:message key="portalPage.registration"/></html:link>|<html:link forward="logoff"><bean:message key="portalPage.logoff"/></html:link>]</div></td>
  </tr>
</table>

