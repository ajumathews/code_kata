var MultilingualApp = angular.module("MultilingualApp", ["pascalprecht.translate"]);
 
MultilingualApp.config(function ($translateProvider) {
  $translateProvider.translations("US_EN", {
    "GREETING": "Hello !",
    "DESCRIPTION": "This is a demo app for multilingual support.",
    "LBL_SWITCH": "Click here for switching language between spanish to english",
    "CLICK": "Click"
  });
  $translateProvider.translations("SPANISH", {
    "GREETING": "Hola !",
    "DESCRIPTION": "Esta es una aplicacion de demostracion para soporte multilingue",
    "LBL_SWITCH": "Haga clic aquí para cambiar el idioma entre espanol al Ingles",
    "CLICK": "Click"
  });
  $translateProvider.preferredLanguage("US_EN");
});
 
MultilingualApp.controller("MyCtrl", function ($scope, $translate) {
  $scope.changeLanguage = function () {
    var language = $translate.use();
    if (language === "US_EN") {
      $translate.use("SPANISH");
    } else {
      $translate.use("US_EN");
    }
  };
});