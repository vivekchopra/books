<%@ taglib prefix="my" tagdir="/WEB-INF/tags/wroxtags" %>
<html>
<head>
<title>Product Information Entry Form</title>
<my:validateFunctions>
   <my:checkField name="sku" type="digits"/>
   <my:checkField name="name" type="alphanum"/>
   <my:checkField name="desc" type="alphanum"/>
   <my:checkField name="price" type="digits"/>
</my:validateFunctions>
</head>
<body>
<h1>Enter Product Information</h1>
<form  name="prodform" action="index.jsp" method="post" onsubmit="return validateForm()">
<table border="0" >
<tr>
   <td>SKU:</td> 
   <td>
     <input name="sku" type="text" width="40"/>
     <my:validateErrMsg name="sku" 
         msg="<-- please enter digits only"/>
    </td>
 </tr>
 
 <tr>
   <td>Name:</td> 
   <td>
      <input name="name" type="text" width="40"/>
      <my:validateErrMsg name="name" 
         msg="<-- please enter letters or numbers only, do not start with a number"/>
   </td>
 </tr>
 <tr>
   <td>Description:</td> 
   <td>
      <input name="desc" type="text" width="40"/>
      <my:validateErrMsg name="desc" 
         msg="<-- please enter letters or numbers only, do not start with a number"/>
     </td>
 </tr>
 <tr>
   <td>Price:</td> 
   <td>
      <input name="price" type="text" width="40"/>
      <my:validateErrMsg name="price" 
         msg="<-- please enter price in dollars only, do not enter cents"/>
   </td>
 </tr>
 
<tr>
   <td colspan="2"> <input type="submit" value="Add Product" />
   <input type="hidden" name="action" value="prodsubmit"/>
   </td>
 </tr>
 

</table>
</form>
</body>
</html>
