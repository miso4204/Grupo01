(function() {
    'use strict';
	
	var OrderDetailService = function($resource) {

		return $resource('http://localhost:8080/stampidia/rest/cart/:id/details', {}, {});
	
	};

    angular.module('stampidia.services').factory('orderDetailService',
	    [ '$resource', '$http', OrderDetailService ]);
}());