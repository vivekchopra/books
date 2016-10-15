<html>
<head>
<title>Error in Scripting Element</title>
</head>
<body>
       <h1>Page with error in scripting element</h1>

<%
int sum= 0;
for { int i=0; i<50; i++ }
  sum = sum + i;

%>
</body>
</html>
