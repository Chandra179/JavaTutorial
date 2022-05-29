package com.practice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddNumber extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		int k = i + j;

		// REQ DISPATCHER
//		req.setAttribute("k", k);
//		RequestDispatcher rd = req.getRequestDispatcher("callme");
//		rd.forward(req, res);

		// SESSION
//		HttpSession session = req.getSession();
//		session.setAttribute("k", k);
//		res.sendRedirect("callme?k=" + k); // URL rewriting

		// COOKIE
		Cookie cookie = new Cookie("k", k + "");
		res.addCookie(cookie);
		res.sendRedirect("callme?k=" + k); // URL rewriting
	}

}
