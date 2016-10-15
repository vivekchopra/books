<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="log" uri="http://jakarta.apache.org/taglibs/log-1.0" %>
<html>
<head><title>JSP Log Tags Page</title></head>
<body>
    <c:set var="myvar" value="Message comes from an EL expression" scope="page" />
    <c:set var="logCat" value="${pageContext.page.class.name}" scope="page" />
    <log:debug>It is bad practice to log messages without a category</log:debug>
    <log:debug category="${logCat}" >
         This should appear in the logs if DEBUG is enabled.
    </log:debug>
    <log:info category="${logCat}" message="${myvar}" />
    <log:warn 
        category="${logCat}" 
        message="URI is ${pageContext.request.requestURI}" 
    />
    <log:error category="${logCat}">
        This is logging body content as the  message 
    </log:error>
    <log:fatal category="${logCat}" message="fatal message" />

    You should see output in the info logs now.
    <log:dump scope="application" />
</body>
</html>