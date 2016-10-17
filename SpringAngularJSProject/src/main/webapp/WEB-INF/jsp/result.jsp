<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Submitted Student Information</h2>
	
   <table border=1>
    <tr>
        <td>Name</td>
        <td>Age</td>
        <td>ID</td>        
    </tr>
	<c:forEach items="${studObj}" var = "stud">
    <tr>
        <td><c:out value = "${stud.getName() }"></c:out></td>
        <td><c:out value = "${stud.getAge() }"></c:out></td>
         <td><c:out value = "${stud.getId() }"></c:out></td>
    </tr>
    </c:forEach>
</table> 
 
</body>
</html>