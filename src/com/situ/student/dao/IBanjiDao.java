package com.situ.student.dao;

import java.util.List;

import com.situ.student.pojo.Banji;

public interface IBanjiDao {

	Integer getTotalCount();

	List<Banji> getBanji(int index, int pageSize);

	void deleteAll(int parseInt);

	int addbanji(String name);

}
