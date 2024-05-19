<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Login Here</h2>
	
	<%
		if(request.getAttribute("LogOutMsg")!=null){
			out.println(request.getAttribute("LogOutMsg"));
		}	
	%>
	
	<%
		if(request.getAttribute("LoginMsg")!=null){
			out.println(request.getAttribute("LoginMsg"));
		}	
	%>
	
	<form action="verifyLogin" method="post">
	
		Email<input type="text" name="email"/>
		Password<input type="password" name="password"/>
		<input type="submit" value="login"/>
		
	</form>
</body>
</html>