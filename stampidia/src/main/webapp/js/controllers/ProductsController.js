(function() {
    'use strict';

    var ProductsController = function($rootScope, $scope, productsService, categoriesService, cartService, appSettings) {
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
        }
        console.log('RESULT ORDER =>' + $rootScope.order.stmpOrderDetailList.length);
        cartService.saveOrder($rootScope.order);

    }

	$scope.loadViewMore = function(ShirtId){
	    console.log("loadViewMore" + ShirtId);
	}
	$scope.modeView = function(mode){
	    if(mode=="list"){
		$('#list-products .features_items').hide();
		$('#list-products .features_list').show();
	    }else{
		$('#list-products .features_list').hide();
		$('#list-products .features_items').show();
	    }
	}

    function getDetailByShirtId(element, shirtId){
        return element.idShirt.id === shirtId;
    }

	var init = function(){
	    console.log("init");
	    $('#list-products .features_list').hide();
	    $scope.listCategories();
	    $scope.listProducts();
	}
	init();

    };
    angular.module('stampidia.controllers').controller('ProductsController', [ '$rootScope','$scope', 'productsService', 'categoriesService','cartService', 'appSettings', ProductsController ]);

}());
