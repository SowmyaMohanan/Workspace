
mainApp.service('StudentService', ['$http', '$q' , function($http,$q){
		
	var data = [];
	
	this.setData = function (content) {
		data=content;		
	}	
	
	this.getData = function () {
		return data;		
	}	
	
	this.fetchAllStudents = function () {
        var deferred = $q.defer();
        $http.get('admin/allStudent').then(
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
 
    this.createStudent = function (student) {
        var deferred = $q.defer();
        $http.post('admin/addStudent', student)
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
	
    this.deleteStudent = function (stud){
    	var deferred = $q.defer();
        $http.delete('admin/deleteStudent/'+stud.id).then(
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
    
    this.updateStudent = function (stud, id){
    	var deferred = $q.defer();
        $http.put('admin/modifyStudent/'+id, stud).then(
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