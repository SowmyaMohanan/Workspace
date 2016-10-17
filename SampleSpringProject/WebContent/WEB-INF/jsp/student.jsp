<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script type='text/javascript'>
$(document).ready(function(){
	$(document).on('click', '#submitForm', function(event){
      event.preventDefault();
      var $form = $("#studentForm");
      
      $.ajax({
    	     type: $form.attr('method'),
    	     url: $form.attr('action'),
    	     data:$form.serialize(),
    	     success: function(jsondata){
    				var $table = $("<table border='2' class='table'>").appendTo($("#result")); 
    				$("<tr>").appendTo($table)
    				         .append($("<td>").text("NAME"))
    				         .append($("<td>").text("AGE"))
    						 .append($("<td>").text("ID"));
    				$("</tr>").appendTo($table);
    				var studDetails = JSON.parse(jsondata);
    				$.each(studDetails, function(index, stud) {   
    		            $("<tr>").appendTo($table)
    		            		.append($("<td>").text(stud.name))
    		                	.append($("<td>").text(stud.age))
    		            		.append($("<td>").text(stud.id));
    		            $("</tr>").appendTo($table);
    		        });
    			},
    			error: function(){
    				$('#result').html("Exception!!");
    			}
    });
 });
});
</script>
</head>
<body>
<h2>Student Information</h2>
<form:form id="studentForm" method="POST" action="addStudent">
   <table>
    <tr>
        <td><form:label path="name">Name</form:label></td>
        <td><form:input path="name" /></td>
    </tr>
    <tr>
        <td><form:label path="age">Age</form:label></td>
        <td><form:input path="age" /></td>
    </tr>
    <tr>
        <td><form:label path="id">id</form:label></td>
        <td><form:input path="id" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="button" value="Submit" id="submitForm"/>
        </td>
    </tr>
</table>  
</form:form>
<br>
<br>
<div id = "result">

</div>

</body>
</html>