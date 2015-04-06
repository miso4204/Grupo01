(function() {
	'use strict';
	
	var ProductsController = function($scope, productsService,appSettings) {
		$scope.products = productsService.listProducts();
		console.log($scope.products);
	};
	angular.module('stampidia.controllers').controller('ProductsController',
														['$scope', 
														 'productsService',
														 'appSettings',ProductsController]);
}());


