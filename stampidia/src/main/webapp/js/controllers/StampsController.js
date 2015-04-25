(function() {
    'use strict';
    var StampsController = function($scope, stampService,categoriesService, appSettings) {
	$scope.listStamps = function(id){
	    console.log('list stamps');
	    stampService.getAllStamps(id).$promise.then(
		    function(response){
			$scope.stamps= response.resultado;		    
		    }, function(response){
			console.log(response);
		    }    
	    );
	}
	$scope.listStamp = function(id){
	    console.log('***list stamp ***' + id );
	    stampService.getStamp(id).$promise.then(
		    function(response){
			$scope.stamps= response.resultado;		    
		    }, function(response){
			console.log(response);
		    }    
	    );
	}
	$scope.listCategories = function(){
	    console.log('listcategories');
	    categoriesService.listCategories().$promise.then(		
		    function(response){
			$scope.categories= response.resultado;
		    },
		    function(response){
			console.log(response)
		    })
	}
	
	$scope.selectCategory = function(StampId){
	    $scope.listStamps(StampId);
	}
	$scope.loadCreateProduct = function(StampId){
	    console.log("init" + StampId);
	    $scope.listStamp(StampId);
	    
	}
	
	var init = function(){
	    $scope.listCategories();
	    $scope.listStamps();
	}
	init();
	
    };
    angular.module('stampidia.controllers').controller('StampsController', [ '$scope', 'stampService','categoriesService','appSettings', StampsController ]);

}());
