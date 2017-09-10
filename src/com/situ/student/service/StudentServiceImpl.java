package com.situ.student.service;

import java.util.Date;
import java.util.List;

import com.situ.student.dao.IStudentDao;
import com.situ.student.dao.impl.StudentDaoMysqlImpl;
import com.situ.student.exception.NameReapeatException;
import com.situ.student.pojo.Admin;
import com.situ.student.pojo.Student;
import com.situ.student.vo.PageBean;
import com.situ.student.vo.SearchCondition;

public class StudentServiceImpl implements IStudentService {
	private IStudentDao studentDao = new StudentDaoMysqlImpl();
	
	@Override
	public List<Student> findAll() {
		return studentDao.findAll();
	}

	@Override
	public int deleteById(int id) {
		int result = studentDao.deleteById(id);
		return result;
	}

	@Override
	public boolean add(Student student)throws NameReapeatException {
		//1、判断学生是否存在
		if(studentDao.chekName(student.getName())) {
			throw new NameReapeatException("用户名已经存在");
		}else {
			int result = studentDao.add(student);
			if (result > 0) {
				return true;
			} else {
				return false;
			}
		}
		
		
	}

	@Override
	public int upDate(Student student) {
		return studentDao.update(student);
	}

	@Override
	public List<Student> findByName(String name) {
		return studentDao.findByName(name);
	}

	@Override
	public List<Student> findByGender(String gender) {
		return studentDao.findByGender(gender);
	}

	@Override
	public List<Student> findByAge(Integer age) {
		return studentDao.findByAge(age);
	}

	@Override
	public List<Student> findAddress(String address) {
		return studentDao.findByAddress(address);
	}

	@Override
	public List<Student> findByDate(Date beginBirthday, Date endBirthday) {
		return studentDao.chekDate(beginBirthday, endBirthday);
	}

	@Override
	public Student findById(Integer id) {
		return studentDao.findById(id);
	}

	@Override
	public List<Student> specialSelect(SearchCondition searchCondition) {
		return studentDao.specialSelect(searchCondition);
	}

	@Override
	public PageBean<Student> getPageBean(Integer index, Integer pageSize) {
		PageBean<Student> pageBean = new PageBean<Student>();
		pageBean.setPageIndex(index);
		pageBean.setPageSize(pageSize);
		Integer totalCount = studentDao.getTotalCount();
		pageBean.setTotalCount(totalCount);
		Integer totalPage = (int) Math.ceil(1.0 * totalCount / pageSize);
		pageBean.setTotalPage(totalPage);
		Integer pageIndex = (index - 1) * pageSize;
		List<Student> list = studentDao.getPageBean(pageIndex,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public PageBean<Student> getPageBeanCondition(SearchCondition searchCondition) {
		PageBean<Student> pageBean = new PageBean<Student>();
		Integer pageIndex = searchCondition.getPageIndex();
		Integer pageSize = searchCondition.getPageSize();
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		Integer totalCount = studentDao.getTotalCountCondition(searchCondition);
		pageBean.setTotalCount(totalCount);
		Integer totalPage = (int)Math.ceil(1.0 * totalCount / pageSize);
		pageBean.setTotalPage(totalPage);
		List<Student> list = studentDao.getPageBeanCondition(searchCondition);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public boolean chekName(String name) {
		return 	studentDao.chekName(name);
	}

	@Override
	public void deleteById(String[] ids) {
			for (String id : ids) {
				studentDao.deleteById(Integer.parseInt(id));
			}
	}

	
	


	}

	

