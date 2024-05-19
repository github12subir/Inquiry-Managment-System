<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h4>Home Page</h4>
	<%
		if(request.getAttribute("LoginMsg")!=null){
			out.println(request.getAttribute("LoginMsg"));
		}	
	%>
	
	<%
		if(request.getAttribute("AddMsg")!=null){
			out.println(request.getAttribute("AddMsg"));
		}	
	%>
	
	<pre>
		<a href="addInquiry"> AddInquiry</a>
		<br>
		<a href="viewInquiry"> ViewInquiry</a>
						
	</pre>
	<br>
	<form action="logout" method="post">
		<input type="submit" value="logout"/>
	  </form>
</body>
</html>