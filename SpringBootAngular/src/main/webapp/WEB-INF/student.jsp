<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
<script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular-route.min.js"></script>

<script src="<c:url value='/resources/js/app.js' />"></script>
<script src="<c:url value='/resources/js/controller/Controller.js' />"></script>
<script src="<c:url value='/resources/js/service/studentService.js' />"></script>
<link rel = "stylesheet" href = "<c:url value='/resources/css/style.css' />">
</head>
<body ng-app = "mainApp">

<h2>Student Details</h2>

<a href="#addStudent">Add Student</a>
<a href="#viewStudent">View Student</a>
<!-- <a href="#googleMap">Google Map</a> -->
<br>
<div ng-view></div>

</body>
</html>