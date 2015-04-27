(function() {
    'use strict';

    var RegisterController = function($rootScope, $scope, $location, registerService, sessionService, appSettings) {

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
	    console.log(sessionService);
	    
	    $scope.user = registerService.get({ id: sessionService.id }, function() {
		// $scope.entry is fetched from server and is an instance of Entry
		$scope.user.resultado.address = $scope.signupData.address;
		$scope.user.resultado.password = $scope.signupData.password;
		registerService.update($scope.user.resultado);
	    });
	}




    };



    angular.module('stampidia.controllers').controller('RegisterController',
	    [ '$rootScope', '$scope', '$location', 'registerService', 'sessionService', 'appSettings',  RegisterController ]);
}());