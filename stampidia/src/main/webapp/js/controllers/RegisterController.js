(function() {
    'use strict';

    var RegisterController = function($rootScope, $scope, $location, registerService, appSettings) {

	$scope.signupData = {};
	$scope.signup = function(){
	    var res=registerService.save($scope.signupData).$promise.then(function(response){
		console.log('OK: '+response);
		if(response.estado.type=='OK')
		{
		    $location.url("/login");
		}else{
		    //TODO send error
		}
	    }, function(response) {
		console.log('Error: ' +response);
	    })
	};

	$scope.editAccount=function(){
	    console.log($scope.idUserIn);
	    $scope.user = registerService.get({ id: 1 }, function() {
		// $scope.entry is fetched from server and is an instance of Entry
		$scope.user.resultado.address = 'something else';
		registerService.update($scope.user.resultado);
	    });
	}




    };



    angular.module('stampidia.controllers').controller('RegisterController',
	    [ '$rootScope', '$scope', '$location', 'registerService', 'appSettings', RegisterController ]);
}());