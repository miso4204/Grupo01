(function() {
    'use strict';

    var RateDesignService = function($resource) {

		return $resource('http://localhost:8080/stampidia/rest/design/rate', {}, {
		    
		    update: {
			      method: 'PUT' // this method issues a PUT request
			    }
		    
		});
	
	};

    angular.module('stampidia.services').factory('rateDesignService',
	    [ '$resource', '$http', RateDesignService ]);
}());