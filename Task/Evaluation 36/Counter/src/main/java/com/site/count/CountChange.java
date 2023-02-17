package com.site.count;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/countIncrementer")
public class CountChange extends HttpServlet {
	
	public void countVisit(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		Cookie[] cookies = req.getCookies();		
		int count = 1;
				
		Cookie cookie;
		
		if(cookies == null || cookies.length == 1 || cookies[1] == null || cookies[1].getValue().equals("")) 
			cookie = new Cookie("count", "" + count);
		else {
			count = Integer.parseInt(cookies[1].getValue()) + 1;
			cookie = new Cookie("count", "" + count);
		}
				
		cookie.setMaxAge(60 * 60 * 24);
		cookie = new Cookie("count", "" + count );
		res.addCookie(cookie);
		HttpSession ses = req.getSession();
		ses.setAttribute("number", count);		
	}
}
