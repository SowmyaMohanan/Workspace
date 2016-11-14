<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel = "stylesheet" href="<s:url value='/resources/css/style.css' /> ">
<title>Insert title here</title>
</head>
<body ng-app="myapp">
Welcome 
<a href="#d3">D3 Chart</a>


<script type="text/javascript" src="http://d3js.org/d3.v3.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
<script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular-route.min.js"></script>
<script src="<s:url value='/app/reusable_chart.js' /> "></script>

<script type="text/javascript" src="<s:url value='/app/app.js' /> "> </script>

</body>
</html>