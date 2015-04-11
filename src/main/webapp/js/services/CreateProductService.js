(function() {
    'use strict';
    var CreateProductService = function($resource) {
	var product = $resource('http://localhost:8080/stampidia/rest/stampService/:stampId', {
	    stampId:'@stampId'
	}, {
	query : {
	  method : "GET",
	  isArray : false
	}
	});
	return {
	    getProduct : function(stamp) {
		console.log('STAMP '+stamp);
		return product.query({
			stampId : stamp
		});
	    }
	}
    };
    angular.module('stampidia.services').factory('createProductService', [ '$resource', CreateProductService ]);
}());