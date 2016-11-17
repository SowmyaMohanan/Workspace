var mainApp = angular.module('mainApp',[]);

mainApp.service('MarksService', function(){
	var serv = this;
	
	serv.calculateAvg = function(m1, m2, m3){
		return ((m1+m2+m3)/3);
	}
		
}); 

mainApp.controller('MarksController',['$scope', 'MarksService', function($scope, MarksService){
	var ctrl = this;
	
	ctrl.studname = '';
	ctrl.marks1 = null;
	ctrl.marks2 = null;
	ctrl.marks3 = null;
	ctrl.avg = null;
	
	ctrl.calculateAvg = function(){
		ctrl.avg = MarksService.calculateAvg(ctrl.marks1, ctrl.marks2, ctrl.marks3);
	}
		
}]);


