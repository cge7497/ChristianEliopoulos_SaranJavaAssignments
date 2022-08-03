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
	<%@ page
		import="java.util.List, com.christian.model.Employee, java.io.IOException"%>
	<%
	int amt = 0;
	List<Employee> emps = null;
	String operation = "";
	if (request != null) {
		operation = (String) request.getParameter("operation");
		if (request.getAttribute("amt") != null) {
			amt = (int) request.getAttribute("amt");
		}
		if (request.getAttribute("emp") != null) {
			emps = (List<Employee>) (request.getAttribute("emp")); //to fix: send list data in request, not resultSet
		}
	}

	if (amt >= 0) {
		out.println("Performed " + operation + " operation on " + amt + " entries.<br>");
	}
	if (emps != null && emps.size() >= 0) {
		out.println("Employee(s) <br>");
		final JspWriter out2 = out; //this is a work-around for an enclosing scope error on out.
		emps.forEach((e) -> {
			try {
		out2.println("ID: " + e.getId() + "\tName: " + e.getName() + "\tAge: " + e.getAge() + "<br>");
			} catch (IOException exc) {
		exc.printStackTrace();
			}
		});
	}
	%>
	<%@ include file="loggedIn.jsp"%>
</body>


</html>