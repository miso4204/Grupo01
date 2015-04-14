(function() {
    'use strict';
    var CartService = function($resource, $window) {
        function saveOrder(order) {
            localStorage.setItem('order', order);
        };
        return {
            saveOrder : saveOrder
        }
    };
    angular.module('stampidia.services').factory('cartService', [ '$resource', '$window', CartService ]);
}());