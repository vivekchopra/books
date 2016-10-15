<%@ taglib prefix="my" tagdir="/WEB-INF/tags/wroxtags" %>
<html>
<head>
<title>Auction Bidding</title>
<my:validateFunctions>
   <my:checkField name="name" type="alphanum"/>
   <my:checkField name="item" type="digits"/>
   <my:checkField name="bid" type="digits"/>
</my:validateFunctions>
</head>
<body>
<h1>Enter Your Bid Information</h1>
<form  name="prodform" action="index1.jsp" method="post" onsubmit="return validateForm()">
<table border="0" >
<tr>
   <td>Name:</td> 
   <td>
     <input name="name" type="text" width="40"/>
     <my:validateErrMsg name="name" 
         msg="<-- please enter alphabet letters only"/>
    </td>
 </tr>
 
 <tr>
   <td>Item Number:</td> 
   <td>
      <input name="item" type="text" width="40"/>
      <my:validateErrMsg name="item" 
         msg="<-- please enter numeric digits only"/>
   </td>
 </tr>
 <tr>
   <td>Bid Price:</td> 
   <td>
      <input name="bid" type="text" width="40"/>
      <my:validateErrMsg name="bid" 
         msg="<-- please enter price in dollars only, do not enter cents"/>
   </td>
 </tr>
 
<tr>
   <td colspan="2"> <input type="submit" value="Bid now!" />
   <input type="hidden" name="action" value="bidsubmit"/>
   </td>
 </tr>
 

</table>
</form>
</body>
</html>
