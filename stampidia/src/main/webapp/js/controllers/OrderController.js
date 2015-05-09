(function() {
    'use strict';

    var OrderController = function($rootScope, $scope, $location, orderService, orderDetailService, sessionService, appSettings) {

	$scope.orderData = {};

	var res=orderService.get({ id: sessionService.id }).$promise.then(function(response){

	    //console.log('OK: '+response);
	    if(response.estado.type=='OK')
	    {
		$scope.orderData=response.resultado;
		//console.log($scope.orderData);
	    }else{
		//TODO send error
	    }
	}, function(response) {
	    console.log('Error: ' +response);
	})

	$scope.selectOrder=function(id){
	    $rootScope.selectedOrder=id;
	    $location.url('order-details');
	}
    };


    angular.module('stampidia.controllers').controller('OrderController',
	    [ '$rootScope', '$scope', '$location', 'orderService', 'orderDetailService','sessionService', 'appSettings',  OrderController ]);
}());