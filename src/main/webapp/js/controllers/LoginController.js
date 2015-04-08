/**
 * @ngdoc controller
 * @name stampidia.LoginController
 * @description # LoginController Controlador encargado del login/logout
 */
(function() {
    'use strict';

    /**
     * Controlador encargado de controlar el acceso a la aplicacion y mantener el estado de la sesión
     */
    var LoginController = function($rootScope, $scope, $location, loginService, sessionService, appSettings) {

	$scope.login = function() {
	    loginService.login($scope.credentials).then(function(response) {
		var resp = response.resultado
		sessionService.create(resp.username, 'asdasdasdasdasd', 'ROLE_BUYER');
		$scope.error = false;		
		$location.url("/");
	    }, function(response) {
		$scope.error = true;
		$scope.mensaje = 'Este usuario y/o contraseña no es válido!';
	    });
	};
	
	/**
	 * Variable para definir si el usuario está logeado
	 */
	$scope.isAuthenticated = function() {
	    return !!sessionService.authId;
	}

    };

    angular.module('stampidia.controllers').controller('LoginController', [ '$rootScope', '$scope', '$location', 'loginService', 'sessionService', 'appSettings', LoginController ]);
}());