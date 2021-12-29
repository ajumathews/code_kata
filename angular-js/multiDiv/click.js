var app=angular.module("clickApp",[]);

app.controller("clickController",function($scope){
    
    $scope.indian=function(){
        $scope.message1 ="indian";	
		$scope.$apply();
    }
  

});