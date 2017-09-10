package com.situ.student.conteoller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.student.pojo.Student;
import com.situ.student.service.StudentServiceImpl;


public class ServletTable extends HttpServlet{
			@Override  
			protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				StudentServiceImpl studentServlet = new StudentServiceImpl();
				List<Student> list = studentServlet.findAll();
				
				resp.setContentType("text/html;charset = utf-8");
				    
				PrintWriter printWriter = resp.getWriter();
				printWriter.println("<a href='/java1707web/html/add_stduent.html' color = 'black'>添加</a>");
				printWriter.println("<table border = ' 1px soild' cellspacing ='0'>");
				printWriter.println("     <tr>");
				printWriter.println("          <td>id</td>");
				printWriter.println("          <td>name</td>");
				printWriter.println("          <td>age</td>");
				printWriter.println("          <td>gender</td>");
				printWriter.println("          <td>address</td>");
				printWriter.println("          <td>birthday</td>");
				printWriter.println("      </tr>");
				
				for (Student student : list) {
					printWriter.println("   <tr>");
					printWriter.println("   <td>" + student.getId() + "</td>");
					printWriter.println("   <td>" + student.getName() + "</td>");
					printWriter.println("   <td>" + student.getAge() + "</td>");
					printWriter.println("   <td>" + student.getGender() + "</td>");
					printWriter.println("   <td>" + student.getAddress() + "</td>");
					printWriter.println("   <td>" + student.getBirthday() + "</td>");
					printWriter.println("   </tr>");
				}
					printWriter.println("</table>");
					printWriter.close();
			}
			
}
