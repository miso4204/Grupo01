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
    var SessionService = function($cookieStore) {
	//this.create = function(authId, authToken, authPermission, id) {
	this.create = function() {
        var user = $cookieStore.get('authUser');
	    this.authId = user.username;
	    this.authToken = 'asdasdasdasdasd';
	    this.authPermission = 'ROLE_BUYER';
	    this.id = user.id;
	};

        this.validate = function(){
            return $cookieStore.get('authUser');
        };
	this.destroy = function() {
	    this.authId = null;
	    this.authToken = null;
	    this.authPermission = null;
		this.id = null;
	};
	return this;
    };
    angular.module('stampidia.services').factory('sessionService', ['$cookieStore', SessionService ]);
}());