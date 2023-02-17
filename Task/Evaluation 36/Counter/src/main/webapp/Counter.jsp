<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.site.count.CountChange"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>
		<%
		CountChange counter = new CountChange();
		counter.countVisit(request, response);
		%>
		
		Count : ${number}
        
    </p>
</body>
</html>