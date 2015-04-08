(function() {
	'use strict';

	var LoginController = function($rootScope, $scope, $location, loginService,
			sessionService, appSettings) {

		$scope.credentials = {};
		$scope.login = function() {
			loginService.login($scope.credentials).then(function(response) {
				$scope.error = false;
				sessionService.create('user', 'asdasdasdasdasd', 'ROLE_BUYER');
				$location.url("/");
			}, function(response) {
				$scope.error = true;
				$scope.mensaje = 'Este usuario y/o contraseña no es válido!';
			});
		};

	};

	angular.module('stampidia.controllers').controller(
			'LoginController',
			[ '$rootScope', '$scope', '$location', 'loginService',
					'sessionService', 'appSettings', LoginController ]);
}());