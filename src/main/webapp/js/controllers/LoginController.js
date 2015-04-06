(function() {
    'use strict';

    var LoginController = function($rootScope, $scope, $location, loginService, appSettings) {
	
	$scope.credentials = {};
	$scope.login = function(){
	    loginService.login($scope.credentials).then(
	    function(response){
		$scope.error = false;
	    },function(response){
		$scope.error = true;
		$scope.mensaje = 'Este usuario y/o contraseña no es válido!';
	    });
	};

    };

    angular.module('stampidia.controllers').controller('LoginController',
	    [ '$rootScope', '$scope', '$location', 'loginService', 'appSettings', LoginController ]);
}());