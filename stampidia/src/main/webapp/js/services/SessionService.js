/**
 * @ngdoc controller
 * @name stampidia.LoginController
 * @description # LoginController Controlador encargado del login/logout
 */
(function() {
    'use strict';
    
    /**
     * Servicio encargado de mantener la información del usuario que se encuentra actualmente logueado
     */
    var SessionService = function() {
	this.create = function(authId, authToken, authPermission, userId) {
	    this.authId = authId;
	    this.authToken = authToken;
	    this.authPermission = authPermission;

		// STMP-9 : se agrega el campo de id de usuario para la persistencia de la orden
		this.userId = userId;
	};
	this.destroy = function() {
	    this.authId = null;
	    this.authToken = null;
	    this.authPermission = null;
		this.userId = null;
	};
	return this;
    };
    angular.module('stampidia.services').factory('sessionService', [ SessionService ]);
}());