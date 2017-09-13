package com.situ.student.conteoller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.student.pojo.Banji;
import com.situ.student.pojo.Coures;
import com.situ.student.service.BanjiServiceImpl;
import com.situ.student.service.CouresServiceImpl;
import com.situ.student.service.IBanjiService;
import com.situ.student.service.ICouresService;
import com.situ.student.vo.PageBean;

public class BanjiServlet extends BaseServlet {
		IBanjiService banjiService = new BanjiServiceImpl();
		ICouresService couresService = new CouresServiceImpl();
		
		
		/**
		 * 为studentServlet返回班级列表
		 * @return
		 */
	public List<Banji> banjiList() {
		return banjiService.getBanjiList();
	}
	
	/**
	 * 分页
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
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
		req.getRequestDispatcher("/WEB-INF/jsp/banji_show.jsp").forward(req, resp);
	}
	
	/**
	 * 批量删除
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] ids = req.getParameterValues("selectId");
		banjiService.deleteAll(ids);
		resp.sendRedirect(req.getContextPath() + "/banji?method=pageList");
	}
	
	/**
	 * 删除班级
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteBanji(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		banjiService.deleteBanji(Integer.parseInt(id));
		resp.sendRedirect(req.getContextPath() + "/banji?method=pageList");
	}
	
	/**
	 * 跳转添加页面
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void toAddbanji(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/add_banji.jsp").forward(req, resp);
		
	}
	/**
	 * 添加班级
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addbanji(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		int result = banjiService.addbanji(name);
		if (result > 0) {
			resp.sendRedirect(req.getContextPath() + "/banji?method=pageList");
		}
	}
	/**
	 * 跳转修改界面
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void toupdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Banji banji = banjiService.getBanjiById(Integer.parseInt(id));
		req.setAttribute("banji", banji);
		req.getRequestDispatcher("/WEB-INF/jsp/update_banji.jsp").forward(req, resp);
	}
	
	/**
	 * 修改班级
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updatebanji(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		Banji banji = new Banji(id, name);
		int result = banjiService.updatebanji(banji);
		if (result > 0) {
			resp.setContentType("text/html;charset=utf-8");
			resp.sendRedirect(req.getContextPath() + "/banji?method=pageList");
		}
				
	}
}
