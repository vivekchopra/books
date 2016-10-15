<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<tiles:insert page="/layout/simplelayout.jsp" flush="true">
  <tiles:put name="header" value="/tiles/simple-header.jsp" />
  <tiles:put name="menu" value="/tiles/simple-menu.jsp" />
  <tiles:put name="body" value="/tiles/simple-body.jsp" />
  <tiles:put name="footer" value="/tiles/simple-footer.jsp" />
</tiles:insert>