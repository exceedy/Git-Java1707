package com.situ.student.conteoller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.student.pojo.Banji;
import com.situ.student.pojo.Coures;
import com.situ.student.service.BanjiServiceImlp;
import com.situ.student.service.CouresServiceImpl;
import com.situ.student.service.IBanjiService;
import com.situ.student.service.ICouresService;
import com.situ.student.vo.PageBean;

public class BanjiServlet extends BaseServlet {
		IBanjiService banjiService = new BanjiServiceImlp();
		ICouresService couresService = new CouresServiceImpl();

	public List<Banji> banjiList() {
		return banjiService.getBanjiList();
	}
	public void pageList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageIndex = req.getParameter("pageIndex");
		String pageSizestr = req.getParameter("pageSize");
		int index = 1;
		if (pageIndex != null && !pageIndex.equals("")) {
			index = Integer.parseInt(pageIndex);
		}
		int pageSize = 3;
		if (pageSizestr != null && !pageSizestr.equals("")) {
			pageSize = Integer.parseInt(pageSizestr);
		}
		PageBean<Banji> pageBean = banjiService.getPageList(index,pageSize);
		List<Coures> couresList = couresService.getCoures();
		req.setAttribute("pageBean", pageBean);
		req.setAttribute("couresList", couresList);
		req.getRequestDispatcher("/jsp/banji_show.jsp").forward(req, resp);
	}
	
	public void deleteAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] ids = req.getParameterValues("selectId");
		banjiService.deleteAll(ids);
		resp.sendRedirect(req.getContextPath() + "/banji?method=pageList");
	}
	
	public void deleteBanji(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		banjiService.deleteBanji(Integer.parseInt(id));
		resp.sendRedirect(req.getContextPath() + "/banji?method=pageList");
	}
	
	public void toAddbanji(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/jsp/add_banji.jsp").forward(req, resp);
		
	}
	
	public void addbanji(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		int result = banjiService.addbanji(name);
		if (result > 0) {
			
			resp.sendRedirect(req.getContextPath() + "/banji?method=pageList");
		}
	}
	
	public void toupdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		req.getRequestDispatcher("/jsp/update_banji").forward(req, resp);
	}
}
