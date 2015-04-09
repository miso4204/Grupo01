(function() {
    'use strict';

    var SelectPaymentController = function($scope, $location, selectPaymentService, appSettings) {

	selectPaymentService.listPaymentTypes().$promise.then(function(response) {
	    console.log(response);
	    $scope.paymentTypes = response.resultado;
	    console.log($scope.paymentTypes);
	}, function(response) {
	    console.log('bad' + response);
	});
	$scope.changeRoute = function(url, forceReload) {
	    $scope = $scope || angular.element(document).scope();
	    if (forceReload || $scope.$$phase) { // that's right TWO dollar
						    // signs: $$phase
		window.location = url;
	    } else {
		$location.path(url);
		$scope.$apply();
	    }
	};
	$scope.deliveryDay = function() {
	    var month = new Array();
	    month[0] = "January";
	    month[1] = "February";
	    month[2] = "March";
	    month[3] = "April";
	    month[4] = "May";
	    month[5] = "June";
	    month[6] = "July";
	    month[7] = "August";
	    month[8] = "September";
	    month[9] = "October";
	    month[10] = "November";
	    month[11] = "December";
	    var d = new Date();
	    var n = month[d.getMonth()];
	    var deliveryDay = d.getDate() + 5;
	    console.log(deliveryDay);
	    var fullDeliveryDate = n + " " + deliveryDay + ", " + d.getFullYear();
	    return fullDeliveryDate;
	};
	$scope.submit = function() {
	    var paymentMethod;
	    if ($scope.paymenttype == 1) {
		paymentMethod = "cash"
	    } else if ($scope.paymenttype == 2) {
		paymentMethod = "pse"
	    } else if ($scope.paymenttype == 3) {
		paymentMethod = "credit"
	    }
	    selectPaymentService.pay(paymentMethod, 1).$promise.then(function(response) {
		console.log(response);
		$scope.changeRoute('#/' + response.mensajeAccion);
		console.log($location);
	    }, function(response) {
		console.log('bad' + response);
	    })
	};
    }
    angular.module('stampidia.controllers').controller('SelectPaymentController', [ '$scope', '$location', 'selectPaymentService', 'appSettings', SelectPaymentController ]);
}());
