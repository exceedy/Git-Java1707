package com.situ.student.dao;

import java.util.List;

import com.situ.student.pojo.Coures;

public interface ICouresDao {

	List<Coures> getCoures();

	Integer getTotalCount();

	List<Coures> getBanji(int i, int pageSize);

	int deleteCoures(int parseInt);

	Coures getCouresById(int id);

	int updateCoures(Coures coures);

	int addCoures(Coures coures);

	List<Coures> getCouresList();

}
