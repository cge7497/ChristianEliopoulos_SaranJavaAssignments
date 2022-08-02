<html>
<body>
	<h2>Welcome to Christian's MVC Application! Please log in to
		access Employee Controller.</h2>
	<%
	if (request!=null && request.getAttribute("failure") != null) {
		out.println("<h3 style=color:Red>Incorrect Login Info. Try new info.</h3>");
	}
	%>
	<p>A good test account is user: 'test' and password: '123'</p>
	<form action="login" method="post">
		User Name:<input type="text" name="username"><br>
		Password:<input type="password" name="password"><br> <input
			type="submit" value="Login">
	</form>
</body>
</html>
