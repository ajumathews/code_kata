var app = angular.module("directiveApp",[]);
app.directive("testdirective", function(){
    return {
        template: "My Test Directive"
    };

});