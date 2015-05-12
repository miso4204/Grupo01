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
	$scope.modeView = function(mode){
	    $("#list-stamps .icons-mode-view a").removeClass("active");
	    if(mode=="list"){
		$("#list-stamps .icons-mode-view .glyphicon-th-list").addClass("active");
		$('#list-stamps .features_items').hide();
		$('#list-stamps .features_list').show();
	    }else{
		$("#list-stamps .icons-mode-view .glyphicon-th").addClass("active");
		$('#list-stamps .features_list').hide();
		$('#list-stamps .features_items').show();
	    }
	}
	
	var init = function(){
	    $('#list-stamps .features_list').hide();
	    $scope.listCategories();
	    $scope.listStamps();
	}
	init();
	
    };
    angular.module('stampidia.controllers').controller('StampsController', [ '$scope', 'stampService','categoriesService','appSettings', StampsController ]);

}());
