(function(){
    'use strict';

    var CartController = function($rootScope, $scope, sessionService, cartService){

        $scope.increaseQuantity = function(data){
            data.quantity = data.quantity + 1;
        }
        $scope.decreaseQuantity = function(data){
            if(data.quantity != 0){
                data.quantity = data.quantity - 1;
                if(data.quantity == 0){
                    $scope.removeItem(data);
                }
            }
        }

        $scope.removeItem = function(item){
            var indx = $rootScope.order.stmpOrderDetailList.indexOf(item);
            $rootScope.order.stmpOrderDetailList.splice(indx, 1)
        }

        $scope.continueFlag = function(){
            if($rootScope.order != null){
                return $rootScope.order.stmpOrderDetailList.length == 0;
            }
            return true;
        }

        $scope.saveOrder = function(){
            if($rootScope.order != null){
                $rootScope.order = fillOrder($rootScope.order);
                cartService.update($rootScope.order).$promise.then(
                function(response){
                        console.log('Save Order' + response);
                    }, function(response){
                        console.log(response);
                    }
                );
            }
        }

        var fillOrder = function(order){
            order.date = new Date();
            order.shippingStatus = false;
            order.paymentStatus = false;
            order.orderStatus = false;

            order.idUser = {};
            order.idUser.id = sessionService.userId;
            order.idUser.username = sessionService.authId;

            return order;
        }

    }
    angular.module('stampidia.controllers').controller('CartController', [ '$rootScope', '$scope', 'sessionService', 'cartService', CartController ]);
})();