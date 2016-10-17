
mainApp.factory('StudentService', ['$http', '$q' , function($http,$q){
	
	var factory = {
	        fetchAllStudents: fetchAllStudents,
	        createStudent: createStudent,
	        updateStudent:updateStudent,
	       deleteStudent:deleteStudent
	    };
	
	return factory;
	
	function fetchAllStudents() {
        var deferred = $q.defer();
        $http.get('addStudent').then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResp){
                console.error('Error while fetching Students');
                deferred.reject(errResp);
            }
        );
        return deferred.promise;
    }
 
    function createStudent(student) {
        var deferred = $q.defer();
        $http.post('addStudent', student)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResp){
                console.error('Error while creating Student');
                deferred.reject(errResp);
            }
        );
        return deferred.promise;
    }
	
    function deleteStudent(stud){
    	var deferred = $q.defer();
        $http.delete('addStudent/'+stud.id).then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResp){
                console.error('Error while deleting Student');
                deferred.reject(errResp);
            }
        );
        return deferred.promise;
    }
    
    function updateStudent(stud, id){
    	var deferred = $q.defer();
        $http.put('addStudent/'+id, stud).then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResp){
                console.error('Error while editing Student');
                deferred.reject(errResp);
            }
        );
        return deferred.promise;
    }
    
    
}]);