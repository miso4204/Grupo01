(function() {
	'use strict';
	var SizeService = function($resource) {
		var sizes = $resource('http://localhost:8080/stampidia/rest/sizeServiceBuyer', {}, {
			query: { method: "GET",
				isArray: false}
			});
		return {
			listSizes : function() {
				return  sizes.query();
			}
		}
	};
	angular.module('stampidia.services').factory('sizeService',['$resource',SizeService]);
}());