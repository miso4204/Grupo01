(function() {
	'use strict';
	var ShirtStyleService = function($resource) {
		var styles = $resource('http://localhost:8080/stampidia/rest/shirtStyleService', {}, {
			query: { method: "GET",
				isArray: false}
			});
		return {
		    listShirtStyles : function() {
				return  styles.query();
			}
		}
	};
	angular.module('stampidia.services').factory('shirtStyleService',['$resource',ShirtStyleService]);
}());

