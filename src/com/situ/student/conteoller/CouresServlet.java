package com.situ.student.conteoller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.student.pojo.Coures;
import com.situ.student.service.CouresServiceImpl;
import com.situ.student.service.ICouresService;
import com.situ.student.vo.PageBean;

public class CouresServlet extends BaseServlet {
	ICouresService couresService = new CouresServiceImpl();

	public void pageList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageIndexStr = req.getParameter("pageIndex");
		String pageSizeStr = req.getParameter("pageSize");
		
		int pageIndex = 1;
		if (pageIndexStr != null && !pageIndexStr.equals("")) {
			pageIndex = Integer.parseInt(pageIndexStr);
		}
		
		int pageSize = 3;
		if (pageSizeStr != null && !pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		
		PageBean pageBean = couresService.getPageList(pageIndex,pageSize);
		List<Coures> couresList = couresService.getCoures();
		req.setAttribute("couresList", couresList);
		req.setAttribute("pageBean", pageBean);
		req.getRequestDispatcher("/WEB-INF/jsp/coures_show.jsp").forward(req, resp);
	}
	
	
	public void deleteAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] ids = req.getParameterValues("selectId");
		couresService.deleteAll(ids);
		resp.sendRedirect(req.getContextPath() + "/coures?method=pageList");
	}
	
	public void deleteCoures(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idStr = req.getParameter("id");
		int result = couresService.deleteCoures(Integer.parseInt(idStr));
		if (result > 0) {
			resp.sendRedirect(req.getContextPath() + "/coures?method=pageList");
		}
	}
	
	public void toupdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Coures coures = couresService.getCouresById(Integer.parseInt(id));
		req.setAttribute("coures", coures);
		req.getRequestDispatcher("/WEB-INF/jsp/update_coures.jsp").forward(req, resp);
	}
	public void updatecoures(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String grade = req.getParameter("grade");
		Coures coures = new Coures(id, name, Integer.parseInt(grade));
		int result = couresService.updateCoures(coures);
		if (result > 0) {
			resp.sendRedirect(req.getContextPath() + "/coures?method=pageList");
		}
	}
	public void toAddcoures(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/add_coures.jsp").forward(req, resp);
	}
	public void addcoures(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String gradeStr = req.getParameter("grade");
		Integer grade = Integer.parseInt(gradeStr);
		Coures coures = new Coures(name, grade);
		int result = couresService.addCoures(coures);
		if (result > 0) {
			resp.sendRedirect(req.getContextPath() + "coures?method=pageList");
		}
	}
}

