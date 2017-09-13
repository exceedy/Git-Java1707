package com.situ.student.service;

import java.util.List;

import com.situ.student.pojo.Banji;
import com.situ.student.pojo.Coures;
import com.situ.student.vo.PageBean;

public interface ICouresService {

	List<Coures> getCoures();

	PageBean getPageList(int pageIndex, int pageSize);

	void deleteAll(String[] ids);

	int deleteCoures(int parseInt);

	Coures getCouresById(int id);

	int updateCoures(Coures coures);

	int addCoures(Coures coures);

	List<Coures> getCouresList();

}
