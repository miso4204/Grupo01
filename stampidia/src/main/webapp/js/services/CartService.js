(function() {
    'use strict';
    var CartService = function($resource, $window) {

        var saveOrder = $resource('http://localhost:8080/stampidia/rest/cart', null,
            {
                updateOrder : {
                    method : "PUT"
                }
            }
        );

        return {
            update : function(order){
                console.log(order);
                return saveOrder.updateOrder(order);
            }
        }
    };
    angular.module('stampidia.services').factory('cartService', [ '$resource', '$window', CartService ]);
}());