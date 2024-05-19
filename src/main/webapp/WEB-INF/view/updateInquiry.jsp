<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h2>Update Student Details</h2>
	<form action="updateInquiry" method="post">
	
		<pre>
					
			Email<input type="text" name="email" value="<%=request.getAttribute("email")%>"/>
			PhNumber<input type="text" name="phNumber" value="<%=request.getAttribute("phNumber")%>"/>			
			<input type="submit" value="UpdateInquiry"/>
		
		</pre>
		
	</form>
	
</body>
</html>