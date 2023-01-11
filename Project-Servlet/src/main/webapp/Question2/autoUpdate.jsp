<%@page import="java.net.HttpURLConnection"%>
<%@page import="jakarta.servlet.http.HttpServletRequest"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.util.net.*"%>
<%@page import="com.myservlet.autoUpdate"%>

<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Live Time</title>
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
            ${date}
            ${month}
            ${year}
            ${hour }
            ${minute }
            ${second }
            </div>

	<a href=""><button class="nextProject">Next project</button></a>

</body>
</html>