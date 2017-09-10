package com.situ.student.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.student.pojo.Student;
import com.situ.student.service.IStudentService;
import com.situ.student.service.StudentServiceImpl;

public class ServletContextServlet1 extends HttpServlet {
		 @Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			 ServletContext  context = getServletContext();
			 context.setAttribute("name", "zhangsan");
			 IStudentService studentService = new  StudentServiceImpl();
			 List<Student> list = new ArrayList<Student>();
			 list.add(new Student("s", 21, "男", "sada"));
			 list.add(new Student("s", 21, "男", "sada"));
			 list.add(new Student("s", 21, "男", "sada"));
			 context.setAttribute("list", list);
			 
		}
}
