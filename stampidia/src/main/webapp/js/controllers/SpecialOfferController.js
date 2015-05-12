(function(){
    'use strict';

    var SpecialOfferController = function($rootScope, $scope, $cookieStore, $location, $dialogs, sessionService, offerService){

        $scope.getSpecialOffer = function(){
            console.log("Entra a getSpecialOffer")
            offerService.getOffer(sessionService.plan).$promise.then(
                function(response){
                    console.log('Special Offer: ' + response);
                    $rootScope.specialOffer = response.resultado;
                }, function(response){
                    console.log(response);
                    $scope.error = true;
                    $scope.launch('error');
                }
            );
        }


    }
    angular.module('stampidia.controllers').controller('SpecialOfferController', [ '$rootScope', '$scope', '$cookieStore', '$location', '$dialogs', 'sessionService', 'offerService', SpecialOfferController ]);
})();