(function() {
    'use strict';

    var LoginController = function($rootScope, $scope, $location, loginService, appSettings) {
	
	$scope.credentials = {};
	$scope.login = function(){
	    loginService.login($scope.credentials).then(
	    function(response){
		console.log(response.data);
	    });
	};

    };

    angular.module('stampidia.controllers').controller('LoginController',
	    [ '$rootScope', '$scope', '$location', 'loginService', 'appSettings', LoginController ]);
}());