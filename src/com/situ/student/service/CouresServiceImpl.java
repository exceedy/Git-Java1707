package com.situ.student.service;

import java.util.List;

import com.situ.student.dao.ICouresDao;
import com.situ.student.dao.impl.CouresDaoImpl;
import com.situ.student.pojo.Coures;

public class CouresServiceImpl implements ICouresService {
	ICouresDao couresDao = new CouresDaoImpl();
	@Override
	public List<Coures> getCoures() {
		return couresDao.getCoures() ;
	}

}
