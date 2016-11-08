<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body ng-app = "mainApp">

<h2>Student Details</h2>

<a href="#addStudent">Add Student</a>
<a href="#viewStudent">View Student</a>
<br>
<div ng-view></div>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
<script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular-route.min.js"></script>

<script src="<s:url value='/resources/js/app/app.js' />"></script>
<script src="<s:url value='/resources/js/app/student/Controller.js' />"></script>
<script src="<s:url value='/resources/js/app/student/studentService.js' />"></script>

<link rel = "stylesheet" href = "<s:url value='/resources/css/style.css' />">

</body>
</html>