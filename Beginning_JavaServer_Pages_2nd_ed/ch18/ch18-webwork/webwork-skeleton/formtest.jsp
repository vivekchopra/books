<%@ taglib uri="webwork" prefix="webwork" %>
<%@ taglib uri="webwork" prefix="ui" %>
<%@ taglib uri="webwork" prefix="iterator" %>

<link rel="stylesheet" type="text/css" href="template/standard/styles.css" title="Style">

<html>
<head>
<title>Form Test</title>
</head>
<body>

<h1>Form Test</h1>

<center>
<form action="<webwork:url page="formtest.action"/>" method="POST">

<table width="350" border="0" cellpadding="3" cellspacing="0">
   <ui:textfield label="'User'" name="'user'"/>
   <webwork:bean name="'webwork.util.Counter'" id="ages">
     <webwork:param name="'first'" value="0"/>
     <webwork:param name="'last'" value="100"/>
     <ui:combobox label="'Age'" size="3" maxlength="3" name="'age'" list="@ages"/>
   </webwork:bean>

   <ui:textarea label="'Comments'" name="'comments'" cols="30" rows="8"/>

   <tr><td colspan="2" align="center">
   <input type=submit value="Update">
   </td></tr>
</table>
</form>
</center>

</body>
</html>
