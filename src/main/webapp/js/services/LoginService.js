(function() {
    'use strict';

    var LoginService = function($resource, $http) {
	var calculateBtoa = function(credentials) {
	    console.log(credentials);
	    return "Basic "
		    + btoa(credentials['username'] + ":"
			    + credentials['password']);
	};

	var stampidiaEndpoint = 'http://localhost:8080/stampidia';

	var loginService = {
	    login : function(data) {
		var heads = {
		    'X-Requested-With' : 'XMLHttpRequest',
		    'Content-Type' : 'application/x-www-form-urlencoded',
		    'Authorization' : calculateBtoa(data)
		};
		var promise = $http.get(stampidiaEndpoint + '/rest/loggedUser', {
		    headers : heads
		}, data).then(function(response) {
		    console.log(response);
		    return response.data;
		});
		return promise;
	    }
	};

	return loginService;
    };

    angular.module('stampidia.services').factory('loginService',
	    [ '$resource', '$http', LoginService ]);
}());