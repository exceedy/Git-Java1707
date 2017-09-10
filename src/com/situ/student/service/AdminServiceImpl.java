package com.situ.student.service;

import com.situ.student.dao.IStudentDao;
import com.situ.student.dao.impl.StudentDaoMysqlImpl;
import com.situ.student.pojo.Admin;

public class AdminServiceImpl implements IAdminService {
	IStudentDao studentDao = new StudentDaoMysqlImpl();
	@Override
	public int addAdmin(Admin admin) {
		
		return studentDao.addAdmin(admin);
	}
	@Override
	public boolean isExsit(String ursename) {
		return studentDao.isExsitAdmin(ursename);
	}

	@Override
	public Admin exsitUrsename(String urname) {
		
		return studentDao.exsitUrsename(urname);
	}

}
