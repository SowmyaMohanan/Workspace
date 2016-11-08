var mainApp = angular.module('mainApp',['ngRoute']);

mainApp.config(['$routeProvider', function($routeProvider){
	$routeProvider.
		when('/addStudent', {
			templateUrl : 'addStudent.jsp',
			controller : 'AddStudentController',
			controllerAs : 'ctrl'
		}).
		when('/viewStudent', {
			templateUrl : 'viewStudent.jsp',
			controller : 'ViewStudentController',
			controllerAs : 'view'
		}).
		when('/modifyStudent', {
			templateUrl : 'modifyStudent.jsp',
			controller : 'ModifyStudentController',
			controllerAs : 'modify'
		});
}]);