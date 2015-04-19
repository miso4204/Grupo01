(function() {
    'use strict';

    angular.module('stampidia.services').factory('httpInterceptor', function($q, $window, $location) {
	return {

	'request' : function(config) {
	    return config;
	},
	// optional method
	'requestError' : function(rejection) {
	    // do something on error
	    if (canRecover(rejection)) {
		return responseOrNewPromise
	    }
	    return $q.reject(rejection);
	},

	// optional method
	'response' : function(response) {
	    // do something on success
	    return response;
	},

	// optional method
	'responseError' : function(rejection) {
	    // do something on error
	    if (rejection.status === 401) {
		$location.url('/login');
	    }
	    return $q.reject(rejection);
	}

	};
    })
}());