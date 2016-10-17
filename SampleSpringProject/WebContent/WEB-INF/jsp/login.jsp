<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form method = "POST" action = "check" modelAttribute="login">
	<h2>Login Details </h2>
	<table>
	<tr>
		<td>Username : </td><td><form:input path = "username"/> </td>
	</tr>
	<tr>
		<td>Password : </td><td><form:password path = "password"/> </td>
	</tr>
	<tr>
	 <td colspan="2"><input type="submit" value="Login" id="loginForm"/> </td>
	 </tr>
	</table>
</form:form>
</body>
</html>