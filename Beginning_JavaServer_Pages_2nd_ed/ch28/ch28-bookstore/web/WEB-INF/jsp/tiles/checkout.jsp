<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib prefix="begjsp" tagdir="/WEB-INF/tags" %>

<table cellspacing=3 cellpadding=3 width="100%">
<tr>
	<td><h3><bean:message key="checkout.message.title"/></h3></td>
</tr>
<c:choose>
	<c:when test="${cart.itemCount gt 0}">
	<tr>
		<td>
			<html:form action="completeorder.do">
			<table cellspacing=0 cellpadding=0>
			<logic:messagesPresent property="firstName">
		  <tr>
			      <td colspan=2>
				      <font color="red">
					      <html:errors property="firstName"/>
				      </font>
			      </td>			      
		  </tr>
		  <tr>
				<td colspan="2">&nbsp;</td>
			</tr>
			</logic:messagesPresent>
			<tr>
				<td width="200"><bean:message key="checkout.field.firstName"/></td>
				<td><html:text property="firstName"/></td>
			</tr>
		  <tr>
				<td colspan="2">&nbsp;</td>
			</tr>	
			<logic:messagesPresent property="lastName">
		  <tr>
			      <td colspan=2>
				      <font color="red">
					      <html:errors property="lastName"/>
				      </font>
			      </td>
		  </tr>
		  <tr>
				<td colspan="2">&nbsp;</td>
			</tr>
			</logic:messagesPresent>
			<tr>
				<td><bean:message key="checkout.field.lastName"/></td>
				<td><html:text property="lastName"/></td>
			</tr>
		  <tr>
				<td colspan="2">&nbsp;</td>
			</tr>	
			<logic:messagesPresent property="address">
		  <tr>
			      <td colspan=2>
			      	<font color="red">
			      		<html:errors property="address"/>
			      	</font>
			      </td>
		  </tr>
		  <tr>
				<td colspan="2">&nbsp;</td>
			</tr>
			</logic:messagesPresent>
			<tr>
				<td><bean:message key="checkout.field.address"/></td>
				<td><html:text property="address"/></td>
			</tr>
		  <tr>
				<td colspan="2">&nbsp;</td>
			</tr>	
			<logic:messagesPresent property="zipCode">
		  <tr>
			      <td colspan=2>
				      <font color="red">
					      <html:errors property="zipCode"/>
					    </font>  
				    </td>
		  </tr>
		  <tr>
				<td colspan="2">&nbsp;</td>
			</tr>
			</logic:messagesPresent>
			<tr>
				<td><bean:message key="checkout.field.zipCode"/></td>
				<td><html:text property="zipCode"/></td>
			</tr>
		  <tr>
				<td colspan="2">&nbsp;</td>
			</tr>	
			<logic:messagesPresent property="cardNumber">
		  <tr>
			      <td colspan=2>
				      <font color="red">
					      <html:errors property="cardNumber"/>
					    </font>  
				    </td>
		  </tr>
		  <tr>
				<td colspan="2">&nbsp;</td>
			</tr>
			</logic:messagesPresent>
			<tr>
				<td><bean:message key="checkout.field.cardNumber"/></td>
				<td><html:text property="cardNumber" /></td>
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><html:submit value="complete order"/></td>
			</tr>		
			</html:form>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table cellspacing=0 cellpadding=0 width="100%">
			<tr>
				<td colspan="4"><b><bean:message key="checkout.message.orderContent"/></b></td>
			</tr>
			<tr>
			<td>			
				<begjsp:listitems items="${cart.items}"/>
			</td>
			</tr>
			</table>
		</td>
	</tr>
	</c:when>	
	<c:otherwise>
		<tr>
			<td><bean:message key="checkout.message.orderContentEmpty"/></td>
		</tr>
	</c:otherwise>		
</c:choose>
</table>
