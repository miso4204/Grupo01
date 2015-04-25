/**
 * @ngdoc service
 * @name stampidia.LoginService
 * @description # LoginService Servicio encargado del login/logout
 */
(function() {
    'use strict';

    /**
     * Servicio encargado de enviar archivos por el servicio uploadFile
     */
    var UploadService = function($resource, $http) {

	/**
	 * Endpoint base del api 
	 * TODO se debe cambiar para produccion a la url definitiva
	 */
	var stampidiaEndpoint = 'http://localhost:8080/stampidia';

	/**
	 * Objeto loginService encargado de enviar la petición de autenticación 
	 */
	var uploadService = {
	    uploadFile : function(data) {		
		return undefined;
	    }
	};

	return uploadService;
    };

    angular.module('stampidia.services').factory('uploadService', [ '$resource', '$http', UploadService ]);
}());