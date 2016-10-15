<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<html>
<head><title>JSF Greeting</title></head>
<body>
    <f:view>
        Hello&nbsp<h:outputText value="#{HelloBean.name}"/><BR/>
    </f:view>
</body>
</html>
