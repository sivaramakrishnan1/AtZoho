<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.util.Date"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
            <title>1. Date & time</title>
        </head>

        <style>
            html {
                overflow: hidden;
            }

            * {
                background-color: #523249;
            }

            button {
                border-style: none;
                background-color: #815355;
                cursor: pointer;
                font-family: Century Gothic;
                font-size: 20px;
                padding: 20px 42px;
                text-align: center;
                border-radius: 15px;
                margin-left: 45vw;
                color: white;
            }

            .date {
                font-size: 80px;
                color: white;
                font-family: Century Gothic;
                margin-top: 35vh;
                text-align: center;
            }
        </style>

        <body>
            <div class="out">
            <% 
				LocalDateTime date = LocalDateTime.now(); 
				DateTimeFormatter form = DateTimeFormatter.ofPattern("dd : MM : YYYY hh:mm:ss a");
				String datetime = date.format(form);
				LocalDateTime ldt = LocalDateTime.now();
				out.println("<p class=\"date\">Today : " + datetime + "<br><br></p>");
			%>
            </div>
            <a href="question2.html">
                <button>Next work</button>
            </a>
        </body>
    </html>
</html>
