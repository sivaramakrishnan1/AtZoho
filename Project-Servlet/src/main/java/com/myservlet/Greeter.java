package com.myservlet;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/tryGreet")
public class Greeter extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String print = "";
		if (((String) req.getParameter("Name")) == null)
			print += "Vanakam<br>";
		else
			print = "Hello " + (String) req.getParameter("Name") + "<br>How are ya ? ";

		String message = "";
		if(((String) req.getParameter("fav_actor")) == null)
		{
			message += "<br> Poi sakkarai pongal saapudung bro.";
		}
		else
		switch ((String) req.getParameter("fav_actor")) {
			case "Thalapathy":
				message += "<br> Kudumbamna aayiram irukum";
				break;
			case "Thala":
				message += "<br> No guts, no glory";
				break;
			case "None":
				message += "<br> Poi sakkarai pongal saapudung bro.";
		}

		HttpSession s = req.getSession();
		s.setAttribute("GreetHere", print);
		s.setAttribute("message", message);
		res.sendRedirect("question2.jsp");
	}
}
