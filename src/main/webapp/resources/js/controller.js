'use strict';

var app = angular.module('controllers', []);

app.controller('HomeController', function($scope) {
	$scope.header = 'Welcome to Home Page';
});

app.controller('UserActivitiesController', function($scope, $http) {

	var baseUrl = 'http://localhost:9999/UserActivityTracker/ws/userActivity';
	$scope.header = 'Manage your Activities';

	
	$scope.remove = function(uaId){
        $http.delete(baseUrl + '/deleteUserActivity/' + uaId)
		.then(function(response) {
			console.log('Acivity deleted Successfully!!!');
			$scope.loadAllActivities();
		});
        
    };
	
	$scope.loadAllActivities = function() {
		var filter = {};
		$http.post(baseUrl + '/getUserActivities', filter).then(function(response) {
			$scope.userActivities = response.data;
			console.log('response.data' + response.data);
		});
	}
	$scope.loadAllActivities();
	
	$scope.filterData = function() {

		if($scope.filter.fromDate == "") {
			$scope.filter.fromDate = null;
		}
		
		if($scope.filter.toDate == "") {
			$scope.filter.toDate = null;
		}
		
		if($scope.filter.fromTime == "") {
			$scope.filter.fromTime = null;
		}
		
		if($scope.filter.toTime == "") {
			$scope.filter.toTime = null;
		}
		
		$http.post(baseUrl + '/getUserActivities', $scope.filter).then(function(response) {
			$scope.userActivities = response.data;
			console.log('response.data' + response.data);
		});
		
	}

	
	$scope.addUserActivity = function() {
		console.log('adding user activity : ' + $scope.name + ' '
				+ $scope.calories);
		
		if($scope.uaName == null || $scope.uaName === '') {
			swal('Please enter The activity name.');
		} 
		else if( $scope.calories == null || $scope.calories === '') {
			swal('Please enter calories.');
		}
		else if( $scope.date == null || $scope.date === '') {
			swal('Please enter the valid date.');
		}
		else{
			
			var userActivity = {};
			userActivity.uaName = $scope.uaName;
			userActivity.calories = $scope.calories;
			userActivity.startDate = $scope.date;
			userActivity.time = $scope.time;
			userActivity.userId = 1;

			
			$http.post(baseUrl + '/createUserActivity', userActivity)
			.then(function(response) {
				console.log('Acivity Added Successfully!!!');
				$scope.loadAllActivities();
			});
			$scope.uaName = '';
			$scope.calories = '';
			$scope.date = '';
			 $scope.time = '';
			console.log($scope.userActivities);

		}
		

	};

});

app.controller('UserActivityUpdateCtrl', function($scope, $routeParams, $location, $http){
	var baseUrl = 'http://localhost:9999/UserActivityTracker/ws/userActivity';
	var id = $routeParams.userActivityId;
	
	$http.get(baseUrl + '/getUserActivitiesByUserId/' + id).then(function(response) {
		$scope.userActivity = response.data;
		console.log('response.data' + response.data);
	});
	
	console.log('id to update : ' + id);
	$scope.update = function(){
		$http.put(baseUrl + '/updateUserActivity/' + id, $scope.userActivity)
		.then(function(response) {
			console.log('Acivity Updated Successfully!!!');
			$location.path("/userActivities" );
		});
	};
});

/**
 * 
 * User Info started here
 * 
 */

app.controller('UserInfoController', function($scope, $http) {

	var baseUrl = 'http://localhost:9999/UserActivityTracker/ws/userInfo';
	var baseUrlForRoles = 'http://localhost:9999/UserActivityTracker/ws/role';
	$scope.header = 'Manage Users';

	$scope.loadAllUsers = function() {
		$http.get(baseUrl + '/getAllUsers').then(function(response) {
			$scope.users = response.data;
			console.log('response.data' + response.data);
		});
	}
	$scope.loadAllUsers();

	$scope.loadAllRoles = function() {
		$http.get(baseUrlForRoles + '/getAllRoles').then(function(response) {
			$scope.roles = response.data;
			console.log('Roles: ' + response.data);
		});
	}
	$scope.loadAllRoles();

	
	$scope.selectedRole = 1;
	
	$scope.remove = function(userId){
        $http.delete(baseUrl + '/deleteUser/' + userId)
		.then(function(response) {
			console.log('User deleted Successfully!!!');
			$scope.loadAllUsers();
		});
        
    };
	
	$scope.addUser = function() {
		console.log('adding user with : ' + $scope.userName + ' '
				+ $scope.password);
		
		
		if($scope.userName == null || $scope.userName === '') {
			swal('Please enter The username name.');
		} 
		else if( $scope.password == null || $scope.password === '') {
			swal('Please enter password.');
		}
		else if( $scope.selectedRole == null || $scope.selectedRole === '') {
			swal('Please Select a Role.');
		}
		else{ 
			var user = {};
			user.userName = $scope.userName;
			user.password = $scope.password;
			user.rId = $scope.selectedRole;

			$http.post(baseUrl + '/createUser', user)
			.then(function(response) {
				console.log('User Added Successfully!!!');
				$scope.loadAllUsers();
			});

			$scope.userName = '';
			$scope.password = '';
			$scope.selectedRole = '';
			console.log($scope.users);
		}
	};
});


app.controller('UserUpdateControlller', function($scope, $routeParams, $location, $http){
	var baseUrl = 'http://localhost:9999/UserActivityTracker/ws/userInfo';
	var baseUrlForRoles = 'http://localhost:9999/UserActivityTracker/ws/role';
	var id = $routeParams.userId;
	
	$scope.loadAllRoles = function() {
		$http.get(baseUrlForRoles + '/getAllRoles').then(function(response) {
			$scope.roles = response.data;
			console.log('Roles: ' + response.data);
		});
	}
	$scope.loadAllRoles();
	
	$http.get(baseUrl + '/getUserByUserId/' + id).then(function(response) {
		$scope.user = response.data;
		$scope.selectedRole = $scope.user.rId;
		console.log('response.data' + response.data);
	});
	
	console.log('id to update : ' + id);
	$scope.update = function(){
		$scope.user.rId = $scope.selectedRole;
		$http.put(baseUrl + '/updateUser/' + id, $scope.user)
		.then(function(response) {
			console.log('User Updated Successfully!!!');
			$location.path("/users" );
		});
	};
});
