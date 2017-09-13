package com.situ.student.conteoller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.situ.student.pojo.Admin;
import com.situ.student.service.AdminServiceImpl;
import com.situ.student.service.IAdminService;

public class AdminServlet extends BaseServlet{
	IAdminService adminService = new AdminServiceImpl();
	public void addAdmin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ursename = req.getParameter("ursename");
		String password = req.getParameter("password");
		Admin admin = new Admin(ursename,password);
		int result = adminService.addAdmin(admin);
		if (result > 0) {
			resp.sendRedirect(req.getContextPath() + "/login?method=toLogin");
		} 
	}
	public void isExist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ursename = req.getParameter("name");
		boolean isExsit = adminService.isExsit(ursename);
		resp.getWriter().write("{\"isExsit\":" +isExsit+ "}");
	}
	public void out(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null) {
			Admin admin = (Admin) session.getAttribute("admin");
			session.removeAttribute("admin");
			List<Admin> onLineAdminList = (List<Admin>)getServletContext().getAttribute("onLineAdminList");
			onLineAdminList.remove(admin);
		}
		resp.sendRedirect(req.getContextPath() + "/login?method=toLogin");
		
	}
	
	public void toOnlineList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/online_admin.jsp").forward(req, resp);;
	}
	
}
