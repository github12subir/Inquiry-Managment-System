<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Details</title>
</head>
<body>
	
	<h2>Update Student Details</h2>
	<%
		if(request.getAttribute("Delete")!=null){
			out.println(request.getAttribute("Delete"));
		}	
	%>
	
	<form action="updateEnquiry" method="post">
	
		<pre>
					
			Email<input type="text" name="email"/>
			phNumber<input type="text" name="phNumber"/>
			<input type="submit" value="UpdateEnquiry"/>
		
		</pre>
		
	</form>
</body>
</html>