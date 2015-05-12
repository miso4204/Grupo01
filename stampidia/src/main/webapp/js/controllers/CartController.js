(function(){
    'use strict';

    var CartController = function($rootScope, $scope, $cookieStore, $location,$dialogs, sessionService, cartService){

        //$rootScope.order = $cookieStore.get('order');
        //$scope.order = $cookieStore.get('order');
        console.log('order de COOKIE : '+JSON.stringify($rootScope.order));

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
            if($scope.order != null){
                console.log("Entra a saveOrder")
                $scope.order = fillOrder($scope.order);
                cartService.update($scope.order).$promise.then(
                function(response){

                    $scope.newOrder = response.resultado;
                    $rootScope.order = angular.copy($scope.newOrder);
                    console.log($scope.order.stmpOrderDetailList);
                    $scope.order.stmpOrderDetailList = setOrderId($scope.order.stmpOrderDetailList, response.resultado.id);
                    
                    cartService.updateDetails($scope.order.stmpOrderDetailList).$promise.then(
                            function(response){
                                console.log('Save Order' + response);
                                $scope.newDetails = response.resultado;
                                $rootScope.order.stmpOrderDetailList = angular.copy($scope.newDetails);
                            }, function(response){
                                console.log(response);
                                $scope.error = true;
                                $scope.launch('error');
                            }
                        );
                }, function(response){
                        console.log(response);
                        $scope.error = true;
                        $scope.launch('error');
                    }
                );
                

                $rootScope.itemCount = 0;
                console.log('id de la orden al final ' + $scope.newOrder + '|' + $rootScope.order);
                $location.url("/select_payment");
            }
        }

        var fillOrder = function(order){
            order.date = new Date();
            order.shippingStatus = false;
            order.paymentStatus = false;
            order.orderStatus = false;

            console.log("ID : " + sessionService.id);
            order.idUser = {};
            order.idUser.id = sessionService.id;
            order.idUser.username = sessionService.authId;

            return order;
        }

        var setOrderId = function(items, orderId){

            console.log('Setea los id');

            for(var i = 0 ; i < items.length; i++){
                items[i].idOrder = {};
                items[i].idOrder.id = orderId;
                items[i].idUser = {};
                items[i].idUser.id = sessionService.id;
            }
            return items;
        }

        $scope.launch = function(which){
            var dlg = null;
            switch(which){
                // Notify Dialog
                case 'notify':
                    dlg = $dialogs.notify('Something Happened!','Something happened that I need to tell you.');
                    break;
                // Error Dialog
                case 'error':
                    dlg = $dialogs.error('This is my error message','');
                    break;
                case 'wait':
                    dlg = $dialogs.wait(msgs[i++],progress);
                    fakeProgress();
                    break;
            }; // end switch
        } // end launch

    }
    angular.module('stampidia.controllers').controller('CartController', [ '$rootScope', '$scope', '$cookieStore', '$location', '$dialogs', 'sessionService', 'cartService', CartController ]);
})();