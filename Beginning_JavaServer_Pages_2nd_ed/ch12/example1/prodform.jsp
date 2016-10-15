<html>
<head>
<title>Product Information Entry Form</title>
<script language="JavaScript">
function isDigitsOnly(inParam) {
  var chkExp = /^\d+$/;
  return (chkExp.test(inParam));
}
function isTextOnly(inParam) {
 var chkExp = /^[a-z][a-z\d ]+$/i;
  return (chkExp.test(inParam));
}
function validateForm() {
  var formValid = true;
  if (!isDigitsOnly(document.prodform.sku.value)) {
    document.getElementById("skuError").style.visibility = "visible";
    formValid = false;
  }
  else
    document.getElementById("skuError").style.visibility = "hidden";

  if (!isTextOnly(document.prodform.name.value)) {
    document.getElementById("nameError").style.visibility = "visible";
    formValid = false;
  }
  else
    document.getElementById("nameError").style.visibility = "hidden";

  if (!isTextOnly(document.prodform.desc.value)) {
    document.getElementById("descError").style.visibility = "visible";
    formValid = false;
  }
  else
    document.getElementById("descError").style.visibility = "hidden";

  if (!isDigitsOnly(document.prodform.price.value)) {
    document.getElementById("priceError").style.visibility = "visible";
    formValid = false;
  }
  else
    document.getElementById("priceError").style.visibility = "hidden";

 if (!formValid)
    alert("Some values you entered are invalid, please correct the entries marked in red." );

  return formValid;
}

</script>
<style>
span.validateError{
color: red;
visibility: hidden;}
</style>
</head>
<body>
        <h1>Enter Product Information</h1>
<form  name="prodform" action="index.jsp" method="post" onsubmit="return validateForm()">
<table border="0" >
<tr>
   <td>SKU:</td> <td><input name="sku" type="text" width="40"/><span id="skuError" class="validateError"><-- please enter digits only</span> </td>
 </tr>
 
 <tr>
   <td>Name:</td> <td><input name="name" type="text" width="40"/><span id="nameError" class="validateError"><-- please enter letters or numbers only, do not start with a number</span> </td>
 </tr>
 <tr>
   <td>Description:</td> <td><input name="desc" type="text" width="40"/><span id="descError" class="validateError"><-- please enter letters or numbers only, do not start with a number</span> </td>
 </tr>
 <tr>
   <td>Price:</td> <td> <input name="price" type="text" width="40"/><span id="priceError" class="validateError"><-- please enter price in dollars only, do not enter cents</span></td>
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
