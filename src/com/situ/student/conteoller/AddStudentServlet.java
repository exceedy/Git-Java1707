package com.situ.student.conteoller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.student.exception.NameReapeatException;
import com.situ.student.pojo.Student;
import com.situ.student.service.IStudentService;
import com.situ.student.service.StudentServiceImpl;

public class AddStudentServlet extends HttpServlet {
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String name = req.getParameter("name");
			String gender = req.getParameter("gender");
			String age = req.getParameter("age");
			String address = req.getParameter("address");
			String date = req.getParameter("birthday");
			
			//获取参数
			System.out.println("name" + name);
			System.out.println("gender" + gender);
			System.out.println("age" + age);
			System.out.println("address" + address);
			System.out.println("birthday" + date);
			
			
			//1、请求行
			
			System.out.println("请求方式" + req.getMethod());
			System.out.println("访问路径" + req.getServletPath());
			System.out.println("Http协议" + req.getProtocol());
			
			//2、获得请求头
			Enumeration<String> enumeration =  req.getHeaderNames();
			while (enumeration.hasMoreElements()) {
				String key = enumeration.nextElement();
				String value = req.getHeader(key);
				System.out.println(key + " " + value);
			}
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date birthday = null;
			try {
				birthday = simpleDateFormat.parse(date);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Student student = new Student(name, Integer.parseInt(age), gender, address, birthday);
			
			IStudentService studentServlet = new StudentServiceImpl();
			boolean flag = false;
				try {
					studentServlet.add(student);
				} catch (NameReapeatException e) {
					flag = true;
					e.printStackTrace();
				}
				
				resp.setContentType("text/html;charset=utf-8");
				if (flag) {
					PrintWriter printWriter = resp.getWriter();
					printWriter.println("用户名已存在");
					printWriter.println("<a href = '/java1707web/html/add_stduent.html'>返回</a>");
						
				} else {
					resp.sendRedirect("/java1707web/table");
				}
					
		}
}
