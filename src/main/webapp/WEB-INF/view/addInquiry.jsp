<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ include  file="home.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Details</title>
</head>
<body>
	
	<h2>Enter Student Details</h2>		
	<%
		if(request.getAttribute("AddMsg")!=null){
			out.println(request.getAttribute("AddMsg"));
		}	
	%>
	
	<form action="addInquiry" method="post">
	
		<pre>
		
			Name<input type="text" name="name"/>
			Email<input type="text" name="email"/>
			phNumber<input type="text" name="phNumber"/>
			Course<input type="text" name="course"/>
			<input type="submit" value="AddInquery"/>
		
		</pre>
	
	</form>
</body>
</html>