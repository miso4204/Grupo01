(function() {
    'use strict';

    var CreateProductController = function($scope,$routeParams, createProductService, appSettings) {
	$scope.product = createProductService.getProduct($routeParams.stampId);
	console.log($scope.product);
    };
    angular.module('stampidia.controllers').controller('CreateProductController', [ '$scope' ,'$routeParams', 'createProductService', 'appSettings', CreateProductController ]);

}());
