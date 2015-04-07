(function() {
    'use strict';

    var SelectPaymentController = function($scope, selectPaymentService, appSettings) {
	
    selectPaymentService.listPaymentTypes().$promise.then(function(response){
	    console.log(response);
	    $scope.paymentTypes=response.resultado;
	    console.log($scope.paymentTypes);
	},function(response){
	    console.log('bad' + response);
	});
	$scope.submit = function(){
		var paymentMethod;
		if ($scope.paymenttype == 1){
			paymentMethod = "cash"
		} else if ($scope.paymenttype == 2){
			paymentMethod = "pse"
		} else if ($scope.paymenttype == 3){
			paymentMethod = "credit"
		}
    	selectPaymentService.pay(paymentMethod, 6).$promise.then(function(response){
    	    console.log(response);
    	},function(response){
    	    console.log('bad' + response);
    	})
    };
    }
    
    
    angular.module('stampidia.controllers').controller('SelectPaymentController',
	    [ '$scope', 'selectPaymentService', 'appSettings', SelectPaymentController ]);
}());


