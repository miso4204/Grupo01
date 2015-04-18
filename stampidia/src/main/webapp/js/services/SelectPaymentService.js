(function() {
	'use strict';
	var SelectPaymentService = function($resource,$http) {

		var stampidia = $resource('http://localhost:8080/stampidia/rest/pay/methods',{},{
		    list:{
			method:'GET'
		    }
		});
		
		return {
		    listPaymentTypes : function(){
			return stampidia.list();
		    }
		}
	};
	angular.module('stampidia.services').factory('selectPaymentService',['$resource', '$http', SelectPaymentService]);
}());