package com.situ.student.conteoller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.situ.student.util.JdbcUtil;

public class initServlet extends HttpServlet {
		@Override
		public void init() throws ServletException {
			ServletContext servletContext = getServletContext();
			JdbcUtil.init(servletContext);
			
			int count = 0;
			servletContext.setAttribute("count", count);
			
		}
		
}
