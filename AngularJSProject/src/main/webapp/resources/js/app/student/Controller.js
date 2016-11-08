mainApp.controller('AddStudentController',[ '$scope','StudentService', function($scope, StudentService){
	var ctrl = this;
	ctrl.student = {name:'',age:null,id:null};
	
		ctrl.submitDetails = function() {
            	StudentService.createStudent(ctrl.student).then(
				function(data){
					console.log('creating Student successfully');
				},
                function(errResponse){
                    console.error('Error while creating Student');
                });
                ctrl.resetDetails();
            }
			
			ctrl.resetDetails=function(){
                ctrl.student={name:'',age:null,id:null};
                $scope.studentForm.$setPristine(); //reset Form                
            }
			
						
}]);


mainApp.controller('ViewStudentController',[ '$scope','StudentService', function($scope, StudentService){
	var view = this;
	view.students = [];
	
	fetchAllStudents();
	
	 function fetchAllStudents(){
    	StudentService.fetchAllStudents().then(
         function(data) {
        	 view.students = data;
         },
         function(errResp){
             console.error('Error while fetching Students');
         }
     );
    }
	 
	 view.edit = function(id,stud){
		 StudentService.setData(stud);
	 }
	 
	 view.removeDetails = function(stud) {
     	StudentService.deleteStudent(stud).then(
			function(data){
				view.students = data;
				console.log('delete Student successfully');
			},
         function(errResponse){
             console.error('Error while deleting Student');
         });
         
     }
}]);


mainApp.controller('ModifyStudentController',[ '$scope','StudentService', function($scope, StudentService){
	var ctrl = this;
	ctrl.student = {name:'',age:null,id:null};
	
	fetchModifyData();			
			
		function fetchModifyData(){
			var data = StudentService.getData();
			ctrl.student.name = data.name;
			ctrl.student.age = data.age;
			ctrl.student.id = data.id;
		}
		
		ctrl.updateDetails = function() {
        	StudentService.updateStudent(ctrl.student,ctrl.student.id).then(
			function(data){
				console.log('updating Student successfully');
			},
            function(errResponse){
                console.error('Error while updating Student');
            });
        	ctrl.student={name:'',age:null,id:null};
            $scope.studentForm.$setPristine();
        }
}]);