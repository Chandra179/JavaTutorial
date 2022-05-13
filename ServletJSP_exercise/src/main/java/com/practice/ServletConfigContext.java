package com.practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ServletConfig and ServletContext
 *
 */
public class ServletConfigContext extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

		PrintWriter out = res.getWriter();
		out.println("HI");

//		ServletContext ctx = getServletContext();
		ServletConfig ctx = getServletConfig();

		String str = ctx.getInitParameter("name");
		out.println(str);
	}

}
