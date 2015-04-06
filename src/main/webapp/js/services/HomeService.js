(function() {
	'use strict';
	var HomeService = function($resource,$http) {

		var stampidia = 'http://localhost:8080/stampidia/rest/sizeServiceBuyer';

		var heads = {
		    'X-Requested-With':'XMLHttpRequest',
		    'Content-Type':'application/x-www-form-urlencoded',
		    'Authorization':'Basic dXNlcjpwYXNzd29yZA=='
		}
		return {
		    listSizes : function(){
			return $http.get(stampidia,{headers:heads});				
		    }
		}
	};
	angular.module('stampidia.services').factory('homeService',['$resource', '$http',HomeService]);
}());