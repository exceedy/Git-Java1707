package com.situ.student.service;

import java.util.List;
import java.util.Map;

import com.situ.student.dao.IBanjiDao;
import com.situ.student.dao.IStudentDao;
import com.situ.student.dao.impl.BanjiDaoImpl;
import com.situ.student.dao.impl.StudentDaoMysqlImpl;
import com.situ.student.pojo.Banji;
import com.situ.student.vo.PageBean;

public class BanjiServiceImpl implements IBanjiService {
	IStudentDao studentDao = new StudentDaoMysqlImpl();
	IBanjiDao banjiDao = new BanjiDaoImpl();
	@Override
	public List<Banji> getBanjiList() {
		return studentDao.getBanjiList();
	}
	@Override
	public PageBean<Banji> getPageList(int index, int pageSize) {
		PageBean<Banji> pageBean = new PageBean<Banji>();
		pageBean.setPageIndex(index);
		pageBean.setPageSize(pageSize);
		Integer totalCount = banjiDao.getTotalCount();
		pageBean.setTotalCount(totalCount);
		Integer totalPage = (int) Math.ceil(1.0 * totalCount / pageSize);
		pageBean.setTotalPage(totalPage);
		List<Banji> list = banjiDao.getBanji((index - 1) * pageSize , pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	@Override
	public void deleteAll(String[] ids) {
		for (String id : ids) {
			banjiDao.deleteAll(Integer.parseInt(id));
		}
				}
	@Override
	public void deleteBanji(Integer id) {
		banjiDao.deleteAll(id);
	}
	@Override
	public int addbanji(String name) {
		return banjiDao.addbanji(name);
	}
	@Override
	public Banji getBanjiById(int id) {
		return banjiDao.getBanjiById(id);
	}
	@Override
	public int updatebanji(Banji banji) {
		return banjiDao.updatebanji(banji);
	}

}
