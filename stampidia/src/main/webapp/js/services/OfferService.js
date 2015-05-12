(function() {
    'use strict';
    var OfferService = function($resource, $window) {

        var getActiveOffer = $resource('http://localhost:8080/stampidia/rest/specialoffer/:plan', {
                plan : '@plan'
            },
            {
                getOffer : {
                    method : "GET"
                }
            }
        );

        return {
            getOffer : function(plan){
                console.log(plan);
                return getActiveOffer.getOffer({
                    plan : plan
                });
            }
        }
    };
    angular.module('stampidia.services').factory('offerService', [ '$resource', '$window', OfferService ]);
}());