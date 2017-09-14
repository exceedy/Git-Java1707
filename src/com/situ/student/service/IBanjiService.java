package com.situ.student.service;

import java.util.List;
import java.util.Map;

import com.situ.student.pojo.Banji;
import com.situ.student.vo.PageBean;

public interface IBanjiService {

	List<Banji> getBanjiList();


	PageBean<Banji> getPageList(int index, int pageSize);


	void deleteAll(String[] ids);


	void deleteBanji(Integer id);


	int addbanji(String name);


	Banji getBanjiById(int id);


	int updatebanji(Banji banji);

}
