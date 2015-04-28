(function() {
    'use strict';

    var OrderController = function($rootScope, $scope, $location, orderService, sessionService, appSettings) {

	$scope.orderData = {};

	var res=orderService.get({ id: sessionService.id }).$promise.then(function(response){
		console.log('OK: '+response);
		if(response.estado.type=='OK')
		{
		    $scope.orderData=response.resultado;
		    console.log('orden -> ' + $scope.orderData);
		    console.log($scope.orderData.length);
		}else{
		    //TODO send error
		}
	    }, function(response) {
		console.log('Error: ' +response);
	    })

	};

    angular.module('stampidia.controllers').controller('OrderController',
	    [ '$rootScope', '$scope', '$location', 'orderService', 'sessionService', 'appSettings',  OrderController ]);
}());