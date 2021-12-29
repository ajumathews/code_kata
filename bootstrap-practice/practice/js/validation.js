$(document).ready (function(){


    $("#status_message").fadeOut(3000);


    $("#payment").submit(function(){
        return validateAddPaymentForm();
      }
    );


   $("add-nav-link").click(function(){

        alert("hello")
    }

   );

function validateAddPaymentForm(){
  clearErrorAndStatusMsgs();
 var userId = $("#userId").val();
 var paymentAmount = $("#paymentAmount").val();
 var paymentCategoryId = $("#paymentCategoryId").val();
 var paymentDate = $("#paymentDate").val();
 var paymentDescription = $("#paymentDescription").val();

var valid=true;

 if(userId =="" || isNaN(userId) || parseInt(userId)!=userId || parseInt(userId)<=0){
        $('#userId').css('border-color', 'red');
    valid =false;
 }


  if(paymentAmount == "" || isNaN(paymentAmount) || parseFloat(paymentAmount)<=0 || parseFloat(paymentAmount)>=10000000){
   $('#paymentAmount').css('border-color', 'red');
    valid= false;
  }

  if(paymentCategoryId == "" || isNaN(paymentCategoryId) || parseInt(paymentCategoryId)!= paymentCategoryId || parseInt(paymentCategoryId)<=0){
   $('#paymentCategoryId').css('border-color', 'red');
      valid=false;
   }

  if(paymentDate == "" || isFutureDate(paymentDate)){
      $('#errorMsgPaymentDate').text('Invalid or Future Date').css("color","red").css("fontSize", 12);
      $('#paymentDate').css('border-color', 'red');
       valid=false;
  }

  if(paymentDescription.length >200){
    $('#paymentDescription').text('Description too long').css("color","red").css("fontSize", 12);
    $('#paymentDescription').css('border-color', 'red');
    valid=false;
  }


 return valid;

}


function isFutureDate(date){

    var paymentDate = new Date(date);
    var now = new Date();

    if(paymentDate.getFullYear()>now.getFullYear())
        return true;

    if(paymentDate.getMonth()> now.getMonth())
         return true;

    if(paymentDate.getMonth() == now.getMonth() && paymentDate.getDate()> now.getDate())
         return true;
return false;

}

function clearErrorAndStatusMsgs(){

    $('#userId').css('border-color', '');
    $('#paymentAmount').css('border-color', '');
    $('#paymentCategoryId').css('border-color', '');
    $('#paymentDate').css('border-color', '');
    $('#paymentDescription').css('border-color', '');

        $('#errorMsgPaymentDate').text('')
        $('#paymentDescription').text('')


}

});



