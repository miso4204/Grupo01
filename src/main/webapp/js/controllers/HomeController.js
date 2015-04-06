(function() {
    'use strict';

    var HomeController = function($scope, homeService, appSettings) {
	homeService.listSizes().success(function(resp){
	    console.log(resp + 'bien');
	},function(resp){
	    console.log(resp + 'mal');
	});
    };

    angular.module('stampidia.controllers').controller('HomeController',
	    [ '$scope', 'homeService', 'appSettings', HomeController ]);
}());