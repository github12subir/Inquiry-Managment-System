

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>homePage.jsp</p>
	<h2>
		Welcome
		<%
	if (request.getAttribute("userCode") != null) {
		out.println(request.getAttribute("userCode"));
	}
	%>
	</h2>

<a href="addEnquiry.jsp"> AddEnquiry</a>

</body>
</html>