<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel=stylesheet type="text/css" href="auction.css">
<title>Enter Your Bid</title></head>
<body>
<table class="mainBox" width="400">
<tr><td class="boxTitle" colspan="2">
Wrox JSP Auction
</td></tr>
<c:if test="${!(empty biderror)}">
  <tr>
    <td class="errorText" colspan="2">
       ${biderror.msg}
    </td>
  </tr>
</c:if>

<tr><td colspan="2">&nbsp;</td></tr>
<tr><td>
<form  action="index1.jsp" method="get">
<table>
<tr>
<td width="200">Item to bid on</td><td>
<select name="item">
<option>27 inch TV</option>
<option>DVD Player</option>
<option>Digital Camera</option>
</select>
<input type="hidden" name="action" value="bid"/>
</td></tr>
<tr>
<td>Bid Price:</td>
<td><input name="price" type="text" width="10"/>
</td></tr>
<tr><td colspan="2">&nbsp;</td></tr>
<tr><td colspan="2" align="center">
<input type="submit" value="Bid now!"/>
</td></tr>
</table>
</form>
</td></tr></table>
</body>
</html>
