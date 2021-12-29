angular.module('myHttp',[]).controller('httpController',function($scope,$http){
    $http.get("data.txt")
    .then(function(response) {
        $scope.message = response.data;
    },function(){
        $scope.message = "error";
    });
});
