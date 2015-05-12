(function() {
    'use strict';

    var ProductsController = function($rootScope, $scope, $cookieStore, productsService, categoriesService, offerService, sessionService, cartService, appSettings) {
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

    $scope.addItemToCart = function(item) {
        console.log('Entra en CartController');
        var detail;
        if ($rootScope.order != null) {
        } else {
            $rootScope.order = {};
            $rootScope.order.stmpOrderDetailList = [];
        }
        console.log('ITEM =>' +  item.id);

        var detList = $rootScope.order.stmpOrderDetailList.filter(function(element){
            return element.idShirt.id === item.id;
        });

        console.log('LIST SIZE =>' +  detList);
        if( detList.length > 0){
            detail =  detList[0];
            detail.quantity = detail.quantity + 1;
        }else{
            detail = {
                quantity : 1,
                unitValue : item.idStyle.price + item.idStamp.price,
                idShirt : item
            };
            $rootScope.order.stmpOrderDetailList.push(detail);
            $cookieStore.put('order',$rootScope.order);
        }
        console.log('RESULT ORDER =>' + $rootScope.order.stmpOrderDetailList.length);
		var itemCount = 0;
		for(var i = 0 ; i < $rootScope.order.stmpOrderDetailList.length;i++){
			itemCount = itemCount + $rootScope.order.stmpOrderDetailList[i].quantity;
		}
		$rootScope.itemCount = itemCount;

    }

	$scope.loadViewMore = function(ShirtId){
	    console.log("loadViewMore" + ShirtId);
	}
	$scope.modeView = function(mode){
	    $("#list-products .icons-mode-view a").removeClass("active");
	    if(mode=="list"){
		$("#list-products .icons-mode-view .glyphicon-th-list").addClass("active");
		$('#list-products .features_items').hide();
		$('#list-products .features_list').show();
	    }else{
		$("#list-products .icons-mode-view .glyphicon-th").addClass("active");
		$('#list-products .features_list').hide();
		$('#list-products .features_items').show();
	    }
	}

    function getDetailByShirtId(element, shirtId){
        return element.idShirt.id === shirtId;
    }
    /*
    $scope.getSpecialOffer = function(){
        console.log("Entra a getSpecialOffer");
        offerService.getOffer().$promise.then(
            function(response){
                console.log('Special Offer: ' + response);
                $rootScope.specialOffer = response.resultado;
            }, function(response){
                console.log(response);
                $scope.error = true;
                $scope.launch('error');
            }
        );
    }
    $scope.getSpecialOffer();*/

	var init = function(){
	    console.log("init");
	    $('#list-products .features_list').hide();
	    $scope.listCategories();
	    $scope.listProducts();
	    /*
	     if (Modernizr.canvas) {
		  // Browser supports native HTML5 canvas.
		 console.log("Browser supports native HTML5 canvas");
	    } else {
		  // Fallback to another solution, such as Flash, static image, download link, and so on.
		 console.log(" // Fallback to another solution, such as Flash, static image, download link, and so on");
	    }
	    */
	}
	init();

    };
    angular.module('stampidia.controllers').controller('ProductsController', [ '$rootScope','$scope', '$cookieStore', 'productsService', 'categoriesService', 'offerService', 'sessionService','cartService', 'appSettings', ProductsController ]);

}());
