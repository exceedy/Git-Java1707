package com.situ.student.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import com.situ.student.dao.IStudentDao;
import com.situ.student.dao.impl.StudentDaoMysqlImpl;
import com.situ.student.pojo.Student;

public class StudentDaoMysqlImplTest {
	IStudentDao studentDao = new StudentDaoMysqlImpl();
		@Test
	public void testAdd(){
		Student student =new Student("张三", 39, "男", "青岛");
		IStudentDao studentDao = new StudentDaoMysqlImpl();
		int result = studentDao.add(student);
		if (result > 0) {
			System.out.println("成功");
		} else {
			System.out.println("失败");
		}
	}
		@Test
		public void testFindAll() {
			IStudentDao studentDao = new StudentDaoMysqlImpl();
			List<Student> list = studentDao.findAll();
			for (Student student : list) {
				System.out.println(student);
			}
		}
		
		@Test
		public void tsetDeleteById() {
			int id = 1;
			IStudentDao studentDao = new StudentDaoMysqlImpl();
			int result = studentDao.deleteById(id);
			if (result > 0) {
				System.out.println("成功");
			} else {
				System.out.println("失败");
			}
			
		}
		
		@Test
		public void testUpdate() {
			Scanner scanner = new Scanner(System.in);
			IStudentDao studentDao = new StudentDaoMysqlImpl();
			System.out.println("请输入要修改的id");
			int alterId = scanner.nextInt();
			System.out.println("1、修改名字2、修改年龄3、修改性别4、修改地址");
			int alterNum = scanner.nextInt();
			switch (alterNum) {
			case 1: {
				System.out.println("输入要修改的名字");
				String name = scanner.next();
				Student student = new Student(alterId, name, null, null, null);
				studentDao.update(student);
				break;
			}
			case 2: {
				System.out.println("输入要修改的年龄");
				Integer age = scanner.nextInt();
				Student student = new Student(alterId, null, age, null, null);
				studentDao.update(student);
				break;
			}case 3 :{
				System.out.println("输入要修改的性别");
				String gender = scanner.next();
				Student student = new Student(alterId, null, null, gender, null);
				studentDao.update(student);
				break;
			}case 4 : {
				System.out.println("输入要修改的地址");
				String address = scanner.next();
				Student student = new Student(alterId, null, null, null, address);
				studentDao.update(student);
				break;
			}
			}
		}
		
		@Test
		public void tsetFindByName(){
			String name = "zhangsan";
			IStudentDao studentDao = new StudentDaoMysqlImpl();
			List<Student> list = studentDao.findByName(name);
			for (Student student : list) {
				System.out.println(student);
			}
		}
		
		@Test
		public void testChekDate() {
			Scanner scanner = new Scanner(System.in);
			System.out.println("开始");
			String bigenDate = scanner.next();
			System.out.println("结束");
			String endDate = scanner.next();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date bigen = null;
			Date end = null;
			try {
					bigen = simpleDateFormat.parse(bigenDate);
					end = simpleDateFormat.parse(endDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<Student> list = studentDao.chekDate(bigen, end);
			if (list != null) {
				for (Student student : list) {
					System.out.println(student);
				}
			}else {
				System.out.println("无效时间");
			}
			
		}
		
}
