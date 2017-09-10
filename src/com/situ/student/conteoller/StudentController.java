package com.situ.student.conteoller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.situ.student.exception.NameReapeatException;
import com.situ.student.pojo.Student;
import com.situ.student.service.IStudentService;
import com.situ.student.service.StudentServiceImpl;


public class StudentController {
	private IStudentService studentService = new StudentServiceImpl();
	
	public List<Student> findAll() {
		return studentService.findAll();
	}

	public int deleteById(int id ) {
		int result = studentService.deleteById(id);
		return result;
	}

	public boolean add(String name, Integer age, String gender, String address, String biythday) throws NameReapeatException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday =null;
		try {
			birthday = simpleDateFormat.parse(biythday);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Student student = new Student(name,age,gender,address,birthday);
		return studentService.add(student);
	}

	public int upDate(Integer id,String name, Integer age, String gender, String address, String birthday) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(birthday);
		Date birthda = null;
		try {
			birthda = simpleDateFormat.parse(birthday);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Student student = new Student(id,name,age,gender,address,birthda);
		return studentService.upDate(student);
		
	}

	public List<Student> findByNmae(String name) {
		
		return studentService.findByName(name);
		
	}

	public List<Student> findByGender(String gender) {
		return studentService.findByGender(gender);
	}

	public List<Student> findByAge(Integer age) {
		return studentService.findByAge(age);
	}

	public List<Student> findByAddress(String address) {
		return studentService.findAddress(address);
	}

	public List<Student> findByDate(String beginDate, String endDate) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date beginBirthday = null;
		Date endBirthday = null;
		try {
			beginBirthday = simpleDateFormat.parse(beginDate);
			endBirthday = simpleDateFormat.parse(endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentService.findByDate(beginBirthday,endBirthday);
	}


}
