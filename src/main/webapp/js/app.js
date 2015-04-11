/**
 * @ngdoc app
 * @name stampidia
 * @description # App - aplicacion principal
 */
(function() {
    'use strict';

    var stampidia = angular.module('stampidia', [ 'ngCookies', 'ngRoute', 'ngResource', 'stampidia.services', 'stampidia.controllers' ]);
    var stampidiaControllers = angular.module('stampidia.controllers', []);
    var stampidiaServices = angular.module('stampidia.services', []);

    var Configuration = function($routeProvider, $compileProvider, $locationProvider, $httpProvider) {

	$httpProvider.interceptors.push('httpInterceptor');
	$routeProvider.when('/', {
	    templateUrl : 'partials/home.html',
	    controller : 'HomeController'
	}).when('/products', {
	    templateUrl : 'partials/products/products.html',
	    controller : 'ProductsController'
	}).when('/login', {
	    templateUrl : 'partials/login/login.html',
	    controller : 'LoginController'
	}).when('/register', {
	    templateUrl : 'partials/login/register.html',
	    controller : 'RegisterController'
	}).when('/select_payment', {
	    templateUrl : 'partials/pay/select_payment.html',
	    controller : 'SelectPaymentController'
	}).when('/cash_success', {
	    templateUrl : 'partials/pay/cash_success.html',
	    controller : 'SelectPaymentController'
	}).when('/cash_error', {
	    templateUrl : 'partials/pay/cash_error.html',
	    controller : 'SelectPaymentController'
	}).when('/pse_success', {
	    templateUrl : 'partials/pay/pse_success.html',
	    controller : 'SelectPaymentController'
	}).when('/pse_error', {
	    templateUrl : 'partials/pay/pse_error.html',
	    controller : 'SelectPaymentController'
	}).when('/credit_success', {
	    templateUrl : 'partials/pay/credit_success.html',
	    controller : 'SelectPaymentController'
	}).when('/credit_error', {
	    templateUrl : 'partials/pay/credit_error.html',
	    controller : 'SelectPaymentController'
	}).when('/create-product/:stampId', {
	    templateUrl : 'partials/products/createProduct.html',
	    controller : 'CreateProductController'
	}).otherwise({
	    redirectTo : '/'
	});

	// remueve clases css inecesarias
	$compileProvider.debugInfoEnabled(true);

	//Anexa por defecto a todas las llamadas el encabezado
	$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
    };

    angular.module('stampidia').config([ '$routeProvider', '$compileProvider', '$locationProvider', '$httpProvider', Configuration ]);

}());