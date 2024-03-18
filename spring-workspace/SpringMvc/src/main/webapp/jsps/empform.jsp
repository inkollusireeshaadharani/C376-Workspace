<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form</title>
<style>
	input{
		display: block;
	}
</style>
</head>
<body>
	<h2>Employee Registration Form</h2>
	<a href="changeLocale.htm?lang=en">English</a>
	<a href="changeLocale.htm?lang=es">Spanish</a>
<%-- 	<form action="saveemp.htm" method="POST"> --%>
<!-- 		<br/> -->
<!-- 		ID: <input type="text" name="eid"/> <br/> -->
<!-- 		FirstName: <input type="text" name="fname"/> <br/> -->
<!-- 		LastName: <input type="text" name="lname"/> <br/> -->
<!-- 		<input type="submit" value="Save Employee"/> <br/> -->
<%-- 	</form> --%>

	<f:form action="saveemp.htm" method="POST" modelAttribute="emp">
		<s:message code="emp.id"/> <f:input path="eid" /> <f:errors path="eid"></f:errors><br>
		<s:message code="emp.fname"/> <f:input path="fname" /> <f:errors path="fname"></f:errors><br>
		<s:message code="emp.lname"/> <f:input path="lname" /> <f:errors path="lname"></f:errors><br>
		<input type="submit" value="submit">
	</f:form>


</body>
</html>