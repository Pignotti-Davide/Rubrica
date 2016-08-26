var app = angular.module("myApp");
var indexCtrl=app.controller("indexCtrl", function($scope){
	
	$scope.adapt=function(){
		$("#flipbook").css({
			width: 2*$("#flipbook").parent().width(),
			left: "-"+$('#flipbook').width()/2+"px",
		});
	}

});

$("#flipbook").turn({
	width: 2*$("#flipbook").parent().width(),
	autoCenter: false
});
$("#flipbook").css({
	left: "-"+$('#flipbook').width()/2+"px"
});


