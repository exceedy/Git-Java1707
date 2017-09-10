package com.situ.student.conteoller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BaseServlet extends HttpServlet {
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			/*req.setCharacterEncoding("utf-8");*/
			 
			
			//获取method的value
			String methodName = req.getParameter("method");
			
			//2.获得当前被访问对象的字节码对象
			//StudentServlet.calss CourseServlet.class
			Class clazz = this.getClass();
			
			//3、获得的当前字节码对象中指定的方法
			try {
				Method method = clazz.getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
				method.setAccessible(true);
				//4调用方法
				method.invoke(this, req,resp);
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			
		}
		
}
