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

        var saveOrderDetails = $resource('http://localhost:8080/stampidia/rest/cart/items', null,
            {
                updateOrderDetails : {
                    method : "PUT"
                }
            }
        );

        return {
            update : function(order){
                console.log(order);
                return saveOrder.updateOrder(order);
            },
            updateDetails : function(details){
                console.log(details);
                return saveOrderDetails.updateOrderDetails(details);
            }
        }
    };
    angular.module('stampidia.services').factory('cartService', [ '$resource', '$window', CartService ]);
}());