package com.situ.student.conteoller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.student.pojo.Student;

public class printAgeSelectStudent extends HttpServlet {
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter printWriter = resp.getWriter();
			List<Student> list = (List<Student>) req.getAttribute("list");
			

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
					printWriter.println("   <td> <a href = '/java1707web/deleteStudent.do?id="+ student.getId()+"' name = 'getId'>删除</a></td>");
					
					printWriter.println("   </tr>");
				}
					printWriter.println("</table>");
					printWriter.close();
			
			}
		
}
