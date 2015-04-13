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
        var create_stamp = $resource('http://localhost:8080/stampidia/rest/stampService/:stampName/:stampDescription/:stampImage/:stampTags/:stampArtist/:stampSalesNumber/:stampCategory/:stampPrice', {
	    stampName:'@stampName',
	    stampDescription: '@stampDescription',
	    stampImage: '@stampImage',
	    stampTags: '@stampTags',
	    stampArtist:'@stampArtist', 
	    stampSalesNumber: '@stampSalesNumber',
	    stampCategory: '@stampCategory',
	    stampPrice: '@stampPrice'
	    
	}, {
	query : {
	  method : "PUT",
	  isArray : false
	}
	});
	return {
	    getStamp : function(p_stamp) {
		console.log('STAMP '+p_stamp);
		return stamp.query({
			stampId : p_stamp
		});
	    },
	    createStamp: function(p_stampName,p_stampDescription,p_stampImage,p_stampTags,p_stampArtist,p_stampSalesNumber,p_stampCategory,p_stampPrice) {
		console.log('p_stampDescription '+p_stampDescription);
		return create_stamp.query({
		    stampName:p_stampName,
		    stampDescription: p_stampDescription,
		    stampImage: p_stampImage,
		    stampTags: p_stampTags,
		    stampArtist:p_stampArtist, 
		    stampSalesNumber: p_stampSalesNumber,
		    stampCategory: p_stampCategory,
		    stampPrice: p_stampPrice
		});
            }
	}	
    };
    angular.module('stampidia.services').factory('stampService', [ '$resource', StampService ]);
}());