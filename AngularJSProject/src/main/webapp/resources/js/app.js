var mainApp = angular.module('mainApp',['ngRoute']);

mainApp.config(['$routeProvider', function($routeProvider){
	$routeProvider.
		when('/addStudent', {
			templateUrl : 'addStudent.jsp',
			controller : 'AddStudentController'
		}).
		when('/viewStudent', {
			templateUrl : 'viewStudent.jsp',
			controller : 'ViewStudentController'
		}).
		when('/modifyStudent', {
			templateUrl : 'modifyStudent.jsp',
			controller : 'ModifyStudentController'
		});
}]);