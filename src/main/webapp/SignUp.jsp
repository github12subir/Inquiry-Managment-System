<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp</title>
</head>
<body>
	
	<h2>SignUp Here</h2>
	
	<%
		if(request.getAttribute("error")!=null){
			out.println(request.getAttribute("error"));
		}	
	%>
	
	<form action="signup" method="post">
	
		Email<input type="text" name="email"/>
		Password<input type="password" name="password"/>
		<input type="submit" value="SignUp"/>
	
	</form>
	
	<jsp:include page="login.jsp"/>
	
</body>
</html>