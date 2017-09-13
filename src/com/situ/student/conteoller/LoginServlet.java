package com.situ.student.conteoller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.situ.student.pojo.Admin;
import com.situ.student.service.AdminServiceImpl;
import com.situ.student.service.IAdminService;

public class LoginServlet extends BaseServlet{
	IAdminService adminService = new AdminServiceImpl();
	
		protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String chekCode = req.getParameter("checkCode");
			HttpSession session = req.getSession();
			String checkCodeSession  = (String) session.getAttribute("checkCodeSession");
			if (!chekCode.equals(checkCodeSession) ) {
				resp.sendRedirect(req.getContextPath() + "/login?method=toLogin");
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
					resp.sendRedirect(req.getContextPath() + "/login?method=toLogin");
				}
			}else {
				resp.sendRedirect(req.getContextPath() + "/login?method=toRegister");
			}
 			
			
		}
		protected void toLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
		}
		protected void toRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(req, resp);
		}
}
