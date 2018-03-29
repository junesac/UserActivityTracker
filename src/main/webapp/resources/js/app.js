'use strict';
var app = angular.module('UserActivitiesTrackerApp', [ 'ngRoute',
		'controllers', 'services' ]);
app.directive('myHeader', function() {
	return {
		restrict : 'E',
		templateUrl : 'resources/pages/header.html'
	};
});
app.config(function($routeProvider) {
	$routeProvider.when('/userActivities', {
		templateUrl : 'resources/pages/userActivities.html',
		controller : 'UserActivitiesController'
	});
	$routeProvider.when('/updateUserActivities/:userActivityId', {
		templateUrl : 'resources/pages/userActivityUpdate.html',
		controller : 'UserActivityUpdateCtrl'
	});
	$routeProvider.when('/users', {
		templateUrl : 'resources/pages/userInfo.html',
		controller : 'UserInfoController'
	});
	$routeProvider.when('/updateUserInfo/:userId', {
		templateUrl : 'resources/pages/userInfoUpdate.html',
		controller : 'UserUpdateControlller'
	});
	$routeProvider.when('/home', {
		templateUrl : 'resources/pages/homePage.html',
		controller : 'HomeController'
	});

	$routeProvider.when('/login', {
		templateUrl : 'resources/pages/login.html',
		controller : 'LoginController'
	});
//	$routeProvider.when('/', {
//		redirectTo : '/login'
//	});
//	$routeProvider.otherwise({
//		redirectTo : '/login'
//	});
});
