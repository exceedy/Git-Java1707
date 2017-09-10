package com.situ.student.service;

import com.situ.student.pojo.Admin;

public interface IAdminService {

	int addAdmin(Admin admin);

	boolean isExsit(String ursename);

	Admin exsitUrsename(String urname);

}
