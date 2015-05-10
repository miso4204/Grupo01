(function() {
    'use strict';

    var OrderDetailController = function($rootScope, $scope, $location, orderService, orderDetailService, sessionService, appSettings) {

	$scope.selectedOrderDetail={};

	    var res= orderDetailService.get({ id: $rootScope.selectedOrder }).$promise.then(function(response){

		if(response.estado.type=='OK')
		{
		    $scope.selectedOrderDetail=response.resultado;
		}else{
		    //TODO send error
		}

	    }, function(response) {
		console.log('Error: ' +response);
	    })
	    
	    //rating
	    
	    $scope.rating1 = 5;
	    $scope.rating2 = 2;
	    $scope.isReadonly = true;
	    $scope.rateFunction = function(rating) {
		//TODO SERVICE RATING
	      console.log("Rating selected: " + rating);
	    };
    };
    
    
    angular.module('stampidia.controllers').controller('OrderDetailController',
	    [ '$rootScope', '$scope', '$location', 'orderService', 'orderDetailService','sessionService', 'appSettings',  OrderDetailController ]).directive("starRating", function() {
		  return {
		      restrict : "EA",
		      template : "<ul class='rating' ng-class='{readonly: readonly}'>" +
		                 "  <li ng-repeat='star in stars' ng-class='star' ng-click='toggle($index)'>" +
		                 "    <i class='fa fa-star'></i>" + //&#9733
		                 "  </li>" +
		                 "</ul>",
		      scope : {
		        ratingValue : "=ngModel",
		        max : "=?", //optional: default is 5
		        onRatingSelected : "&?",
		        readonly: "=?"
		      },
		      link : function(scope, elem, attrs) {
		        if (scope.max == undefined) { scope.max = 5; }
		        function updateStars() {
		          scope.stars = [];
		          for (var i = 0; i < scope.max; i++) {
		            scope.stars.push({
		              filled : i < scope.ratingValue
		            });
		          }
		        };
		        scope.toggle = function(index) {
		          if (scope.readonly == undefined || scope.readonly == false){
		            scope.ratingValue = index + 1;
		            scope.onRatingSelected({
		              rating: index + 1
		            });
		          }
		        };
		        scope.$watch("ratingValue", function(oldVal, newVal) {
		          if (newVal) { updateStars(); }
		        });
		      }
		    };
		  });
}());