(function() {
    'use strict';

    var SelectPaymentController = function($scope, $location, selectPaymentService, appSettings) {
	
    selectPaymentService.listPaymentTypes().$promise.then(function(response){
	    console.log(response);
	    $scope.paymentTypes=response.resultado;
	    console.log($scope.paymentTypes);
	},function(response){
	    console.log('bad' + response);
	});
    $scope.changeRoute = function(url, forceReload) {
        $scope = $scope || angular.element(document).scope();
        if(forceReload || $scope.$$phase) { // that's right TWO dollar signs: $$phase
            window.location = url;
        } else {
            $location.path(url);
            $scope.$apply();
        }
    };
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
    	    $scope.changeRoute('#/' + response.mensajeAccion);
    	    console.log($location);
    	},function(response){
    	    console.log('bad' + response);
    	})
    };
    }
    
    
    angular.module('stampidia.controllers').controller('SelectPaymentController',
	    [ '$scope', '$location', 'selectPaymentService', 'appSettings', SelectPaymentController ]);
}());


