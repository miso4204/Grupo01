(function() {
    'use strict';
    var ProductDetailsController = function($scope,$window,$routeParams,shirtService, appSettings) {
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
	$scope.getSalesTwitter = function(){	 
	    console.log("id shirt "+$routeParams.shirtId);
	    shirtService.getSales($routeParams.shirtId).$promise.then(
		    function(response){
			var winHeight = 300;
			var winWidth = 520;
			var hashtags = "WeLoveStampidiaShirts";
			var text = "Me gustó esta camiseta... Y tiene " + response.resultado.salesNumber + " ventas!";
			var u = window.location.href;
			var winTop = (screen.height / 2) - (winHeight / 2);
			var winLeft = (screen.width / 2) - (winWidth / 2);
			$scope.sales = response.resultado;
			$window.open('http://twitter.com/share?url=' + escape(u) + '&text=' + text + '&hashtags=' + hashtags, 'sharer', 'top=' + winTop + ',left=' + winLeft + ',toolbar=0,status=0,width=' + winWidth + ',height=' + winHeight);
    			console.log(response);
    		    }, function(response){
			console.log(response);
		    }    
	    );
	}
	$scope.getSalesFacebook = function(){	 
	    console.log("id shirt "+$routeParams.shirtId);
	    shirtService.getSales($routeParams.shirtId).$promise.then(
		    function(response){
			var winHeight = 300;
			var winWidth = 520;
			var title = "Me gustó esta camiseta... Y tiene " + response.resultado.salesNumber + " ventas!";
			var descr = "Me gustó esta camiseta... Y tiene " + response.resultado.salesNumber + " ventas!";
			var u = window.location.href;
			var uri = u.split("#")[0];
			console.log(uri);
			var winTop = (screen.height / 2) - (winHeight / 2);
			var winLeft = (screen.width / 2) - (winWidth / 2);
			$scope.sales = response.resultado;
			$window.open('http://www.facebook.com/sharer.php?s=100&p[title]=' + title + '&p[summary]=' + descr + '&p[url]=' + uri + '&p[images][0]=' + 'http://goo.gl/dS52U', 'sharer', 'top=' + winTop + ',left=' + winLeft + ',toolbar=0,status=0,width=' + winWidth + ',height=' + winHeight);
    			console.log(response);
    		    }, function(response){
			console.log(response);
		    }    
	    );
	}
	$scope.getProduct();
    };
    angular.module('stampidia.controllers').controller('ProductDetailsController', [ '$scope','$window','$routeParams','shirtService','appSettings', ProductDetailsController ]);
}()); 