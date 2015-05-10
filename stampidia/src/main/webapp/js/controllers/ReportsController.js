(function() {
	'use strict';

	var ReportsController = function($rootScope, $scope, $location, appSettings,sessionService,reportService) {
	    
	    $scope.getReportByPeriod = function(){
		reportService.period(sessionService.authId).$promise.then(function(response){		   		    
        		    var result = response.resultado;
        		    var seriesData = [];
                	    for(var i = 0;i<result.length;i++){
                		$scope.highchartsNGPeriod.xAxis.categories.push(result[i][0]);
                		seriesData.push(result[i][2]);
                	    }  
                	    $scope.highchartsNGPeriod.series.push({data:seriesData})
        	    },function(response){
        		console.log(response);
        	    }
		);
	    };
	    $scope.getReportBySales = function(){
		reportService.sales(sessionService.authId).$promise.then(function(response){		   		            		    
                	    console.log(response);
        	    },function(response){
        		console.log(response);
        	    }
		);
	    };
	    
	    $scope.getReportByPeriod();
	    $scope.getReportBySales();
	    
	    	    
	    $scope.highchartsNGPeriod = {
		    title: {
			text: 'Number of shirts sold by month',
		        x: -20 //center
		    },		        
		    xAxis: {
			categories: []
		    },
		    yAxis: {
			title: {
			    text: '# Shirts sold'
		        },
		        plotLines: [{
		            value: 0,
		            width: 1,
		            color: 'fuccsia'
		        }]
		    },
		    tooltip: {
			valueSuffix: '°C'
		    },
		    legend: {
			layout: 'vertical',
		        align: 'right',
		        verticalAlign: 'middle',
		        borderWidth: 0
		    },
		    series:[]
	    }
	    
	   };

	angular.module('stampidia.controllers').controller('ReportsController',	[ '$rootScope', '$scope', '$location', 'appSettings','sessionService','reportService', ReportsController ]);
}());