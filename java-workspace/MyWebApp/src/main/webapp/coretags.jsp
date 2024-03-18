<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://com.wileyedge.hello" prefix="h" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:out value="Welcome to Standard Tags"></c:out>
<br>
<%-- can have same variable in different scope --%>
<c:set var="salary" scope="session" value="${4000*12}" ></c:set>
<c:set var="salary" scope="request" value="${3000*12}"></c:set>
<%-- implicit scope objects --%>
<c:out value="${requestScope.salary}"></c:out>
<c:out value="${sessionScope.salary}"></c:out>
<br>
<c:remove var="salary" scope="request"/> 
<br>
After removal of value : <c:out value="${salary}"/>
<br>
<c:catch var ="myException">  
   <% int x = 2/0;%>  
</c:catch>
<c:if test="${myException != null}">  
   <p>The type of exception is : ${myException} <br />  
   There is an exception: ${myException.message}</p>  
</c:if>
<c:forEach begin="1" end="10" step="2"  var="myValue">
	<c:out value="${myValue}"></c:out>
</c:forEach>
<br>
<h:hello name="Sekhar">  </h:hello><br>
<h:hello name="Dharan">  </h:hello><br>
<h:hello name="Deepak">  </h:hello><br>
<h:hello name="Saru">  </h:hello><br>
</body>
</html>








