<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Make changes to database</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
	String name = (String) request.getAttribute("name");
	if (name != null && !name.isEmpty()) {
		out.println("<h1 style=color:CornFlowerBlue>Welcome " + name + "</h1>");
	}
	%>
	<div class="flex-container">
		<div>
			<h2>Create</h2>
			<form action="queryData" method="post">
				Employee ID: <input type="number" name="cr_id"><br>
				Name: <input type="text" name="cr_name"><br> Age: <input
					type="number" name="cr_age"><br> <input type="submit"
					value="Create Employee"> <input type="hidden"
					name="operation" value="create" />
			</form>
		</div>
		<div>
			<h2>Read</h2>
			<form action="queryData" method="get">
				Employee ID: <input type="number" name="r_id"><br> <input
					type="submit" value="Read Employee"> <input type="hidden"
					name="operation" value="read" />
			</form>
			<br>
			<form action="queryData" method="get">
				<input type="submit" value="Read All Employees"> <input
					type="hidden" name="operation" value="read all" />
			</form>
		</div>
		<div>
			<h2>Update</h2>
			<form action="queryData" method="post">
				Employee ID: <input type="number" name="up_id"><br>
				Name: <input type="text" name="up_name"><br> Age: <input
					type="number" name="up_age"><br> <input type="submit"
					value="Update Employee"> <input type="hidden"
					name="operation" value="update" />
			</form>
		</div>
		<div>
			<h2>Delete</h2>
			<form action="queryData" method="get">
				Employee ID: <input type="number" name="del_id"><br> <input
					type="submit" value="Delete Employee"> <input type="hidden"
					name="operation" value="delete" />
			</form>
		</div>
	</div>
</body>
</html>