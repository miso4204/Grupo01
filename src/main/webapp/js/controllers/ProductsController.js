(function() {
    'use strict';

    var ProductsController = function($scope, productsService, categoriesService, appSettings) {
	$scope.listProducts = function(id){	    
	    productsService.listProducts(id).$promise.then(
		    function(response){
			$scope.products = response.resultado;		    
		    }, function(response){
			console.log(response);
		    }    
	    );
	}
	$scope.listCategories = function(){
	    categoriesService.listCategories().$promise.then(		
		    function(response){
			$scope.categories= response.resultado;
		    },
		    function(response){
			console.log(response)
		    })
	}
	
	$scope.selectCategory = function(productId){
	    $scope.listProducts(productId);
	}
	
	var init = function(){
	    console.log("init");
	    $scope.listCategories();
	    $scope.listProducts();
	}
	init();
	
    };
    angular.module('stampidia.controllers').controller('ProductsController', [ '$scope', 'productsService', 'categoriesService', 'appSettings', ProductsController ]);

}());
