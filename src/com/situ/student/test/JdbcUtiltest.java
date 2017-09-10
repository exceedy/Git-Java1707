package com.situ.student.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JdbcUtiltest extends HttpServlet{
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			ServletContext servletContext = getServletContext();
			InputStream inputStream = servletContext.getResourceAsStream("/WEB-INF/classes/db.properties");
			Properties properties = new Properties();
			properties.load(inputStream);
			String url = properties.getProperty("url");
			System.out.println(url);
			
			
		}
}
