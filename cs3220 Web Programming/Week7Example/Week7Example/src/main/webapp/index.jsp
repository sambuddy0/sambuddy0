<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet Example</title>
</head>
<body>
<% 
	if (request.getAttribute("message") == null || request.getAttribute("message") == "") {
%>
	<!--  -->
	<h2>There is no message</h2>
<%
	}
	out.println(request.getAttribute("message"));
%>
<ul>
    <li><a href="HelloServlet">HelloServlet</a></li>
</ul>
</body>
</html>