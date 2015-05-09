(function() {
    'use strict';

    var OrderDetailController = function($rootScope, $scope, $location, orderService, orderDetailService, sessionService, appSettings) {

	$scope.selectedOrderDetail={};



	    var res= orderDetailService.get({ id: $rootScope.selectedOrder }).$promise.then(function(response){

		if(response.estado.type=='OK')
		{
		    $scope.selectedOrderDetail=response.resultado;
		}else{
		    //TODO send error
		}

	    }, function(response) {
		console.log('Error: ' +response);
	    })
	

    };


    angular.module('stampidia.controllers').controller('OrderDetailController',
	    [ '$rootScope', '$scope', '$location', 'orderService', 'orderDetailService','sessionService', 'appSettings',  OrderDetailController ]);
}());