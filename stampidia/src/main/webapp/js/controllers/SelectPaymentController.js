(function() {
    'use strict';

    var SelectPaymentController = function($scope, selectPaymentService, appSettings) {
	
    selectPaymentService.listPaymentTypes().$promise.then(function(response){
	    console.log(response);
	    $scope.paymentTypes=response.resultado;
	    console.log($scope.paymentTypes);
	},function(response){
	    console.log('bad' + response);
	})
    };

    angular.module('stampidia.controllers').controller('SelectPaymentController',
	    [ '$scope', 'selectPaymentService', 'appSettings', SelectPaymentController ]);
}());


