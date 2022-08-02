<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Query Results</h2>
	<%
	boolean failure = (boolean)request.getAttribute("failure");
	if (failure==true) {
		out.println("<h2 style=color:Red>No results from query... Try new info.</h2>");
	}
	
	if (request!= null && request.getAttribute("data") != null){
		out.println(request.getAttribute("data").toString());
	}
	%>
	
	<button href = "/login"></button>
</body>


</html>