(function() {
    'use strict';

    var RegisterService = function($resource) {
		var signup = $resource('http://localhost:8080/stampidia/rest/user/buyer', {}, {});
		return {
			listUsers : function(signupData) {
			    console.log(signupData);
				return  signup.save(signupData);
			}
		}
	};

    angular.module('stampidia.services').factory('registerService',
	    [ '$resource', '$http', RegisterService ]);
}());