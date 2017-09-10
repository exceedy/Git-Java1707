package com.situ.student.conteoller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.situ.student.pojo.Admin;
import com.situ.student.service.AdminServiceImpl;
import com.situ.student.service.IAdminService;

public class LoginServlet extends HttpServlet{
	IAdminService adminService = new AdminServiceImpl();
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String chekCode = req.getParameter("checkCode");
			HttpSession session = req.getSession();
			String checkCodeSession  = (String) session.getAttribute("checkCodeSession");
			if (!chekCode.equals(checkCodeSession) ) {
				resp.sendRedirect(req.getContextPath() + "/jsp/login.jsp");
				return;
			}
			String urname = req.getParameter("urname");
			String password  = req.getParameter("password");
			Admin admin = adminService.exsitUrsename(urname);
			if (admin.getUrsename() != null &&  admin.getPassword() != null) {
				if (admin.getUrsename().equals(urname) && admin.getPassword().equals(password)) {
					
					session.setAttribute("admin", admin);
					ServletContext servletContext = req.getServletContext();
					List<Admin> onLineAdminList = (List<Admin>)servletContext.getAttribute("onLineAdminList");
					onLineAdminList.add(admin);
					resp.sendRedirect(req.getContextPath() + "/student?method=pageList");
				} else {
					resp.sendRedirect(req.getContextPath() + "/jsp/register.jsp");
				}
			}else {
				resp.sendRedirect(req.getContextPath() + "/jsp/register.jsp");
			}
 			
			
		}
}
