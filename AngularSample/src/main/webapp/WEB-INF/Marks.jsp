<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
fieldset div{
	height: 25px;
}
fieldset{
	border: black solid thin;
	width: 500px;
}
</style>
</head>
<body ng-app = "mainApp">

<div ng-controller = "MarksController as m">
<form id="studentForm" name="studentForm">

	<fieldset>
		<legend>Student Form</legend>
		<div>
			<label> Student Name</label>
			<input name="studname" type="text" ng-model="m.studname" required>
			<span ng-show="studentForm.studname.$touched && studentForm.studname.$invalid">The Student name is required.</span>
		</div>
		<div>
			<label>Marks1</label>
			<input name="marks1" ng-model="m.marks1" type="number" required>
			<span ng-show="studentForm.marks1.$touched && studentForm.marks1.$invalid">The Mark1 is required.</span>
		</div>
		<div>
			<label>Marks2</label>
			<input name="marks2" ng-model="m.marks2" type="number" required>
			<span ng-show="studentForm.marks2.$touched && studentForm.marks2.$invalid">The Mark2 is required.</span>
		</div>
		<div>
			<label>Marks3</label>
			<input name="marks3" ng-model="m.marks3" type="number" required>
			<span ng-show="studentForm.marks3.$touched && studentForm.marks3.$invalid">The Mark3 is required.</span>
		</div>	
		<div>
		<input type="button" ng-click="m.calculateAvg()" value="Calculate"
		ng-disabled="studentForm.$pristine || (studentForm.marks3.$invalid || studentForm.studname.$invalid 
		|| studentForm.marks1.$invalid || studentForm.marks2.$invalid) ">
		</div>
	</fieldset>
	
				
</form>
<br><br><br>
<!-- <div>
Student Name: {{m.studname}} <br>

Marks1: {{m.marks1}} <br>

Marks2: {{m.marks2}} <br>

Marks3: {{m.marks3}} <br>

Average: {{ (m.marks1 + m.marks2 + m.marks3 ) / 3 }}
</div> -->

<div>
Student Name: {{m.studname}} <br>

Marks1: {{m.marks1}} <br>

Marks2: {{m.marks2}} <br>

Marks3: {{m.marks3}} <br>

Average: {{ m.avg }}
</div>

</div>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>

<script src="<s:url value='/app/app.js' />"></script>


</body>
</html>