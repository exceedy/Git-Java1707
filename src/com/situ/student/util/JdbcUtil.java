package com.situ.student.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JdbcUtil extends HttpServlet{
//	private final static String driverClass = "com.mysql.jdbc.Driver";
//	private final static String url = "jdbc:mysql://localhost:3306/java1707";
//	private final static String userName = "root";
//	private final static String password = "litingting";
	private static String url;
	private static String driverClass;
	private static String userName;
	private static String password;
	
	public static void init(ServletContext servletContext) {
		InputStream inputStream = servletContext.getResourceAsStream("/WEB-INF/classes/db.properties");
		Properties properties = new Properties();
		try {
			properties.load(inputStream);
			url = properties.getProperty("url");
			driverClass = properties.getProperty("driverClass");
			userName = properties.getProperty("userName");
			password = properties.getProperty("password");
		}
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		try {
			Class clazz = Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	
	/*@Override*/
		/*protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletContext servletContext = getServletContext();
		InputStream inputStream = servletContext.getResourceAsStream("/WEB-INF/classes/db.properties");
		Properties properties = new Properties();*/
		/*FileInputStream fileInputStream = null;*/
		/*try {*/
			/*fileInputStream = new FileInputStream("D:\\JAVA\\gongzqu\\java1707web\\src\\db.properties");*/
	/*	
			properties.load(inputStream);
			url = properties.getProperty("url");
			driverClass = properties.getProperty("driverClass");
			userName = properties.getProperty("userName");
			password = properties.getProperty("password");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
			}
			try {
				Class.forName(driverClass);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}*/

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, userName, password );
	}

	public static void close(Connection connection, Statement statement, ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void close(Connection connection, Statement statement) {

		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
