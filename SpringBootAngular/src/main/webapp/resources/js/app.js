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
		/*when('/googleMap', {
			templateUrl : 'map.jsp',
			controller : 'MapController'
		}).*/
		when('/modifyStudent', {
			templateUrl : 'modifyStudent.jsp',
			controller : 'ModifyStudentController'
		});
}]);