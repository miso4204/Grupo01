(function() {
    'use strict';

    var SelectPaymentController = function($rootScope, $scope, $location, $dialogs, $timeout, selectPaymentService, appSettings) {

	selectPaymentService.listPaymentTypes().$promise.then(function(response) {
	    console.log(response);
	    $scope.paymentTypes = response.resultado;
	}, function(response) {
	    console.log('bad' + response);
	});
	$scope.goHome = function() {
	    $location.url('/');
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
	$scope.launch = function(which){
	    var dlg = null;
	    switch(which){
	      // Wait / Progress Dialog
	      case 'wait':
	        dlg = $dialogs.wait(msgs[i++],progress);
	        fakeProgress();
	        break;
	    };
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
		$location.url('/'+response.mensajeAccion);
	    }, function(response) {
		console.log('bad' + response);
	    })
	};
	// for faking the progress bar in the wait dialog
	  var progress = 25;
	  var msgs = [
	    'Hey! I\'m waiting here...',
	    'About half way done...',
	    'Almost there?',
	    'Woo Hoo! I made it!'
	  ];
	  var i = 0;
	  
	  var fakeProgress = function(){
	    $timeout(function(){
	      if(progress < 100){
	        progress += 25;
	        $rootScope.$broadcast('dialogs.wait.progress',{msg: msgs[i++],'progress': progress});
	        fakeProgress();
	      }else{
		  $rootScope.$broadcast('dialogs.wait.complete');
	      }
	    },1000);
	  }; // end fakeProgress 
    }
    angular.module('stampidia.controllers').controller('SelectPaymentController', [ '$rootScope', '$scope', '$location', '$dialogs', '$timeout', 'selectPaymentService', 'appSettings', SelectPaymentController ]);
}());
