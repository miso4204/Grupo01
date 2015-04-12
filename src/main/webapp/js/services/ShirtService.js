(function() {
    'use strict';
    var ShirtService = function($resource) {
	var shirt = $resource('http://localhost:8080/stampidia/rest/shirtService/:shirtText/:shirtIdColor/:shirtIdStyle/:shirtIdSize/:shirtIdStamp/:shirtIdUser', {
	    shirtText:'@shirtText',
            shirtIdColor: '@shirtIdColor',
            shirtIdStyle: '@shirtIdStyle',
            shirtIdSize: '@shirtIdSize',
            shirtIdStamp:'@shirtIdStamp', 
            shirtIdUser: '@shirtIdUser'	
	    
	}, {
	query : {
	  method : "PUT",
	  isArray : false
	}
	});
	return {
	    createShirt : function(p_shirtText,p_shirtIdColor,p_shirtIdStyle,p_shirtIdSize,p_shirtIdStamp,p_shirtIdUser) {
		console.log('p_shirtText '+p_shirtText);
		return shirt.query({
		    shirtText : p_shirtText,
		    shirtIdColor: p_shirtIdColor,
		    shirtIdStyle: p_shirtIdStyle,
		    shirtIdSize: p_shirtIdSize,
		    shirtIdStamp: p_shirtIdStamp,
		    shirtIdUser: p_shirtIdUser
		});
	    }
	}
    };
    angular.module('stampidia.services').factory('shirtService', [ '$resource', ShirtService ]);
}());