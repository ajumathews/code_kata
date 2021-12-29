$(document).ready(function(){

    $("#b1").click(function(){
        $("p").hide();
    });


    $("#click").click(function(){
        $(this).hide();
        }
    );


  $("#mouseenter").mouseenter(function(){
      $(this).css("color","red");
    }
  );


  $("#mouseenter").mouseleave(function(){
      $(this).css("color","black");
    }
  );


  $("#hover").hover(function(){
        $(this).css("background-color", "red");
    }
  ,function(){
        $(this).css("background-color", "white");
    }
  );



    $("#on").on({

            click:function(){
                $(this).css("color","blue");

            },

            mouseenter : function(){
                 $(this).css("background-color","red");
            },

            mouseleave : function(){
                 $(this).css("background-color","white");
            }
        }
    );


    $("#show").click(function(){
        $("#p1").show();
        }
    );


    $("#hide").click(function(){
            $("#p1").hide();
        }
    );


    $("#showSlow").click(function(){
        $("#p2").show(1000);
        }
    );


    $("#hideSlow").click(function(){
            $("#p2").hide(1000);
        }
    );

    $("#toggle").click(function(){
            $("#p3").toggle(1000);
        }
    );

    $("#fadeToggle").click(function(){
                $("#p4").fadeToggle(1000);
            }
        );


    $("#slideToggle").click(function(){
            $("#p5").slideToggle();
        }
    );



    $("#moveRight").click(function(){
               $("#p6").animate({left: '250px'});
        }
    );


});