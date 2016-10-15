<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" >
<title>Formulaire de Demande</title>
</head>
<body>
<h1>Formulaire de Demande</h1>
</br>
<c:url value="procform.jsp" var="actionURL"/>
<form action="${actionURL}" method="post">
<table>
<tr>
<td>Prénom</td>
<td><input type="text" name="lastname" size="40"/></td>
</tr>

<tr>
<td>Nom</td>
<td><input type="text" name="firstname" size="40"/></td>
</tr>


<tr>
<td>Code postal</td>
<td><input type="text" name="postcode" size="40"/></td>
</tr>


<tr>
<td>Mot de passé</td>
<td><input type="password" name="pass" size="40"/></td>
</tr>


<tr>
<td colspan="2" align="center">
<input type="submit" value="Valider"/></td>
</tr>


</table>

</form>

</body>
</html>











