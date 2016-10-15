<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/xml" %>
<product> 
<jsp:useBean id="localProd" class="com.wrox.begjsp.ch03.Product" />
<jsp:setProperty name="localProd" property="*" />
<sku>
<jsp:getProperty name="localProd" property="sku"/> 
</sku>
<name>
<jsp:getProperty name="localProd" property="name"/>
</name>
<desc>
<jsp:getProperty name="localProd" property="desc"/>
</desc>
<price>
<fmt:formatNumber value="${localProd.price / 100}" type="currency"/>
</price>
</product>