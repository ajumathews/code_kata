$(document).ready(function(){

    $("#login").submit(function(){
        clearErrorAndStatusMsgs();
       return validateLoginForm();
     }
    );
});

    function validateLoginForm(){

    var emailAddress=$("#emailAddress").val();
    var password =$("#password").val();

    var valid = true;

    if(emailAddress == ""){
        $("#emailAddress").css('border-color','red');
        valid = false;
    }
    if(!validateEmail(emailAddress)){
        $("#emailAddress").css('border-color','red');
        valid = false;
    }
    if(password == ""){
        $("#password").css('border-color','red');
        valid = false;
    }
    if(password.length>20){
        $("#password").css('border-color','red');
        valid = false;
    }

    return valid;
    }


function validateEmail(email)
{
    var re = /\S+@\S+/;
    return re.test(email);
}

function clearErrorAndStatusMsgs(){
 $("#emailAddress").css('border-color','');
  $("#password").css('border-color','');

}