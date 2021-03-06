mainApp.controller('AddStudentController',[ '$scope','StudentService', function($scope, StudentService){
	var ctrl = this;
	ctrl.student = {name:'',age:null,id:null};
	ctrl.msg = '';
	
		ctrl.submitDetails = function() {
            	StudentService.createStudent(ctrl.student).then(
				function(data){
					ctrl.msg = 'Student Added Successfully';
					console.log('creating Student successfully');
				},
                function(errResponse){
                    console.error('Error while creating Student');
                });
            	ctrl.student={name:'',age:null,id:null};
            }
			
			ctrl.resetDetails=function(){
                ctrl.student={name:'',age:null,id:null};
                $scope.studentForm.$setPristine(); //reset Form
                ctrl.msg = '';
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
	
	handleEvent();			
			
		function handleEvent(){
			ctrl.student.name = StudentService.data.name;
			ctrl.student.age = StudentService.data.age;
			ctrl.student.id = StudentService.data.id;
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