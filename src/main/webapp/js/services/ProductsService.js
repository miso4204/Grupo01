(function() {
	'use strict';
	var ProductsService = function($resource) {
		var products = $resource('http://localhost:8080/stampidia/rest/shirtService', {}, {
			query: { method: "GET",
				isArray: false}
			});
		return {
			listProducts : function() {
				return  products.query();
			}
		}
	};
	angular.module('stampidia.services').factory('productsService',['$resource',ProductsService]);
}());