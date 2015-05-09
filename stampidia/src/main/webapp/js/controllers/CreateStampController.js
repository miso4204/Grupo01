(function() {
    'use strict';
    var CreateStampController = function($rootScope,$scope,$location,$dialogs,$timeout, stampService, categoriesService, Upload, appSettings) {

	var initStamp = $scope.stamp;
	var initFile = $scope.file;
	$scope.createStamp = function() {
	    $scope.uploadStamp();
	    $scope.stamp.image = $scope.file[0].name;
	    stampService.createStamp($scope.stamp.name, $scope.stamp.description, $scope.stamp.image, $scope.stamp.tags, 1, $scope.stamp.salesNumber, 1, $scope.stamp.price, true).$promise.then(
		function(response) {
		    $scope.launch('wait');
		    $scope.error = false;
		}, function(response) {
		    console.log(response);
		    $scope.error = true;
		    $scope.launch('error');
	    }); 
	}
	$scope.listCategories = function() {
	    categoriesService.listCategories().$promise.then(function(response) {
		$scope.categories = response.resultado;
	    }, function(response) {
		console.log(response);
	    }

	    );
	}

	$scope.uploadStamp = function() {
	    console.log($scope.file);
	    Upload.upload({
	    url : 'http://localhost:8080/stampidia/rest/uploadFile',
	    fields : {
	    name : $scope.file[0].name,
	    file : 'file:' + $scope.file[0].name
	    }, // additional data to send
	    file : $scope.file[0]
	    }).progress(function(evt) {
		var progressPercentage = parseInt(100.0 * evt.loaded / evt.total);
		console.log('progress: ' + progressPercentage + '% ' + evt.config.file.name);
	    }).success(function(data, status, headers, config) {
		console.log('file ' + config.file.name + 'uploaded. Response: ' + data);
	    });
	    return $scope.file[0].name;
	}

	$scope.generateThumb = function(file) {
	    if (file != null) {
		if ($scope.fileReaderSupported && file.type.indexOf('image') > -1) {
		    $timeout(function() {
			var fileReader = new FileReader();
			fileReader.readAsDataURL(file);
			fileReader.onload = function(e) {
			    $timeout(function() {
				file.dataUrl = e.target.result;
			    });
			}
		    });
		}
	    }
	};

	$scope.cleanFrom = function() {
	    $scope.stamp.name = "";
	    $scope.stamp.description = "";
	    $scope.stamp.image = "";
	    $scope.stamp.tags = "";
	    $scope.stamp.category = "";
	    $scope.stamp.salesNumber = "";
	    $scope.stamp.price = "";
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
	var progress = 25;
	  var msgs = [
	    'Hey! I\'m waiting here...',
	    'About half way done...',
	    'Almost there?',
	    'Woo Hoo! I made it!'
	  ];
	  var i = 0;
	  
	  var fakeProgress = function(){
	    $timeout(function(){
	      if(progress < 100){
	        progress += 25;
	        $rootScope.$broadcast('dialogs.wait.progress',{msg: msgs[i++],'progress': progress});
	        fakeProgress();
	      }else{
		  $rootScope.$broadcast('dialogs.wait.complete');
		  $location.url('/stamps');
	      }
	    },1000);
	    
	  }


	var init = function() {
	    $scope.listCategories();
	}
	init();
    };
    angular.module('stampidia.controllers').controller('CreateStampController', [ '$rootScope','$scope', '$location','$dialogs','$timeout','stampService', 'categoriesService', 'Upload', 'appSettings', CreateStampController ]);
}());
