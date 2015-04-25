(function() {
	'use strict';
	var ColorService = function($resource) {
		var colors = $resource('http://localhost:8080/stampidia/rest/colorService', {}, {
			query: { method: "GET",
				isArray: false}
			});
		return {
			listColors : function() {
				return  colors.query();
			}
		}
	};
	angular.module('stampidia.services').factory('colorService',['$resource',ColorService]);
}());