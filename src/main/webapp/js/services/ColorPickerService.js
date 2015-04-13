(function(angular) {
  var ngColorPicker = angular.module('directive.colorPicker', []);

  var colors = ["#5484ED", "#A4BDFC", "#46D6DB", "#7AE7BF",
    "#51B749", "#FBD75B", "#FFB878", "#FF887C", "#DC2127",
    "#DBADFF", "#E1E1E1"];
  
  /**
   * Method taken from Brian Grinstead and modified the return 
   * of rounded r,g and b.
   * @https://github.com/bgrins/TinyColor/blob/master/tinycolor.js
   **/
  function hsvToRgb(h, s, v) {
    h*=6;
    var i = ~~h,
      f = h - i,
      p = v * (1 - s),
      q = v * (1 - f * s),
      t = v * (1 - (1 - f) * s),
      mod = i % 6,
      r = [v, q, p, p, t, v][mod] * 255,
      g = [t, v, v, q, p, p][mod] * 255,
      b = [p, p, t, v, v, q][mod] * 255;
      
      return [~~r, ~~g, ~~b, "rgb("+ ~~r + "," + ~~g + "," + ~~b + ")"];
  }
  
  function rgbToHex(r, g, b) {
    return "#" + ((1 << 24) + (r << 16) + (g << 8) + b).toString(16).slice(1);
  }
  
  function setBackground(element, color) {
    element.css({
      "background-color" : color
    });
  }
    
  ngColorPicker.directive('ngColorCircle', ['$timeout', function($timeout) {
    return {
      restrict  : 'E',
      replace   : true,
      scope     : '@=',
      template  : '<div>'
      +             '<canvas id="colorCircle">'
      +             '</canvas>'
      +           '</div>',
      compile: function compile(tElement, tAttrs, transclude) {
        return {
          pre: function preLink(scope, iElement, iAttrs, controller) {
            var canvas        = document.getElementById("colorCircle"),
                context       = canvas.getContext('2d'),
                width         = canvas.width = iAttrs.width ||  300,
                height        = canvas.height = iAttrs.height || 300,
                imageData     = context.createImageData(width, height),
                pixels        = imageData.data,
                oneHundred    = 100,
                two55         = 255,
                circleOffset  = 0,
                diameter      = width - circleOffset * 2,
                wheelPixel    = circleOffset * 4 * width + circleOffset * 4;
            
            iElement.css({
              width: width,
              height: height
            });
            
            scope.radius            = diameter / 2;
            scope.radiusPlusOffset  = scope.radius + circleOffset;
            scope.radiusSquared     = scope.radius * scope.radius;

            
            for (y = 0; y < height; y++) {
              for (x = 0; x < width; x++) {
                var rx  = x - scope.radius,
                    ry  = y - scope.radius,
                    d   = rx * rx + ry * ry,
                    rgb = hsvToRgb((Math.atan2(ry, rx) + Math.PI) / (Math.PI * 2),
                          Math.sqrt(d) / scope.radius, 1); 
                
                pixels[wheelPixel++] = rgb[0] - 100 *d /scope.radiusSquared;
                pixels[wheelPixel++] = rgb[1] - 100 * d /scope.radiusSquared;
                pixels[wheelPixel++] = rgb[2] - 100 * d /scope.radiusSquared;
                pixels[wheelPixel++] = 255;
              }
            }
            
            context.putImageData(imageData, 0, 0);
            var strDataURI = canvas.toDataURL("image/jpeg");
            
            Canvas2Image.saveAsBMP(canvas);
          },
          post: function postLink(scope, iElement, iAttrs, controller) { 
            $(iElement).click(function(event) {
              scope.currentX = event.pageX - this.offsetLeft - scope.radiusPlusOffset || scope.currentX;
              scope.currentY = event.pageY - this.offsetTop - scope.radiusPlusOffset || scope.currentY;
              
              var theta = Math.atan2(scope.currentY, scope.currentX),
                  d = scope.currentX * scope.currentX + scope.currentY * scope.currentY;
              
              if (d > scope.radiusSquared) {
                scope.currentX = scope.radius * Math.cos(theta);
                scope.currentY = scope.radius * Math.sin(theta);
                theta = atan2(scope.currentY, scope.currentX);
                d = scope.currentX * scope.currentX + scope.currentY * scope.currentY;
              }
              
              var color = hsvToRgb((theta + Math.PI) / (Math.PI * 2),
                Math.sqrt(d) / scope.radius, 1);
              var hex = rgbToHex(color[0], color[1], color[2]);
              
              $timeout(function(){
                scope.$parent[iAttrs.modelObject][iAttrs.modelProperty] = hex;                
              });
              setBackground($('body'), hex);
            });
          }
        };
      }
    };
  }]);

  ngColorPicker.directive('ngColorPicker', [function() {
    return {
      restrict: 'E',
      replace: true,
      scope : '@=',
      template: '<table>'
      +           '<tr>'
      +           '<td ng-repeat="color in colorList">'
      +             '<div style="width: 8px; height: 8px; border: {{color.select}}px solid #000; padding: 5px; background-color: {{color.color}}" ng-click="selectColor(color)">'
      +             '</div>'
      +           '<td>'
      +           '</tr>'
      +         '</table>',
      compile: function compile(tElement, tAttrs, transclude) {
        return {
          post: function postLink(scope, iElement, iAttrs, controller) { 
            scope.modelObject   = iAttrs.modelObject;
            scope.modelProperty = iAttrs.modelProperty;
            scope.colorList = [];
            angular.forEach(colors, function(color) {
              scope.colorList.push({
                color : color,
                select : 1
              });
            });
          }
        };
      },
      controller: function($scope, $element, $timeout) {
        $scope.selectColor = function(color) {
          for (var i = 0; i < $scope.colorList.length; i++) {
            $scope.colorList[i].select = 1;
            if ($scope.colorList[i] === color) {
              $scope[$scope.modelObject][$scope.modelProperty] = color.color;
              
              setBackground($('body'), color.color);
              
              $scope.colorList[i].select = 2;
            }
          }
        };
      }
    };
  }]);
})(window.angular);

/*
 * Canvas2Image v0.1
 * Copyright (c) 2008 Jacob Seidelin, jseidelin@nihilogic.dk
 * MIT License [http://www.opensource.org/licenses/mit-license.php]
 */

var Canvas2Image = (function() {

	// check if we have canvas support
	var bHasCanvas = false;
	var oCanvas = document.createElement("canvas");
	if (oCanvas.getContext("2d")) {
		bHasCanvas = true;
	}

	// no canvas, bail out.
	if (!bHasCanvas) {
		return {
			saveAsBMP : function(){},
			saveAsPNG : function(){},
			saveAsJPEG : function(){}
		}
	}

	var bHasImageData = !!(oCanvas.getContext("2d").getImageData);
	var bHasDataURL = !!(oCanvas.toDataURL);
	var bHasBase64 = !!(window.btoa);

	var strDownloadMime = "image/octet-stream";

	// ok, we're good
	var readCanvasData = function(oCanvas) {
		var iWidth = parseInt(oCanvas.width);
		var iHeight = parseInt(oCanvas.height);
		return oCanvas.getContext("2d").getImageData(0,0,iWidth,iHeight);
	}

	// base64 encodes either a string or an array of charcodes
	var encodeData = function(data) {
		var strData = "";
		if (typeof data == "string") {
			strData = data;
		} else {
			var aData = data;
			for (var i=0;i<aData.length;i++) {
				strData += String.fromCharCode(aData[i]);
			}
		}
		return btoa(strData);
	}

	// creates a base64 encoded string containing BMP data
	// takes an imagedata object as argument
	var createBMP = function(oData) {
		var aHeader = [];
	
		var iWidth = oData.width;
		var iHeight = oData.height;

		aHeader.push(0x42); // magic 1
		aHeader.push(0x4D); 
	
		var iFileSize = iWidth*iHeight*3 + 54; // total header size = 54 bytes
		aHeader.push(iFileSize % 256); iFileSize = Math.floor(iFileSize / 256);
		aHeader.push(iFileSize % 256); iFileSize = Math.floor(iFileSize / 256);
		aHeader.push(iFileSize % 256); iFileSize = Math.floor(iFileSize / 256);
		aHeader.push(iFileSize % 256);

		aHeader.push(0); // reserved
		aHeader.push(0);
		aHeader.push(0); // reserved
		aHeader.push(0);

		aHeader.push(54); // dataoffset
		aHeader.push(0);
		aHeader.push(0);
		aHeader.push(0);

		var aInfoHeader = [];
		aInfoHeader.push(40); // info header size
		aInfoHeader.push(0);
		aInfoHeader.push(0);
		aInfoHeader.push(0);

		var iImageWidth = iWidth;
		aInfoHeader.push(iImageWidth % 256); iImageWidth = Math.floor(iImageWidth / 256);
		aInfoHeader.push(iImageWidth % 256); iImageWidth = Math.floor(iImageWidth / 256);
		aInfoHeader.push(iImageWidth % 256); iImageWidth = Math.floor(iImageWidth / 256);
		aInfoHeader.push(iImageWidth % 256);
	
		var iImageHeight = iHeight;
		aInfoHeader.push(iImageHeight % 256); iImageHeight = Math.floor(iImageHeight / 256);
		aInfoHeader.push(iImageHeight % 256); iImageHeight = Math.floor(iImageHeight / 256);
		aInfoHeader.push(iImageHeight % 256); iImageHeight = Math.floor(iImageHeight / 256);
		aInfoHeader.push(iImageHeight % 256);
	
		aInfoHeader.push(1); // num of planes
		aInfoHeader.push(0);
	
		aInfoHeader.push(24); // num of bits per pixel
		aInfoHeader.push(0);
	
		aInfoHeader.push(0); // compression = none
		aInfoHeader.push(0);
		aInfoHeader.push(0);
		aInfoHeader.push(0);
	
		var iDataSize = iWidth*iHeight*3; 
		aInfoHeader.push(iDataSize % 256); iDataSize = Math.floor(iDataSize / 256);
		aInfoHeader.push(iDataSize % 256); iDataSize = Math.floor(iDataSize / 256);
		aInfoHeader.push(iDataSize % 256); iDataSize = Math.floor(iDataSize / 256);
		aInfoHeader.push(iDataSize % 256); 
	
		for (var i=0;i<16;i++) {
			aInfoHeader.push(0);	// these bytes not used
		}
	
		var iPadding = (4 - ((iWidth * 3) % 4)) % 4;

		var aImgData = oData.data;

		var strPixelData = "";
		var y = iHeight;
		do {
			var iOffsetY = iWidth*(y-1)*4;
			var strPixelRow = "";
			for (var x=0;x<iWidth;x++) {
				var iOffsetX = 4*x;

				strPixelRow += String.fromCharCode(aImgData[iOffsetY+iOffsetX+2]);
				strPixelRow += String.fromCharCode(aImgData[iOffsetY+iOffsetX+1]);
				strPixelRow += String.fromCharCode(aImgData[iOffsetY+iOffsetX]);
			}
			for (var c=0;c<iPadding;c++) {
				strPixelRow += String.fromCharCode(0);
			}
			strPixelData += strPixelRow;
		} while (--y);

		var strEncoded = encodeData(aHeader.concat(aInfoHeader)) + encodeData(strPixelData);

		return strEncoded;
	}


	// sends the generated file to the client
	var saveFile = function(strData) {
		document.location.href = strData;
	}

	var makeDataURI = function(strData, strMime) {
		return "data:" + strMime + ";base64," + strData;
	}

	// generates a <img> object containing the imagedata
	var makeImageObject = function(strSource) {
		var oImgElement = document.createElement("img");
		oImgElement.src = strSource;
		return oImgElement;
	}

	var scaleCanvas = function(oCanvas, iWidth, iHeight) {
		if (iWidth && iHeight) {
			var oSaveCanvas = document.createElement("canvas");
			oSaveCanvas.width = iWidth;
			oSaveCanvas.height = iHeight;
			oSaveCanvas.style.width = iWidth+"px";
			oSaveCanvas.style.height = iHeight+"px";

			var oSaveCtx = oSaveCanvas.getContext("2d");

			oSaveCtx.drawImage(oCanvas, 0, 0, oCanvas.width, oCanvas.height, 0, 0, iWidth, iHeight);
			return oSaveCanvas;
		}
		return oCanvas;
	}

	return {

		saveAsPNG : function(oCanvas, bReturnImg, iWidth, iHeight) {
			if (!bHasDataURL) {
				return false;
			}
			var oScaledCanvas = scaleCanvas(oCanvas, iWidth, iHeight);
			var strData = oScaledCanvas.toDataURL("image/png");
			if (bReturnImg) {
				return makeImageObject(strData);
			} else {
				saveFile(strData.replace("image/png", strDownloadMime));
			}
			return true;
		},

		saveAsJPEG : function(oCanvas, bReturnImg, iWidth, iHeight) {
			if (!bHasDataURL) {
				return false;
			}

			var oScaledCanvas = scaleCanvas(oCanvas, iWidth, iHeight);
			var strMime = "image/jpeg";
			var strData = oScaledCanvas.toDataURL(strMime);
	
			// check if browser actually supports jpeg by looking for the mime type in the data uri.
			// if not, return false
			if (strData.indexOf(strMime) != 5) {
				return false;
			}

			if (bReturnImg) {
				return makeImageObject(strData);
			} else {
				saveFile(strData.replace(strMime, strDownloadMime));
			}
			return true;
		},

		saveAsBMP : function(oCanvas, bReturnImg, iWidth, iHeight) {
			if (!(bHasImageData && bHasBase64)) {
				return false;
			}

			var oScaledCanvas = scaleCanvas(oCanvas, iWidth, iHeight);

			var oData = readCanvasData(oScaledCanvas);
			var strImgData = createBMP(oData);
			if (bReturnImg) {
				return makeImageObject(makeDataURI(strImgData, "image/bmp"));
			} else {
				saveFile(makeDataURI(strImgData, strDownloadMime));
			}
			return true;
		}
	};

})();