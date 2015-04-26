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
	var stampidiaEndpoint = 'http://localhost:8080/stampidia';

	/**
	 * Objeto loginService encargado de enviar la petición de autenticación 
	 */
	var reportService = {
	    report : function(data) {		
		return undefined;
	    }
	};

	return reportService;
    };

    angular.module('stampidia.services').factory('reportService', [ '$resource', '$http', ReportService ]);
}());