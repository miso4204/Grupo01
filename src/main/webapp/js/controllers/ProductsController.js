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

    $scope.addItemToCart = function(item) {
        console.log('Entra en CartController');
        var detail;

        if ($scope.order) {
        } else {
            $scope.order = {};
            $scope.order.stmpOrderDetailList = [];
        }

        console.log('ITEM =>' +  item.id);

        var detList = $scope.order.stmpOrderDetailList.filter(function(element){
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
            $scope.order.stmpOrderDetailList.push(detail);
        }
        console.log('RESULT ORDER =>' + $scope.order.stmpOrderDetailList.length);

    }

    function getDetailByShirtId(element, shirtId){
        return element.idShirt.id === shirtId;
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
