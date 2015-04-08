/**
 * @ngdoc service
 * @name stampidia.LoginService
 * @description # LoginService Servicio encargado del login/logout
 */
(function() {
    'use strict';

    /**
     * Servicio encargado de enviar la autenticacion encriptada en base64
     */
    var LoginService = function($resource, $http) {

	/**
	 * Endpoint base del api 
	 * TODO se debe cambiar para produccion a la url definitiva
	 */
	var stampidiaEndpoint = 'http://localhost:8080/stampidia';

	/**
	 * Metodo para encriptar la contraseña
	 */
	var calculateBtoa = function(credentials) {
	    return "Basic " + btoa(credentials['username'] + ":" + credentials['password']);
	};

	/**
	 * Objeto loginService encargado de enviar la petición de autenticación 
	 */
	var loginService = {
	    login : function(data) {
		//Headers que se deben enviar con la petición
		//X-Requested-With hace que el navegador no muestre un popup alternativo
		var heads = {
    		'X-Requested-With' : 'XMLHttpRequest',
    		'Content-Type' : 'application/x-www-form-urlencoded',
    		'Authorization' : calculateBtoa(data)
		};

		var promise = $http.get(stampidiaEndpoint + '/rest/loggedUser/' + data.username, {
		    headers : heads
		}).then(function(response) {
		    return response.data;
		});
		return promise;
	    }
	};

	return loginService;
    };

    angular.module('stampidia.services').factory('loginService', [ '$resource', '$http', LoginService ]);
}());