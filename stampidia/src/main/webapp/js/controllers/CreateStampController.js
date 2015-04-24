(function() {
    'use strict';
    var CreateStampController = function($scope,stampService,categoriesService,appSettings) {
	
	$scope.createStamp= function() {
	    stampService.createStamp($scope.stamp.name,$scope.stamp.description,
		    $scope.stamp.image,$scope.stamp.tags,1,$scope.stamp.salesNumber,1,$scope.stamp.price,true).$promise.then(
		    function(response){
			$scope.stamps = response.resultado;
			$scope.createStampForm.$setPristine();
		    }, function(response){
			console.log(response);
		    }    
	    );
        }
	$scope.listCategories = function(){	    
	    categoriesService.listCategories().$promise.then(
		    function(response){
			$scope.categories = response.resultado;
		    }, function(response){
			console.log(response);
		    }
		    
	    );
	}
	$scope.cleanFrom = function() {
	    $scope.stamp.name = "";
		$scope.stamp.description = "";
		$scope.stamp.image = "";
		$scope.stamp.tags = "";
		$scope.stamp.category = "";
		$scope.stamp.salesNumber = "";
		$scope.stamp.price = "";
	}	
	var init = function(){
	    $scope.listCategories();
	}
	init();
    };
    angular.module('stampidia.controllers').controller('CreateStampController', [ '$scope','stampService','categoriesService','appSettings', CreateStampController ]);

}());
