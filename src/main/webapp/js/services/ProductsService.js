(function() {
    'use strict';
    var ProductsService = function($resource) {
	var products = $resource('http://localhost:8080/stampidia/rest/shirtService', {
	    categoryId : '@categoryId',
	    stampId : '@stampId'
	}, {
	query : {
	   method : "GET",
	   isArray : false
	},
	listByCategory : {
	    method : "GET",
	    isArray : false
	},
	listByStamp : {
	    method : "GET",
	    isArray : false
	   }
	});
	return {
	    listProducts : function(category,stamp) {
		if (category != null  &&  stamp != null ){
		}else if(category != null ){
		    console.log('CATEGORY '+category);
		    return products.listByCategory({
			categoryId : category
		    });
		}else if (stamp != null ){
		    console.log('STAMP '+stamp);
		    return products.listByStamp({
			stampId : stamp
		    });
		}else{
		    return products.query();
		}
	    }
	}
    };
    angular.module('stampidia.services').factory('productsService', [ '$resource', ProductsService ]);
}());