var app=angular.module("clickApp",[]);

app.controller("clickController",function($scope){
    $scope.message="very";

    $scope.indian=function(){
        $scope.message="Indian";
    }

    $scope.chineese=function(){
        $scope.message="Chineese";
    }

});