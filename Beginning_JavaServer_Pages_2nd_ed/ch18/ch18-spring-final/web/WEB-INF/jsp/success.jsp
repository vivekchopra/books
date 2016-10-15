<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
	<title><fmt:message key="success.title"/></title>
</head>
<body>

<h1><fmt:message key="success.title"/></h1>

<b><fmt:message key="form.name.title"/></b>:${testForm.name}<br>
<b><fmt:message key="form.age.title"/></b>:${testForm.age}<br>
<b><fmt:message key="form.comments.title"/></b><br>
${testForm.comments}

</body>
</html>

