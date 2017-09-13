package com.situ.student.conteoller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.student.pojo.Banji;
import com.situ.student.pojo.BanjiCoures;
import com.situ.student.pojo.Coures;
import com.situ.student.service.BanjiCouresServiceImpl;
import com.situ.student.service.BanjiServiceImpl;
import com.situ.student.service.CouresServiceImpl;
import com.situ.student.service.IBanjiCouresService;
import com.situ.student.service.IBanjiService;
import com.situ.student.service.ICouresService;
import com.situ.student.vo.PageBean;

public class BanjiCouresServlet extends BaseServlet{
	IBanjiService banjiService = new BanjiServiceImpl();
	ICouresService couresService = new CouresServiceImpl();
	IBanjiCouresService banjiCouresService = new BanjiCouresServiceImpl();
	public void pageList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageIndexStr = req.getParameter("pageIndex");
		String pageSizeStr = req.getParameter("psgeSize");
		int pageIndex = 1;
		if (pageIndexStr != null && !pageIndexStr.equals("")) {
			pageIndex = Integer.parseInt(pageIndexStr);
		}
		int pageSize = 3;
		if (pageSizeStr != null && !pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		PageBean<Banji> pageBean = banjiService.getPageList(pageIndex, pageSize);
		List<Banji> banji = banjiService.getBanjiList();
		List<Coures> couresList = couresService.getCoures();
		List<Coures> banjiCouresList = couresService.getCouresList();
		req.setAttribute("banji", banji);
		req.setAttribute("couresList", couresList);
		req.setAttribute("banjiCouresList", banjiCouresList);
		req.setAttribute("pageBean", pageBean);
		req.getRequestDispatcher("/WEB-INF/jsp/banjicoures_show.jsp").forward(req, resp);
	}
	public void addBanjiCoures(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String banjiId = req.getParameter("banjiId");
		String couresId = req.getParameter("couresId");
		BanjiCoures banjiCoures = new BanjiCoures(Integer.parseInt(banjiId), Integer.parseInt(couresId));
		int result = banjiCouresService.addBanjiCoures(banjiCoures);
		if (result > 0) {
			resp.sendRedirect(req.getContextPath() + "/banjicoures?method=pageList");
		
		}
	}
	public void deleteBanjiCoures(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String banjiId = req.getParameter("banjiId");
		String couresId = req.getParameter("couresId");
		BanjiCoures banjiCoures = new BanjiCoures(Integer.parseInt(banjiId), Integer.parseInt(couresId));
		int result = banjiCouresService.deleteBanjiCoures(banjiCoures);
		if (result > 0) {
			resp.sendRedirect(req.getContextPath() + "/banjicoures?method=pageList");
		}
	}
}
