<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Application Form</title>
</head>
<body>
<h1>Application Form</h1>
</br>
<c:url value="procform.jsp" var="actionURL"/>
<form action="${actionURL}" method="post">
<table>
<tr>
<td>Last Name</td>
<td><input type="text" name="lastname" size="40"/></td>
</tr>

<tr>
<td>First Name</td>
<td><input type="text" name="firstname" size="40"/></td>
</tr>


<tr>
<td>Postal or Zip Code</td>
<td><input type="text" name="postcode" size="40"/></td>
</tr>


<tr>
<td>Password</td>
<td><input type="password" name="pass" size="40"/></td>
</tr>


<tr>
<td colspan="2" align="center">
<input type="submit" value="Submit Application"/></td>
</tr>


</table>

</form>

</body>
</html>











