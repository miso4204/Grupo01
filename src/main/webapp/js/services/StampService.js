(function() {
    'use strict';
    var StampService = function($resource) {
	console.log('StampService');
	var stamps = $resource('http://localhost:8080/stampidia/rest/stampService/', {
	    stampId:'@stampId'
	}, {
	query : {
	  method : "GET",
	  isArray : false
	}
	});
	var list_stamps = $resource('http://localhost:8080/stampidia/rest/stampService/', {
	    categoryId : '@categoryId'
	}, {
	query : {
	   method : "GET",
	   isArray : false
	},
	listByCategory : {
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
		console.log('getStamp STAMP '+p_stamp);
		return stamps.query({
			stampId : p_stamp
		});
		console.log('getStamp despues ');
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
            },
            getAllStamps : function(p_category) {
		console.log('CATEGORY '+p_category);
		if(p_category){
		    return list_stamps.listByCategory({
			categoryId : p_category
		    });
		}else{
		    return list_stamps.query();
		}
	    },
	}	
    };
    angular.module('stampidia.services').factory('stampService', [ '$resource', StampService ]);
}());