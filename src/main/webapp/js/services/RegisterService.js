(function() {
    'use strict';

    var RegisterService = function($resource) {
		var signup = $resource('http://localhost:8080/stampidia/rest/user/buyer', {username:'@username', 
			password:'@password', email:'@email', facebook_email:'@facebook_email', twitter_email:'@twitter_email',
			is_seller:'@is_seller', status:'@status'}, {
			query: { method: "POST",
				isArray: false}
			});
		return {
			listUsers : function(signupData) {
				return  signup.query(signupData);
			}
		}
	};

    angular.module('stampidia.services').factory('registerService',
	    [ '$resource', '$http', RegisterService ]);
}());