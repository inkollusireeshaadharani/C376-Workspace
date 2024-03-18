<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- http://localhost:8080/MyWebApp/counter.jsp --%>

<%!int counter=0;
List<String> list = new ArrayList<>();
public String sayHello(String name){
	return "welcome "+name;
}
%>
<%
counter++;
%>
<h2>U r visitor <%=counter %></h2>
<%=sayHello("Dharani") %>
</body>
</html>