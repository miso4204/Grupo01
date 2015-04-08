(function() {
	'use strict';
	var SessionService = function() {
		this.create = function(authId, authToken, authPermission) {
			this.authId = authId;
			this.authToken = authToken;
			this.authPermission = authPermission;
		};
		this.destroy = function() {
			this.authId = null;
			this.authToken = null;
			this.authPermission = null;
		};
		return this;
	};
	angular.module('stampidia.services').factory('sessionService',[SessionService]);
}());