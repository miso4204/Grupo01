(function() {
	'use strict';
	var SelectPaymentService = function($resource,$http) {

		var stampidia = $resource('http://localhost:8080/stampidia/rest/pay/methods',{},{
		    list:{
			method:'GET'
		    }
		});
		
		var paymentServices = $resource('http://localhost:8080/stampidia/rest/pay/:method/:orderId',{
			method:'@method',orderId:'@orderId'
		},{
		    pay:{
			method:'POST'
		    }
		});
		
		return {
		    listPaymentTypes : function(){
		    	return stampidia.list();
		    }, 
		    pay : function(type, orderId){
		    	return paymentServices.pay({method:type, orderId:orderId});
		    }
		}
	};
	angular.module('stampidia.services').factory('selectPaymentService',['$resource', '$http', SelectPaymentService]);
}());