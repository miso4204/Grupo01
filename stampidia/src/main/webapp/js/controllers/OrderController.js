(function() {
    'use strict';

    var OrderController = function($rootScope, $scope, $location, orderService, sessionService, appSettings) {

	$scope.orderData = {};
	$scope.orderSelectedDetail = {};
	$scope.selectedOrder;

	var res=orderService.get({ id: sessionService.id }).$promise.then(function(response){
	    console.log('OK: '+response);
	    if(response.estado.type=='OK')
	    {
		$scope.orderData=response.resultado;
		console.log($scope.orderData);
	    }else{
		//TODO send error
	    }
	}, function(response) {
	    console.log('Error: ' +response);
	})

	$scope.selectOrder=function(id){
	    console.log(id);
	};

    };




    angular.module('stampidia.controllers').controller('OrderController',
	    [ '$rootScope', '$scope', '$location', 'orderService', 'sessionService', 'appSettings',  OrderController ]);
}());