<div ng-controller="ModifyStudentController as ctrl">
	<form name = "studentForm">
         
            <div class="studentry">
			<div>
               	<label>Enter name:</label>
                  <input class="input1" name = "name" type = "text" ng-model = "ctrl.student.name" >                     
            </div>
			<div>			 
                  <label>Enter Age: </label>
                  <input class="input2" name = "age"  type = "text" ng-model = "ctrl.student.age" >                     
			</div>
			<div>
                  <label>Enter Id: </label>
                  <input class="input3" name = "id"  type = "text" ng-model = "ctrl.student.id" ng-readonly = "true" >
             </div>
			<div class = "buttons">
                     <input type=button value="Update" ng-click="ctrl.updateDetails()">
                    
                 </div>
				 </div>
         </form>

</div>