(function() {
    'use strict';

    var RateProductService = function($resource) {

		return $resource('http://localhost:8080/stampidia/rest/product/rate', {}, {});
	
	};

    angular.module('stampidia.services').factory('rateProductService',
	    [ '$resource', '$http', RateProductService ]);
}());