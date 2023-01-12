<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.util.Date"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
    <link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;700&display=swap" rel="stylesheet">
        <meta charset="UTF-8">
            <title>1. Date & time</title>
        </head>

        <style>
            html {
                overflow: hidden;
            }

            * {
                background-color: #523249;
				color: white;
				margin: 0px;
				font-family: Poppins, Century Gothic;
				font-size: 20px;
            }

            .date {
                font-size: 80px;
                color: white;
                font-family: Poppins, Century Gothic;
                margin-top: 35vh;
                text-align: center;
            }
            
            .nextProject {
				border: none;
				background-color: #815355;
				cursor: pointer;
				padding: 20px 42px;
				color: white;
				width: 100vw;
				bottom: 0px;
				position: absolute;
			}
        </style>

        <body>
            <div class="out">
            <% 
				LocalDateTime date = LocalDateTime.now(); 
				DateTimeFormatter form = DateTimeFormatter.ofPattern("dd : MM : YYYY hh:mm:ss a");
				String datetime = date.format(form);
				out.println("<p class=\"date\">Today : " + datetime + "<br><br></p>");
			%>
            </div>
            
			<a href="question2.jsp"><button class="nextProject">Next project</button></a>
        </body>
    </html>
</html>
