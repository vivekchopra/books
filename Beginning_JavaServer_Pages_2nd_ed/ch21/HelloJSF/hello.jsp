<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<html>
<head><title>HelloJSF</title></head>
<body>
    <f:view>
        <h:form id="helloForm">
            Please enter your name:
            <h:inputText id="name" value="#{HelloBean.name}" />
            <h:commandButton action="#{HelloBean.action}" value="Go" id="submit" />
            <BR/>
            <h:messages />
        </h:form>
    </f:view>
</body>
</html>
