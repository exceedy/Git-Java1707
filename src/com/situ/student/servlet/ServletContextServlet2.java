package com.situ.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.student.pojo.Student;
import com.situ.student.service.IStudentService;
import com.situ.student.service.StudentServiceImpl;

public class ServletContextServlet2 extends HttpServlet {
		 @Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			 /*ServletContext  context = getServletContext();
			 context.setAttribute("name", "zhangsan");
			 IStudentService studentService = new  StudentServiceImpl();
			 List<Student> list = studentService.findAll();
			 context.setAttribute("list", list);
			 */
			 
			 ServletContext  context = getServletContext();
			 String name = (String) context.getAttribute("name");
			 List<Student> list = (List<Student>) context.getAttribute("list");
			 System.out.println(name);
			 for (Student student : list) {
				System.out.println(student);
			}
		}
}
