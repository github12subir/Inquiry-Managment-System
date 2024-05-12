<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Details</title>
</head>
<body>
	
	<h2>Enter Student Details</h2>
	
	
	<%
		if(request.getAttribute("Update")!=null){
			out.println(request.getAttribute("Update"));
		}	
	%>
	
	<form action="addEnquiry" method="post">
	
		<pre>
		
			Name<input type="text" name="name"/>
			Email<input type="text" name="email"/>
			phNumber<input type="text" name="phNumber"/>
			Course<input type="text" name="course"/>
			<input type="submit" value="AddEnquery"/>
		
		</pre>
	
	</form>
	
	 <jsp:include page="delete_Enquiry.jsp" />
	
</body>
</html>