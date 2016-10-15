<html>
<head>
<link rel=stylesheet type="text/css" href="portal.css">
<title>Select Your Portal</title></head>
<body>
<table class="mainBox" width="400">
<tr><td class="boxTitle" colspan="2">
Wrox JSP Portal Selector
</td></tr>
<tr><td colspan="2">&nbsp;</td></tr>
<tr><td>
<form  action="showportal.jsp" method="get">
<table>
<tr>
<td width="200">
Your First Name: </td>
<td><input name="username" type="text" size="25"/></td>
</tr>
<tr>
<td width="200">Color Theme</td><td>
<select name="color">
<option>blue</option>
<option>red</option>
<option>green</option>
</select>
</td></tr>

<tr>
<td width="200">Font</td><td>
<select name="font">
<option>sans-serif</option>
<option>serif</option>
</select>
</td></tr>

<tr>
<td width="200">Portal Selection</td><td>
<select name="portchoice">
<option>news</option>
<option>weather</option>
<option>entertainment</option>
</select>
</td></tr>
<tr><td colspan="2">&nbsp;</td></tr>
<tr><td colspan="2" align="center">
<input type="submit" value="Select"/>
</td></tr>
</table>
</form>
</td></tr></table>
</body>
</html>