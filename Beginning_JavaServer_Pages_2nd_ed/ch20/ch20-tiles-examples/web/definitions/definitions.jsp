<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<tiles:definition 
		   id="simple.include.layout" 
		   page="/layout/simplelayout.jsp" 
		   scope="request">
  <tiles:put name="header" value="/tiles/simple-header.jsp" />
  <tiles:put name="menu" value="/tiles/simple-menu.jsp" />
  <tiles:put name="body" value="/tiles/simple-body.jsp" />
  <tiles:put name="footer" value="/tiles/simple-footer.jsp" />
</tiles:definition>

<tiles:definition 
		   id="simple.include.layout.title" 
		   page="/layout/simplelayout-title.jsp" 
		   scope="request">
  <tiles:put name="title" value="This is my New Title"/>
  <tiles:put name="header" value="/tiles/simple-header-title.jsp" />
  <tiles:put name="menu" value="/tiles/simple-menu.jsp" />
  <tiles:put name="body" value="/tiles/simple-body.jsp" />
  <tiles:put name="footer" value="/tiles/simple-footer.jsp" />
</tiles:definition>