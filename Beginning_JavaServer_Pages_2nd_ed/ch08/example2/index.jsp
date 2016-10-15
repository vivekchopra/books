<html>
<head>
<title>Product Information Entry</title>
<style>
.label { font-weight: bold; }
</style>
</head>
<body>
        <h1> Enter Product Information</h1>
<form  action="procprod.jsp" method="post">
<table border="1">
<tr>
   <td class="label">SKU:</td> <td><input name="sku" type="text" width="40"/> </td>
 </tr>
 
 <tr>
   <td class="label">Name:</td> <td><input name="name" type="text" width="40"/> </td>
 </tr>
 <tr>
   <td class="label">Description:</td> <td><input name="desc" type="text" width="40"/> </td>
 </tr>
 <tr>
   <td class="label">Price:</td> <td> <input name="price" type="text" width="40"/></td>
 </tr>
 
<tr>
   <td colspan="2"> <input type="submit"/></td>
 </tr>
 

</table>
</form>
</body>
</html>
