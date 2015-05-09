(function() {
    'use strict';

    var CreateProductController = function($rootScope,$scope,$location,$dialogs,$timeout,$routeParams,stampService,shirtService,sizeService,colorService,shirtStyleService,sessionService,appSettings) {
	$scope.animationsEnabled = true;
	
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
			$scope.product = {stamp: ''};
			$scope.product.stamp = response.resultado;
			$scope.createProductForm.$setPristine();
			$scope.launch('wait');
			$scope.error = false;
			$scope.cleanFrom();
		    }, function(response){
			console.log(response);
			$scope.error = true;
			$scope.launch('error');
		    }    
	    );
	    
        }
	$scope.cleanFrom = function() {
	    $scope.product.size = "";
	    $scope.product.color = "";
	    $scope.product.styleShirt = "";
	    $scope.product.text = "";
	    $scope.createProductForm.product_text.$dirty = false;
        }
	$scope.launch = function(which){
	    var dlg = null;
	    switch(which){
	      // Notify Dialog
	      case 'notify':
	        dlg = $dialogs.notify('Something Happened!','Something happened that I need to tell you.');
	        break; 
	        // Error Dialog
	      case 'error':
	        dlg = $dialogs.error('This is my error message','');
	        break;
	      case 'wait':
		dlg = $dialogs.wait(msgs[i++],progress);
		fakeProgress();
		break;
	    }; // end switch
	} // end launch
	var progress = 25;
	  var msgs = [
	    'Hey! I\'m waiting here...',
	    'About half way done...',
	    'Almost there?',
	    'Woo Hoo! I made it!'
	  ];
	  var i = 0;
	  
	  var fakeProgress = function(){
	    $timeout(function(){
	      if(progress < 100){
	        progress += 25;
	        $rootScope.$broadcast('dialogs.wait.progress',{msg: msgs[i++],'progress': progress});
	        fakeProgress();
	      }else{
		  $rootScope.$broadcast('dialogs.wait.complete');
		  $location.url("/");
	      }
	    },1000);
	    
	  }
	var init = function(){
	    console.log(sessionService);
	    $scope.getProduct();
	    $scope.listSizes();
	    $scope.listColors();
	    $scope.listShirtStyles();
	}
	init();
    };
    angular.module('stampidia.controllers').controller('CreateProductController', ['$rootScope', '$scope','$location','$dialogs','$timeout','$routeParams','stampService','shirtService','sizeService','colorService','shirtStyleService','sessionService','appSettings', CreateProductController ]);

}());
