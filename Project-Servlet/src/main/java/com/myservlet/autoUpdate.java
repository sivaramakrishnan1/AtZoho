package com.myservlet;

import java.io.IOException;
import java.net.http.HttpRequest;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/time")
public class autoUpdate {
	public void giveDateTime(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		HttpSession s = req.getSession();
		s.setAttribute("Date", "1212");
		res.sendRedirect("question2.jsp");
	}
}
