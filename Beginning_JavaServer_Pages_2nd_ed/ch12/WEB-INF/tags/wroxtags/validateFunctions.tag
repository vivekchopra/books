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
<jsp:doBody/>
  return formValid;
}
</script>
<style>
span.validateError{
color: red;
visibility: hidden;}
</style>
