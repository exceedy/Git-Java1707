package com.situ.student.view;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.situ.student.conteoller.StudentController;
import com.situ.student.exception.NameReapeatException;
import com.situ.student.pojo.Student;


public class StudentView {
	private StudentController studentController = new StudentController();
	private Scanner scanner = new Scanner(System.in);
	Student student = new Student();
	public void showStudent() {
		
		while (true) {	
			
			System.out.println("-----学生管理系统-----");
			System.out.println("1、查询所有学生");
			System.out.println("2、添加学生");
			System.out.println("3、修改学生");
			System.out.println("4、删除学生");
			System.out.println("5、按条件查询");
			System.out.println("0、退出");
			System.out.println("请选择");
			
			int num = scanner.nextInt();
			
			if (num == 0) {
				break;
			}
			
			switch (num) {
			case 1: {//查询所有学生
				findAll();
				break;
			}
			case 2: {//添加学生
				add();
				break;
			}
			case 3 : {//修改学生信息
				upDate();
				break;
			}
			case 4 : {//删除学生
				deleteById();
				break;
			}
			case 5 : {//按条件查询
				qurey();
			}
			}
		}
	}
	
	private void qurey() {
		System.out.println("1、按姓名查询2、按年龄查询3、按性别查询4、按地址查询5、按时间查询");
		Integer queryNum = scanner.nextInt();
		switch (queryNum) {
		case 1 : {
			System.out.println("请输入要查询的姓名");
			String name = scanner.next();
			
			List<Student> studentList = studentController.findByNmae(name);
			if (studentList != null) {
				for (Student student : studentList) {
					System.out.println(student);
				}
			}else {
				System.out.println("没有这个姓名");
				
			}
			break;
		}
		case 2 : {
			System.out.println("请输入要查询的年龄");
			Integer age = scanner.nextInt();
			
			List<Student> studentList = studentController.findByAge(age);
			if (studentList != null) {
				for (Student student : studentList) {
					System.out.println(student);
				}
			} else {
				System.out.println("没有这个年龄");
			}
			break;
		}
		case 3 : {
			System.out.println("请输入要查询的性别");
			String gender = scanner.next();
			
			List<Student> studentList = studentController.findByGender(gender);
			if (studentList != null) {
				for (Student student : studentList) {
					System.out.println(student);
				}
			} else {
				System.out.println("非法输入");
			}
			break;
		}
		case 4 : {
			System.out.println("请输入要查询的地址");
			String address = scanner.next();
			
			List<Student> studentList = studentController.findByAddress(address);
			if (studentList != null) {
				
				for (Student student : studentList) {
					System.out.println(student);
				}
			}else {
				System.out.println("没有该地址");
			}
			break;
		}
		case 5 : {
			System.out.println("请输入开始时间");
			String beginDate = scanner.next();
			System.out.println("请输入结束时间");
			String endDate = scanner.next();
			chekDate(beginDate,endDate);
			break;
		}default : {
			break;
		}
		}
	}

	private void chekDate(String beginDate, String endDate) {
			List<Student> list = studentController.findByDate(beginDate,endDate);
			if (list != null) {
				for (Student student : list) {
					System.out.println(student);
				}
			} else {
				System.out.println("无效时间");
			}
	}

	public void upDate() {
		findAll();
		int result = 0;
		System.out.println("请输入要修改的id");
		int alterId = scanner.nextInt();
		System.out.println("1、修改名字2、修改年龄3、修改性别4、修改地址5、修改生日");
		int alterNum = scanner.nextInt();
		switch (alterNum) {
		case 1: {
			System.out.println("输入名字");
			String name = scanner.next();
			result = studentController.upDate(alterId, name, null, null, null,null);
			upDateResult(result);
			break;
		}
		case 2: {
			System.out.println("输入年龄");
			Integer age = scanner.nextInt();
			result = studentController.upDate(alterId, null, age, null, null,null);
			upDateResult(result);
			break;
		}case 3 :{
			System.out.println("输入性别");
			String gender = scanner.next();
			result = studentController.upDate(alterId, null, null, gender, null,null);
			upDateResult(result);
			break;
		}case 4 : {
			System.out.println("输入地址");
			String address = scanner.next();
			result = studentController.upDate(alterId, null, null, null, address,null);
			upDateResult(result);
			break;
		}
		case 5 : {
			System.out.println("输入生日");
			String birthday = scanner.next();
			result = studentController.upDate(alterId, null, null, null, null,birthday);
			upDateResult(result);
			break;
		}
		default : {
			System.out.println("无效命令");
		}
		}
	
		
	}

	private void upDateResult(int result) {
		if (result > 0) {
			System.out.println("修改成功");
		} else {
			System.out.println("修改失败");
		}
	}

	private void deleteById() {
		findAll();
		System.out.println("请输入要删除的id");
		int id = scanner.nextInt();
		int result = studentController.deleteById(id);
		if (result == 1) {
			System.out.println("删除成功");
		} else {
			System.out.println("没有该生");
		}
	}

	private void add() {
		while (true) {
		System.out.println("请输入学生的姓名");
		String name = scanner.next();
		System.out.println("请输入学生的年龄");
		Integer age = scanner.nextInt();
		System.out.println("请输入学生的性别");
		String gender = scanner.next();
		System.out.println("请输入学生的地址");
		String address = scanner.next();
		System.out.println("请输入学生的生日");
		String biythday = scanner.next();
		
		
		boolean result = false;
		try {
			result = studentController.add(name,age,gender,address,biythday);
		} catch (NameReapeatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result) {
			System.out.println("添加成功");
		}else {
			System.out.println("添加失败");
		}
		System.out.println("结束请输入0,继续请输入1");
		int endNum =scanner.nextInt();
		
		if (endNum == 0 ) {
			break;
		
			}
		}
	}

	public void findAll() {
		List<Student> list = studentController.findAll();
		for (Student student : list) {
			System.out.println(student);
		}
	}
}
