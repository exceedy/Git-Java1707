package com.situ.student.conteoller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PathServlet extends HttpServlet{
			
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println(req.getContextPath());
		System.out.println(req.getServletPath());
		System.out.println(req.getRequestURI());
		System.out.println(req.getRequestURL());
		
		
	}
}
