(function() {
    'use strict';

    var RateProductService = function($resource) {

		return $resource('http://localhost:8080/stampidia/rest/product/rate', {}, {
		    
		    update: {
			      method: 'PUT' // this method issues a PUT request
			    }
		    
		});
	
	};

    angular.module('stampidia.services').factory('rateProductService',
	    [ '$resource', '$http', RateProductService ]);
}());