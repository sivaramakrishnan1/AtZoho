<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2. Connection established</title>
</head>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;700 &display=swap')
	;

html {
	overflow: hidden;
}

* {
	background-color: #523249;
	color: white;
	font-family: Poppins;
	font-size: 40px;
	margin: 40px;
}
</style>

<body>
	<%
	String name = request.getParameter("Name");
	if (name.equals(""))
		out.println("It feels weird to greet without name, but hello there");
	else
		out.println("Hello " + name + ", welcome to this site");
	%>
</body>
</html>
</html>
