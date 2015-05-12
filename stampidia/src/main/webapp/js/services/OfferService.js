(function() {
    'use strict';
    var OfferService = function($resource, $window) {

        var getActiveOffer = $resource('http://localhost:8080/stampidia/rest/specialoffer', null,
            {
                getOffer : {
                    method : "GET"
                }
            }
        );

        return {
            getOffer : function(){
                console.log();
                return getActiveOffer.getOffer({
                });
            }
        }
    };
    angular.module('stampidia.services').factory('offerService', [ '$resource', '$window', OfferService ]);
}());