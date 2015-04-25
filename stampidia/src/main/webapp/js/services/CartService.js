(function() {
    'use strict';
    var CartService = function($resource, $window) {


        function saveOrder(order) {
            console.log(order);
            var cartSaveRsrc = $resource('http://localhost:8080/stampidia/rest/cart', {}, {
                query : {
                    method : "PUT",
                    isArray : false
                }
            });

            cartSaveRsrc.save(order);

            console.log('servicio de cart '+cartSaveRsrc);
            return cartSaveRsrc.query({});

            //localStorage.setItem('order', order);
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