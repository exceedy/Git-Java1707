package com.situ.student.service;

import java.util.Date;
import java.util.List;

import com.situ.student.exception.NameReapeatException;
import com.situ.student.pojo.Student;
import com.situ.student.vo.PageBean;
import com.situ.student.vo.SearchCondition;

public interface IStudentService {
	/**
	 * 返回所有学生
	 * @return
	 */
	List<Student> findAll();

	/**
	 * 根据id删除学生
	 * @param id
	 * @return
	 */
	
	int deleteById(int id);

	/**
	 * 添加学生
	 * @param student
	 * @return
	 */
	boolean add(Student student)throws NameReapeatException;
	
	/**
	 * 修改学生信息
	 * @param student
	 * @return
	 */
	int upDate(Student student);
	
	/**
	 * 根据姓名查询
	 * @param name
	 * @return
	 */
	List<Student> findByName(String name);

	/**
	 * 根据性别查询
	 * @param gender
	 * @return
	 */
	List<Student> findByGender(String gender);

	/**
	 * 根据年龄查询
	 * @param age
	 * @return
	 */
	List<Student> findByAge(Integer age);

	/**
	 * 根据地址查询
	 * @param address
	 * @return
	 */
	List<Student> findAddress(String address);

	/**
	 * 根据生日查询
	 * @param beginBirthday
	 * @param endBirthday
	 * @return
	 */
	List<Student> findByDate(Date beginBirthday, Date endBirthday);

	Student findById(Integer id);

	List<Student> specialSelect(SearchCondition searchCondition);

	PageBean getPageBean(Integer index, Integer pageSize);

	PageBean getPageBeanCondition(SearchCondition searchCondition);

	boolean chekName(String name);

	void deleteById(String[] ids);


	
				
				

	
		
}
