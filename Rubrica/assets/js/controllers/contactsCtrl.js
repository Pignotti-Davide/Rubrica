var app = angular.module("myApp");
var contactsCtrl=app.controller("contactsCtrl", function($scope, contactsService){
	$scope.newContact;
	$scope.activeContact;
	$scope.contacts=contactsService.getContacts();
	
	$scope.setActiveContact=function(num){
		$scope.activeContact=num;
	};
	
	$scope.updateContact=function(){
		contactsService.updateContact($scope.contacts[activeContact]);{
			
		};
	};
	
	$scope.saveContact=function(){
		var jsonToPersist = angular.toJson($scope.newContact);
		contactsService.saveContact(jsonToPersist);
	}
});