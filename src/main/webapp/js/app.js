(function() {
    'use strict';
    var stampidia = angular.module('stampidia', [ 'ngCookies', 'ngRoute',
	    'ngResource', 'stampidia.services', 'stampidia.controllers' ]);
    var stampidiaControllers = angular.module('stampidia.controllers', []);
    var stampidiaServices = angular.module('stampidia.services', []);

    var Configuration = function($routeProvider, $compileProvider, $locationProvider,$httpProvider) {

	$httpProvider.interceptors.push('httpInterceptor');
	
	$routeProvider.when('/', {
	    templateUrl : 'partials/home.html',
	    controller : 'HomeController'
	}).when('/login', {
	    templateUrl : 'partials/login/login.html',
	    controller : 'LoginController'
	}).when('/select_payment', {
		templateUrl : 'partials/pay/select_payment.html',
		controller : 'SelectPaymentController'
	}).otherwise({
	    redirectTo : '/'
	});

	// remueve clases css inecesarias
	$compileProvider.debugInfoEnabled(false);
	
	$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
    };
    angular.module('stampidia').config([ '$routeProvider', '$compileProvider', '$locationProvider', '$httpProvider', Configuration ]);

}());