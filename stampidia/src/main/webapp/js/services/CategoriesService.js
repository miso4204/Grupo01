(function() {
	'use strict';
	var CategoriesService = function($resource) {
		var categories = $resource('http://localhost:8080/stampidia/rest/categoryService', {}, {
			query: { method: "GET",
				isArray: false}
			});
		return {
			listCategories : function() {
				return  categories.query();
			}
		}
	};
	angular.module('stampidia.services').factory('categoriesService',['$resource',CategoriesService]);
}());