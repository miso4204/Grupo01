/**
 * @ngdoc service
 * @name stampidia.LoginService
 * @description # LoginService Servicio encargado del login/logout
 */
(function() {
    'use strict';

    /**
     * Servicio encargado de consultar los datos de los reportes
     */
    var ReportService = function($resource, $http) {

	/**
	 * Endpoint base del api 
	 * TODO se debe cambiar para produccion a la url definitiva
	 */	
	var reportByPeriod = $resource('/stampidia/rest/report_by_period',{},{
	    period:{
		method:'GET'
	    }
	});
	var reportBySales = $resource('/stampidia/rest/report_by_sales',{},{
	    sales:{
		method:'GET'
	    }
	});
	
	return {
	    sales : function(username){
		console.log(username);
	    	return reportBySales.sales({username:username});
	    }, 
	    period : function(username){
		console.log(username);
	    	return reportByPeriod.period({username:username});
	    }
	}
    };

    angular.module('stampidia.services').factory('reportService', [ '$resource', '$http', ReportService ]);
}());