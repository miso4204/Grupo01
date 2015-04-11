(function() {
    'use strict';

    var ProductsController = function($scope, productsService, categoriesService, appSettings) {
	$scope.products = productsService.listProducts();
	$scope.categories = categoriesService.listCategories();
	console.log($scope.products);
    };
    angular.module('stampidia.controllers').controller('ProductsController', [ '$scope', 'productsService', 'categoriesService', 'appSettings', ProductsController ]);

}());
