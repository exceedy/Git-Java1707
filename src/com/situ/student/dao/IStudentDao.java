package com.situ.student.dao;

import java.util.Date;
import java.util.List;

import com.situ.student.pojo.Admin;
import com.situ.student.pojo.Banji;
import com.situ.student.pojo.Student;
import com.situ.student.vo.SearchCondition;

public interface IStudentDao {
	/**
	 * 添加学生
	 * @param student
	 * @return
	 */
	public int add(Student student);
	
	/**
	 * 通过id删除学生
	 * @param id
	 * @return
	 */
	public int deleteById(int id);
	
	/**
	 * 更新学生信息
	 * @param student
	 * @return
	 */
	public int update(Student student);
	
	/**
	 * 返回所有学生信息
	 * @return
	 */
	public List<Student> findAll();
	
	/**
	 * 根据名字查找学生信息
	 * @param name
	 * @return
	 */
	public List<Student> findByName(String name);
	/**
	 * 根据性别查询
	 * @param gender
	 * @return
	 */
	public List<Student> findByGender(String gender);
	
	/**
	 * 根据地址查询
	 * @param address
	 * @return
	 */
	public List<Student> findByAddress(String address);
	
	/**
	 * 根据年龄查询
	 * @param age
	 * @return
	 */
	public List<Student> findByAge(Integer age);
	
	/**
	 * 查看指定用户是不是存在
	 * @return
	 */
	public boolean chekName(String name);
	
	/**
	 * 根据时间查询
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public List<Student> chekDate(Date beginDate,Date endDate);

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Student findById(Integer id);

	/**
	 * 特殊查询
	 * @param searchCondition
	 * @return
	 */
	public List<Student> specialSelect(SearchCondition searchCondition);

	/**
	 * 查询全部的获取数量
	 * @return
	 */
	public Integer getTotalCount();
	
	/**
	 * 查询全部的集合
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public List<Student> getPageBean(Integer pageIndex, Integer pageSize);

	/**
	 * 特殊查询的数量
	 * @param searchCondition 
	 * @return
	 */
	public Integer getTotalCountCondition(SearchCondition searchCondition);

	public List<Student> getPageBeanCondition(SearchCondition searchCondition);

	public int addAdmin(Admin admin);

	public boolean isExsitAdmin(String ursename);

	public Admin exsitUrsename(String urname);

	public List<Banji> getBanjiList();
	

}
