(function() {
    'use strict';

    var OrderService = function($resource) {
	
		return $resource('http://localhost:8080/stampidia/rest/order/:id', {}, {
		    update: {
			      method: 'PUT' // this method issues a PUT request
			    }
		});
	
	};

    angular.module('stampidia.services').factory('orderService',
	    [ '$resource', '$http', OrderService ]);
}());