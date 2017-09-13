package com.situ.student.service;

import java.util.List;

import com.situ.student.dao.ICouresDao;
import com.situ.student.dao.impl.CouresDaoImpl;
import com.situ.student.pojo.Banji;
import com.situ.student.pojo.Coures;
import com.situ.student.vo.PageBean;

public class CouresServiceImpl implements ICouresService {
	ICouresDao couresDao = new CouresDaoImpl();
	@Override
	public List<Coures> getCoures() {
		return couresDao.getCoures() ;
	}
	@Override
	public PageBean<Coures> getPageList(int pageIndex, int pageSize) {
		PageBean<Coures> pageBean = new PageBean<Coures>();
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		Integer totalCount = couresDao.getTotalCount();
		pageBean.setTotalCount(totalCount);
		Integer totalPage = (int) Math.ceil(1.0 * totalCount / pageSize);
		pageBean.setTotalPage(totalPage);
		List<Coures> list = couresDao.getBanji((pageIndex - 1) * pageSize , pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	@Override
	public void deleteAll(String[] ids) {
		for (String id : ids) {
			couresDao.deleteCoures(Integer.parseInt(id));
		}

	}
	@Override
	public int deleteCoures(int id) {
		return couresDao.deleteCoures(id);
	}
	@Override
	public Coures getCouresById(int id) {
		return couresDao.getCouresById(id);
	}
	@Override
	public int updateCoures(Coures coures) {
		return couresDao.updateCoures(coures);
	}
	@Override
	public int addCoures(Coures coures) {
		return couresDao.addCoures(coures);
	}
	@Override
	public List<Coures> getCouresList() {
		return couresDao.getCouresList();
	}

}
