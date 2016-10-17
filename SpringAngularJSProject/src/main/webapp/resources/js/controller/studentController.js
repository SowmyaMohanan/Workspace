        
         mainApp.controller('StudentController', [ '$scope', 'StudentService', function($scope, StudentService) {
        	 var controller = this;
        	 
        	 controller.student = {name:'',age:null,id:null};
        	 controller.students = [];
            
        	 controller.note = '';
        	 
        	 controller.readonly = false;
        	 
        	 controller.submit = submitDetails;
            controller.edit = editDetails;
            controller.remove = removeDetails;
        	 controller.reset = resetDetails;
                     
            fetchAllStudents();
            
            function fetchAllStudents(){
            	StudentService.fetchAllStudents().then(
                 function(data) {
                	 controller.students = data;
                 },
                 function(errResp){
                     console.error('Error while fetching Students');
                 }
             );
            }
            
            function submitDetails() {
            	if(controller.student.id != null){
            		if(controller.note===''){
            			console.log('Saving New Student', controller.student);
            			createStudent(controller.student);
            		}else{
            			updateStudent(controller.student, controller.student.id);
            			console.log('Student updated with id ', controller.student.id);
            		}
            	}
                resetDetails();
            }
            
            function createStudent(student) {
                console.log('Saving New Student', student);
                StudentService.createStudent(student).then(fetchAllStudents,
                function(errResponse){
                    console.error('Error while creating Student');
                });
                resetDetails();
            }
            
            function resetDetails(){
                controller.student={name:'',age:null,id:null};
                $scope.studentForm.$setPristine(); //reset Form
                controller.note = '';
                controller.readonly = false;
            }
            
            function removeDetails(stud){
            	console.log('Deleting a Student', stud);
                StudentService.deleteStudent(stud).then(fetchAllStudents,
                function(errResponse){
                    console.error('Error while deleting Student');
                });
                resetDetails();
            }
            
            function editDetails(id){
            	console.log('id to be edited', id);
                for(var i = 0; i < controller.students.length; i++){
                    if(controller.students[i].id === id) {
                        controller.student = angular.copy(controller.students[i]);
                        controller.note = 'modify';
                        controller.readonly = true;
                        break;
                    }
                }
            }
            
            function updateStudent(stud, id){
            	console.log('Updating a Student', stud);
                StudentService.updateStudent(stud, id).then(fetchAllStudents,
                function(errResponse){
                    console.error('Error while deleting Student');
                });
                resetDetails();
            }
            
            
         }]);