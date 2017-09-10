package com.stu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimeServlet extends HttpServlet {
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			Date date = new Date();
			SimpleDateFormat simpleDateFormat = new  SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String newDate = simpleDateFormat.format(date);
			PrintWriter  printWriter  =resp.getWriter();
			printWriter.println("<p>" + newDate + "</p>");
			printWriter.close();
			
		}
		                                                                                                                                                                                                                                                                                                                       
}
