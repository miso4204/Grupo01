(function() {
    'use strict';
    var CartService = function($resource, $window) {
        function saveOrder(order) {
            localStorage.setItem('order', order);
        };

        function loadOrderFromLocalStorage(){
            return localStorage.getItem('order');
        }


        return {
            saveOrder : saveOrder,
            loadOrderFromLocalStorage : loadOrderFromLocalStorage
        }
    };
    angular.module('stampidia.services').factory('cartService', [ '$resource', '$window', CartService ]);
}());