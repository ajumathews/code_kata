    var app=angular.module("propertyControllerApp",["pascalprecht.translate"]);

    app.config(function ($translateProvider) {
        $translateProvider.translations('US_EN', {
        'name.label': 'Name',
        'age.label': 'Age'
        });   

    
    //It sets default language for your app
    $translateProvider.preferredLanguage('US_EN');
    });

    app.controller('propertyController', function($scope){


        $scope.indian=function(){
            $scope.message="Indian";
        }

        $scope.chineese=function(){
            $scope.message="Chineese";
        }
    
    

        $scope.showHelp= function (e,id) {
            var sHelp = null;
            if(id == 'filterCompanyPrincipalHelp'){
                sHelp = 'hello Principal';
            }
            else if(id == 'filterCompanyPartnerHelp'){
                sHelp = 'hello Partner';
            }
            
            if (sHelp != null) {
                //console.log('sHelp is not null');
                //console.log(sHelp);
                alert(sHelp);
                //TRLSC.InfoWindow.show(e, 'Help', $(sHelp).html(), {'position': 'absolute'});
            }
        }

    });

