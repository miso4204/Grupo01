(function() {
    'use strict';

    var RegisterService = function($resource) {
//		var signup = $resource('http://localhost:8080/stampidia/rest/user/buyer', {}, {});
//		return {
//			addUser : function(signupData) {
//				return  signup.save(signupData);
//			}
//		}
		return $resource('http://localhost:8080/stampidia/rest/user/buyer', {}, {
		    update: {
			      method: 'PUT' // this method issues a PUT request
			    }
		});
	
	};

    angular.module('stampidia.services').factory('registerService',
	    [ '$resource', '$http', RegisterService ]);
}());