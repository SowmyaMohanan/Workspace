<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
<script src="<spring:url value='/resources/js/app.js' />"></script>
<script src="<spring:url value='/resources/js/service/studentService.js' />"></script>
<script src="<spring:url value='/resources/js/controller/studentController.js' />"></script>
<link rel = "stylesheet" href = "<spring:url value='/resources/css/style.css' />">
</head>
<body ng-app = "mainApp">

<h2> Student Information Form</h2>
<div ng-controller = "StudentController as ctrl">
         
         <form name = "studentForm">
         <input type="hidden" ng-model = "ctrl.note">
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
                     <input type=button value="{{!ctrl.note ? 'Add New' : 'Update'}}" ng-click="ctrl.submit()">
                     <input type="reset" ng-click="ctrl.reset()" value = "Reset Details">
                  </td>
               </tr>
					
            </table>
         </form>
     

<br>
<br>
<div>
<h2>Student Details</h2>
<table id="studDetails">
			<thead>
				<tr>
					<th>Name</th>
					<th>Age</th>
					<th>Id</th>
					<th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="stud in ctrl.students">
					<td>{{stud.name}}</td>
					<td>{{stud.age}}</td>
					<td>{{stud.id}}</td>
					<td><button  ng-click="ctrl.remove(stud)">Remove</button>&nbsp;&nbsp;<button  ng-click="ctrl.edit(stud.id)">Modify</button></td>
				</tr>
			</tbody>
		</table>
</div>

 </div>
</body>
</html>