(function() {
    'use strict';
    var stampidia = angular.module('stampidia', [ 'ngCookies', 'ngRoute',
	    'ngResource', 'stampidia.services', 'stampidia.controllers' ]);
    var stampidiaControllers = angular.module('stampidia.controllers', []);
    var stampidiaServices = angular.module('stampidia.services', []);

    var Configuration = function($routeProvider, $compileProvider, $locationProvider,$httpProvider) {

//	$httpProvider.interceptors.push('httpInterceptor');
	
//	$locationProvider.html5Mode(true);
	
	$routeProvider.when('/', {
	    templateUrl : 'partials/home.html',
	    controller : 'HomeController'
	}).when('/products', {
	    templateUrl : 'partials/products/products.html',
	    controller : 'ProductsController'
	}).when('/login', {
	    templateUrl : 'partials/login/login.html',
	    controller : 'LoginController'
	}).otherwise({
	    redirectTo : '/'
	});

	// remueve clases css inecesarias
	$compileProvider.debugInfoEnabled(false);
	
//	$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
//	$httpProvider.defaults.headers.common["Content-Type"] = 'application/x-www-form-urlencoded';
    };
    angular.module('stampidia').config([ '$routeProvider', '$compileProvider', '$locationProvider', '$httpProvider', Configuration ]);

}());