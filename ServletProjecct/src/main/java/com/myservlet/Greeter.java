package com.myservlet;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/tryGreet")
public class Greeter extends HttpServlet {
 
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("From greeter : ");
		System.out.println(req);
		String print = "";
		if (((String) req.getParameter("Name")) == null)
			print += "Vanakam<br>";
		else
			print = "Hello " + (String) req.getParameter("Name") + "<br>How are ya ?<br> ";

		String message = "";
		if(((String) req.getParameter("fav_actor")) == null)
		{
			message += "Poi sakkarai pongal saapudung bro.";
		}
		else
		switch ((String) req.getParameter("fav_actor")) {
			case "Thalapathy":
				message += "Kudumbamna aayiram irukum";
				break;
			case "Thala":
				message += "No guts, no glory";
				break;
			case "None":
				message += "Poi sakkarai pongal saapudung bro.";
		}

		HttpSession s = req.getSession();
		s.setAttribute("GreetHere", print);
		s.setAttribute("message", message);
		res.sendRedirect("question2.jsp");
	}
}
