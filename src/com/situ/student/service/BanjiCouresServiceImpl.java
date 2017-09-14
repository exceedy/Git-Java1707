package com.situ.student.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.situ.student.dao.IBanjiCouresDao;
import com.situ.student.dao.impl.BanjiCouresDaoImpl;
import com.situ.student.pojo.BanjiCoures;
import com.situ.student.vo.PageBean;

public class BanjiCouresServiceImpl implements IBanjiCouresService {
	IBanjiCouresDao banjiCouresDao = new BanjiCouresDaoImpl();
	@Override
	public int addBanjiCoures(BanjiCoures banjiCoures) {
		return banjiCouresDao.addBanjiCoures(banjiCoures);
	}
	@Override
	public int deleteBanjiCoures(BanjiCoures banjiCoures) {
		return banjiCouresDao.deleteBanjiCoures(banjiCoures);
	}
	@Override
	public PageBean<Map<String, Object>> getPageList(int pageIndex, int pageSize) {
		PageBean<Map<String,Object>> pageBean = new PageBean<Map<String, Object>>();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int totalCount = banjiCouresDao.getTotalCount();
		pageBean.setTotalCount(totalCount);
		int totalPage = (int) Math.ceil(1.0 * totalCount / pageSize);
		pageBean.setTotalPage(totalPage);
		int index = (pageIndex - 1) * pageSize;
		list = banjiCouresDao.getPageList(index, pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}

}
