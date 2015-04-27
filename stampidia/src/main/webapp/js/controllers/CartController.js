(function(){
    'use strict';

    var CartController = function($rootScope, $scope, cartService){

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
                cartService.update($rootScope.order).$promise.then(
                function(response){
                        console.log('Save Order' + response);
                    }, function(response){
                        console.log(response);
                    }
                );
            }
        }

    }
    angular.module('stampidia.controllers').controller('CartController', [ '$rootScope', '$scope', 'cartService', CartController ]);
})();