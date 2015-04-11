(function() {
    'use strict';
    var ProductsService = function($resource) {
	var products = $resource('http://localhost:8080/stampidia/rest/shirtService', {
	    categoryId : '@categoryId'
	}, {
	query : {
	method : "GET",
	isArray : false
	},
	listByCategory : {
	method : "GET",
	isArray : false
	}
	});
	return {
	    listProducts : function(category) {
		if (category) {
		    console.log('CATEGORY '+category);
		    return products.listByCategory({
			categoryId : category
		    });
		} else {
		    return products.query();
		}

	    }
	}
    };
    angular.module('stampidia.services').factory('productsService', [ '$resource', ProductsService ]);
}());