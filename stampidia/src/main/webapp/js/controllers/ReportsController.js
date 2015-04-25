(function() {
	'use strict';

	var ReportsController = function($rootScope, $scope, $location, appSettings) {
	    
	    $scope.addPoints = function () {
	        var seriesArray = $scope.highchartsNG.series
	        var rndIdx = Math.floor(Math.random() * seriesArray.length);
	        seriesArray[rndIdx].data = seriesArray[rndIdx].data.concat([1, 10, 20])
	    };

	    $scope.addSeries = function () {
	        var rnd = []
	        for (var i = 0; i < 10; i++) {
	            rnd.push(Math.floor(Math.random() * 20) + 1)
	        }
	        $scope.highchartsNG.series.push({
	            data: rnd
	        })
	    }

	    $scope.removeRandomSeries = function () {
	        var seriesArray = $scope.highchartsNG.series
	        var rndIdx = Math.floor(Math.random() * seriesArray.length);
	        seriesArray.splice(rndIdx, 1)
	    }

	    $scope.options = {
	        type: 'line'
	    }

	    $scope.swapChartType = function () {
	        if (this.highchartsNG.options.chart.type === 'line') {
	            this.highchartsNG.options.chart.type = 'bar'
	        } else {
	            this.highchartsNG.options.chart.type = 'line'
	        }
	    }

	    $scope.highchartsNG = {
	        options: {
	            chart: {
	                type: 'bar'
	            }
	        },
	        series: [{
	            data: [5,15,3,32,25,60,7,5,0]
	        }],
	        title: {
	            text: 'Hello'
	        },
	        loading: false
	    }
	    
	    $scope.highchartsNG2 = {
		        options: {
		            chart: {
		                type: 'line'
		            }
		        },
		        series: [{
		            data: [1,2,3,4,5,6,7,7]
		        }],
		        title: {
		            text: 'Ventas por Producto'
		        },
		        loading: false
		    }
	};

	angular.module('stampidia.controllers').controller('ReportsController',
			[ '$rootScope', '$scope', '$location', 'appSettings', ReportsController ]);
}());