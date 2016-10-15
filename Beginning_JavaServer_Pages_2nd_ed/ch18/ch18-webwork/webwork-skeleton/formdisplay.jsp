<%@ taglib uri="webwork" prefix="webwork" %>

<html>
<head>
<title>Form Results</title>
</head>
<body>
   <p>
   <b>User:</b> <webwork:property value="user"/><br>
   <b>Age:</b><webwork:property value="age"/><br>
   <b>Comments:</b><br>
   <webwork:property value="comments"/>
   
   Advice<br>
   
   <ul>
   <webwork:iterator value="things">
        <li><webwork:property value="toString"/></li>
   </webwork:iterator>
   </ul>
   
</body>
</html>
