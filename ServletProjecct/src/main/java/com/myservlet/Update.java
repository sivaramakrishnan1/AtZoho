package com.myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/refresh")
public class Update extends HttpServlet {
	
	public void update(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setHeader("refresh", "0.5");

		HttpSession ses = req.getSession();
	
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter form = DateTimeFormatter.ofPattern("dd : MM : YYYY hh:mm:ss a");
		String datetime = date.format(form);


		ses.setAttribute("date", datetime);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
		doGet(req, resp);
	}
}
