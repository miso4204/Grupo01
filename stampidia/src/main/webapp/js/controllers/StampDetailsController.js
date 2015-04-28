(function() {
    'use strict';
    var StampDetailsController = function($scope,$routeParams,stampService, appSettings) {
	console.log("id stamp ");
	$scope.getStamp = function(){	 
	    console.log("id stamp "+$routeParams.stampId);
	    stampService.getStamp($routeParams.stampId).$promise.then(
		    function(response){
			$scope.stamp = response.resultado;
		    }, function(response){
			console.log(response);
		    }    
	    );
	}
	$scope.getStamp();
    };
    angular.module('stampidia.controllers').controller('StampDetailsController', [ '$scope','$routeParams','stampService','appSettings', StampDetailsController ]);
}()); 