(function() {
    'use strict';
    var StampService = function($resource) {
	var stamp = $resource('http://localhost:8080/stampidia/rest/stampService/:stampId', {
	    stampId:'@stampId'
	}, {
	query : {
	  method : "GET",
	  isArray : false
	}
	});
	return {
	    getStamp : function(p_stamp) {
		console.log('STAMP '+p_stamp);
		return stamp.query({
			stampId : p_stamp
		});
	    }
	}
    };
    angular.module('stampidia.services').factory('stampService', [ '$resource', StampService ]);
}());