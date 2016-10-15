<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/app.tld"    prefix="app" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<script Language="JavaScript">

function validRequired(formField,fieldLabel)
{
        var result = true;
        if (formField.value == "")
        {
                alert('Please enter a value for the "' + fieldLabel +'" field.');
                formField.focus();
                result = false;
        }
        
        return result;
}

function validateForm(theForm)
{
        if (!validRequired(theForm.userName,"Name"))
                return false;

        if (!validRequired(theForm.password,"Password"))
                return false;

        if (!validRequired(theForm.displayName,"Display Name"))
                return false;

        if (!validRequired(theForm.interests,"Interests"))
                return false;

        if (!validRequired(theForm.subscriptions,"Subscriptions"))
                return false;

        return true;
}
</script>

<html:html>
<head>
  <title><bean:message key="registration.title.create"/></title>
<html:base/>
</head>
<body bgcolor="white">

<html:errors/>

<html:form action="/saveRegistration" onsubmit="return validateForm(this)">
<html:hidden property="action"/>
<table border="0" width="100%">

  <tr>
    <th align="right">
      <bean:message key="registration.username"/>:
    </th>
    <td align="left">
        <html:text property="userName" size="16" maxlength="16"/>
    </td>
  </tr>

  <tr>
    <th align="right">
      <bean:message key="registration.password"/>:
    </th>
    <td align="left">
      <html:password property="password" size="16" maxlength="16"/>
    </td>
  </tr>

  <tr>
    <th align="right">
      <bean:message key="registration.displayName"/>:
    </th>
    <td align="left">
      <html:text property="displayName" size="50"/>
    </td>
  </tr>
  
  <tr>
    <th align="right">
      <bean:message key="registration.interests"/>:
    </th>
    <td align="left">
      <html:text property="interests" size="50"/>
    </td>
  </tr>
  
  <tr>
    <th align="right">
      <bean:message key="registration.subscription"/>:
    </th>
    <td align="left">
      <html:select property="subscriptions" multiple="true">
         <c:forEach items="${publisher_info}" var="a_publisher">
             <jsp:useBean id="a_publisher" type="com.wrox.begjsp.ch27.dto.Publisher"/>
             <html:option value="${a_publisher.feedUrl}">[${a_publisher.name}] ${a_publisher.description}</html:option>
        </c:forEach>
      </html:select>
    </td>
  </tr>

  <tr>
    <td align="right">
      <html:submit>
        <bean:message key="button.save"/>
      </html:submit>
    </td>
    <td align="left">
      <html:reset>
        <bean:message key="button.reset"/>
      </html:reset>
    </td>
  </tr>

</table>
</html:form>

</body>
</html:html>
