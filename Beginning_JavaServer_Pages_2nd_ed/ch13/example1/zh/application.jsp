<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" >
<title>申請表格</title>
</head>
<body>
<h1>申請表格</h1>
</br>
<c:url value="procform.jsp" var="actionURL"/>
<form action="${actionURL}" method="post">
<table>
<tr>
<td>姓</td>
<td><input type="text" name="lastname" size="40"/></td>
</tr>

<tr>
<td>名字</td>
<td><input type="text" name="firstname" size="40"/></td>
</tr>


<tr>
<td>郵政編號</td>
<td><input type="text" name="postcode" size="40"/></td>
</tr>


<tr>
<td>密碼</td>
<td><input type="password" name="pass" size="40"/></td>
</tr>


<tr>
<td colspan="2" align="center">
<input type="submit" value="提交表格"/></td>
</tr>


</table>

</form>

</body>
</html>











