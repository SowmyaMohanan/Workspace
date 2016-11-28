var mainApp = angular.module('mainApp',[]);

mainApp.service('MarksService', function(){
	var serv = this;
	
	serv.arr = [];
	
	serv.save = function(data){
		serv.arr.push({			
		name: data.studname,
		m1: data.marks1,
		m2 : data.marks2,
		m3 : data.marks3,
		aveg : data.avg
		});
		return serv.arr;
	}
			
}); 

mainApp.controller('MarksController',['$scope', 'MarksService', function($scope, MarksService){
	var ctrl = this;
	
	ctrl.studname = '';
	ctrl.marks1 = null;
	ctrl.marks2 = null;
	ctrl.marks3 = null;
	ctrl.avg = null;
	ctrl.studs = [];
	
	ctrl.save = function(form){
		ctrl.studs = MarksService.save(ctrl);
		ctrl.studname = '';
		ctrl.marks1 = null;
		ctrl.marks2 = null;
		ctrl.marks3 = null;
		ctrl.avg = null;
		form.$setUntouched();
	}
		
}]);




