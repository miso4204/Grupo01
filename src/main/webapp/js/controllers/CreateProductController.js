(function() {
    'use strict';

    var CreateProductController = function($scope,$routeParams,stampService,shirtService,sizeService,colorService,shirtStyleService,appSettings) {
	$scope.getProduct = function(){	    
	    stampService.getStamp($routeParams.stampId).$promise.then(
		    function(response){
			$scope.product = {stamp: ''};
			$scope.product.stamp = response.resultado;
		    }, function(response){
			console.log(response);
		    }    
	    );
	}
	$scope.listSizes = function(){	    
	    sizeService.listSizes().$promise.then(
		    function(response){
			$scope.sizes = response.resultado;
		    }, function(response){
			console.log(response);
		    }    
	    );
	}
	$scope.listColors = function(){	    
	    colorService.listColors().$promise.then(
		    function(response){
			$scope.colorsShirt = response.resultado;
		    }, function(response){
			console.log(response);
		    }
		    
	    );
	}
	$scope.listShirtStyles = function(){	    
	    shirtStyleService.listShirtStyles().$promise.then(
		    function(response){
			$scope.shirtStyles = response.resultado;
		    }, function(response){
			console.log(response);
		    }    
	    );
	}
	
	$scope.createProduct = function() {
	    console.log($scope.product);
	    shirtService.createShirt($scope.product.text,$scope.product.color.id,$scope.product.styleShirt.id,$scope.product.size.id, $scope.product.stamp.id,1).$promise.then(
		    function(response){
			console.log('Create Camiseta');
			$scope.product = {stamp: ''};
			$scope.product.stamp = response.resultado;
		    }, function(response){
			console.log(response);
		    }    
	    );
	    
        }
	var init = function(){
	    $scope.getProduct();
	    $scope.listSizes();
	    $scope.listColors();
	    $scope.listShirtStyles();
	}
	init();
    };
    angular.module('stampidia.controllers').controller('CreateProductController', [ '$scope' ,'$routeParams','stampService','shirtService','sizeService','colorService','shirtStyleService','appSettings', CreateProductController ]);

}());
