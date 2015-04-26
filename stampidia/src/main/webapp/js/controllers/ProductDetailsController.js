(function() {
    'use strict';
    var ProductDetailsController = function($scope,$routeParams,shirtService, appSettings) {
	$scope.getProduct = function(){	 
	    console.log("id shirt "+$routeParams.shirtId);
	    shirtService.getShirt($routeParams.shirtId).$promise.then(
		    function(response){
			$scope.product = response.resultado;
		    }, function(response){
			console.log(response);
		    }    
	    );
	}
	$scope.getProduct();
    };
    angular.module('stampidia.controllers').controller('ProductDetailsController', [ '$scope','$routeParams','shirtService','appSettings', ProductDetailsController ]);
}()); 