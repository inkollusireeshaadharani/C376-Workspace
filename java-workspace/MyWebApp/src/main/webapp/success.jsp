<%@ page language="java" contentType="text/html;charset=ISO-8859-1" pageEncoding="ISO-8859-1" 
import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success page</title>
</head>
<body>

<% String name = (String)request.getAttribute("myname"); %>
<%=name %>
<%=application.getAttribute("myname") %>
<%=config.getInitParameter("myname") %>
<h2>Auth successful</h2>
<h2>Welcome <%=session.getAttribute("uname") %></h2>
</body>
</html>