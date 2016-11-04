<div ng-controller="AddStudentController as ctrl">
	<form name = "studentForm">
         
            <table border = "0" class="studentry">
               <tr>
                  <td>Enter name:</td>
                  <td><input name = "name" type = "text" ng-model = "ctrl.student.name" >                     
                  </td>
               </tr>
               
               <tr>
                  <td>Enter Age: </td>
                  <td><input name = "age"  type = "text" ng-model = "ctrl.student.age" >                     
                  </td>
               </tr>
               
               <tr>
                  <td>Enter Id: </td>
                  <td><input name = "id"  type = "text" ng-model = "ctrl.student.id" ng-readonly = "ctrl.readonly" >
                     
                  </td>
               </tr>
               
               <tr>               
                  <td colspan = "2">
                     <input type=button value="'Add New'" ng-click="ctrl.submit()">
                     <input type="reset" ng-click="ctrl.reset()" value = "Reset Details">
                  </td>
               </tr>
					
            </table>
         </form>

</div>