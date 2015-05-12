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
	var reportSalesByPeriod = $resource('/stampidia/rest/report/sales/period',{},{
	    report:{
		method:'GET'
	    }
	});
	var reportSalesByArtist = $resource('/stampidia/rest/report/sales/artist',{},{
	    report:{
		method:'GET'
	    }
	});
	var reportDesign = $resource('/stampidia/rest/report/rating/designs',{},{
	    report:{
		method:'GET'
	    }
	});
	var reportDesignByArtist = $resource('/stampidia/rest/report/rating/designs/artist',{},{
	    report:{
		method:'GET'
	    }
	});
	
	
	return {
	    salesPeriod : function(username){
		return reportSalesByPeriod.report({username:username});
	    }, 
	    salesArtist : function(username){
		return reportSalesByArtist.report({username:username});
	    },
	    ratingDesigns : function(){
		return reportDesign.report();
	    },
	    ratingDesignsArtist : function(username){
		return reportDesignByArtist.report({username:username});
	    }
	}
    };

    angular.module('stampidia.services').factory('reportService', [ '$resource', '$http', ReportService ]);
}());