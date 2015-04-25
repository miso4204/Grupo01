(function() {
	'use strict';
	var HomeService = function($resource,$http) {

		var stampidia = $resource('http://localhost:8080/stampidia/rest/sizeServiceBuyer',{},{
		    list:{
			method:'GET'
		    }
		});

//		var heads = {
//		    'X-Requested-With':'XMLHttpRequest',
//		    'Content-Type':'application/x-www-form-urlencoded',
//		    'Authorization':'Basic dXNlcjpwYXNzd29yZA=='
//		}
		return {
		    listSizes : function(){
//			return $http.get(stampidia/*,{headers:heads}*/);
			return stampidia.list();
            }
		}
	};
	angular.module('stampidia.services').factory('homeService',['$resource', '$http',HomeService]);
}());