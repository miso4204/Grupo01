(function() {
    'use strict';

    var ReportsController = function($rootScope, $scope, $location, appSettings, sessionService, reportService) {

	$scope.getReportSalesByPeriod = function() {
	    reportService.salesPeriod(sessionService.authId).$promise.then(function(response) {
		var result = response.resultado;
		var seriesData = [];
		for (var i = 0; i < result.length; i++) {
		    $scope.highchartsNGPeriod.xAxis.categories.push(result[i][0]);
		    seriesData.push(result[i][2]);
		}
		$scope.highchartsNGPeriod.series.push({
		    data : seriesData
		})
	    }, function(response) {
		console.log(response);
	    });
	};
	
	$scope.getReportSalesByArtist = function() {
	    reportService.salesArtist(sessionService.authId).$promise.then(function(response) {
		var result = response.resultado;
		var seriesData = [];
		for (var i = 0; i < result.length; i++) {
		    $scope.highchartsNGPeriod.xAxis.categories.push(result[i][0]);
		    seriesData.push(result[i][2]);
		}
		$scope.highchartsNGPeriod.series.push({
		    data : seriesData
		})
	    }, function(response) {
		console.log(response);
	    });
	};
	$scope.getReportRatingByDesign = function() {
	    reportService.ratingDesigns(sessionService.authId).$promise.then(function(response) {
		$scope.ratings = response.resultado;
	    }, function(response) {
		console.log(response);
	    });
	};
	$scope.getReportRatingByDesignArtist = function() {
	    reportService.ratingDesignsArtist($scope.artistName).$promise.then(function(response) {
		$scope.ratingsArtist = response.resultado;
	    }, function(response) {
		console.log(response);
	    });
	};

//	$scope.getReportSalesByPeriod();
	$scope.getReportSalesByArtist();
	$scope.getReportRatingByDesign();

	$scope.highchartsNGPeriod = {
	title : {
	text : 'Number of shirts sold by month',
	x : -20
	//center
	},
	xAxis : {
	    categories : []
	},
	yAxis : {
	title : {
	    text : '# Shirts sold'
	},
	plotLines : [ {
	value : 0,
	width : 1,
	color : 'fuccsia'
	} ]
	},
	tooltip : {
	    valueSuffix : '°C'
	},
	legend : {
	layout : 'vertical',
	align : 'right',
	verticalAlign : 'middle',
	borderWidth : 0
	},
	series : []
	}

    };

    angular.module('stampidia.controllers').controller('ReportsController', [ '$rootScope', '$scope', '$location', 'appSettings', 'sessionService', 'reportService', ReportsController ]);
}());