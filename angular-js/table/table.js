var app = angular.module("tableApp", []).controller("tableController", function ($scope) {
    $scope.message = "My Table";

    $scope.empTable = {
        "companyName": "clarivate",
        "employees": [{
                "name": "aju",
                "age": "31"
            },
            {
                "name": "babu",
                "age": "30"
            },
        ]
    };
  
    
});