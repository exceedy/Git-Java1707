package com.situ.student.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.situ.student.dao.IStudentDao;
import com.situ.student.pojo.Admin;
import com.situ.student.pojo.Banji;
import com.situ.student.pojo.Student;
import com.situ.student.util.JdbcUtil;
import com.situ.student.vo.SearchCondition;

public class StudentDaoMysqlImpl implements IStudentDao {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	@Override
	public int add(Student student) {
		
		int result = 0 ;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "insert into student(name,age,gender,address,birthday,banji_id) values (?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,student.getName());
			preparedStatement.setInt(2,student.getAge());
			preparedStatement.setString(3,student.getGender());
			preparedStatement.setString(4,student.getAddress());
			preparedStatement.setDate(5,new java.sql.Date(student.getBirthday().getTime()));
			preparedStatement.setInt(6, student.getBanji_id());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement);
		}
		return result;
	}

	@Override
	public int deleteById(int id) {
		int result = 0;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "delete from student where id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement);
		}
		return result;
	}

	@Override
	public int update(Student student) {
		int result = 0;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "update student set name=?, age = ?, gender = ?, address = ?, birthday = ?,banji_id = ? where id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getAge());
			preparedStatement.setString(3, student.getGender());
			preparedStatement.setString(4, student.getAddress());
			preparedStatement.setDate(5, new java.sql.Date((student.getBirthday()).getTime()));
			preparedStatement.setInt(6, student.getBanji_id());
			preparedStatement.setInt(7, student.getId());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	/*	try {
			  if (student.getName() != null) {
				connection = JdbcUtil.getConnection();
				String sql = "update student set name = ?  where id = ?;";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, student.getName());
				preparedStatement.setInt(2, student.getId());
				result = preparedStatement.executeUpdate();
				
			  } else if (student.getAge() != null) {
				  connection = JdbcUtil.getConnection();
					String sql = "update student set age = ?  where id = ?;";
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setInt(1, student.getAge());
					preparedStatement.setInt(2, student.getId());
					result = preparedStatement.executeUpdate();
					
			  }else if (student.getGender() != null) {
				  connection = JdbcUtil.getConnection();
					String sql = "update student set gender = ?  where id = ?;";
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setString(1, student.getGender());
					preparedStatement.setInt(2, student.getId());
					result = preparedStatement.executeUpdate();
					
			  }else if (student.getAddress() != null) {
				  connection = JdbcUtil.getConnection();
					String sql = "update student set address = ?  where id = ?;";
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setString(1, student.getAddress());
					preparedStatement.setInt(2, student.getId());
					result = preparedStatement.executeUpdate();
					
			  } else if (student.getBirthday() != null) {
				  connection = JdbcUtil.getConnection();
					String sql = "update student set birthday = ?  where id = ?;";
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setDate(1, new java.sql.Date( student.getBirthday().getTime()));
					preparedStatement.setInt(2, student.getId());
					result = preparedStatement.executeUpdate();
				}  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement);
		}
		return result;
			  */
	
	}

	@Override
	public List<Student> findAll() {
		
		List<Student> studentList = new ArrayList<Student>();
		
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select id,name,age,gender,address,birthday from student";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt("id"); 
				String name = resultSet.getString("name");
				String gender = resultSet.getString("gender");
				String address = resultSet.getString("address");
				Integer age = resultSet.getInt("age");
				Date birthday = resultSet.getDate("birthday");
				Student student = new Student(id, name, age, gender, address,birthday);
				studentList.add(student);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}
		return studentList;
	}



	@Override
	public boolean chekName(String name) {
		       boolean isExits = false;
				try {
					connection = JdbcUtil.getConnection();
					String sql = "select id from student where name =?";
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setString(1, name);
					resultSet = preparedStatement.executeQuery();
					while(resultSet.next()) {
						 isExits = true;
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					JdbcUtil.close(connection, preparedStatement, resultSet);
				}
				return isExits;
	

}

	@Override
	public List<Student> findByName(String name) {
		List<Student> studentList = new ArrayList<Student>();
		Student student = new Student();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select id,name,age,gender,address,birthday from student where name = ?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,name);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String resultName = resultSet.getString("name");
				Integer resultAge = resultSet.getInt("age");
				String resultGender = resultSet.getString("gender");
				String resultAddress = resultSet.getString("address");
				String date = resultSet.getString("birthday");
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date birthday = null;
				try {
					birthday = simpleDateFormat.parse(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				student = new Student(id, resultName, resultAge, resultGender, resultAddress,birthday);
				studentList.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}
		return studentList;
	}

	@Override
	public List<Student> findByGender(String gender) {
		List<Student> studentList = new ArrayList<Student>();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select id,name,age,gender,address,birthday from student where gender = ?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,gender);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String resultName = resultSet.getString("name");
				Integer resultAge = resultSet.getInt("age");
				String resultGender = resultSet.getString("gender");
				String resultAddress = resultSet.getString("address");
				String date = resultSet.getString("birthday");
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date birthday = null;
				try {
					birthday = simpleDateFormat.parse(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Student student = new Student(id, resultName, resultAge, resultGender, resultAddress,birthday);
				studentList.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}
		return studentList;
		
	}
	
	@Override
	public List<Student> findByAddress(String address) {
		List<Student> studentList = new ArrayList<Student>();
		Student student = new Student();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select id,name,age,gender,address,birthday from student where address = ?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,address);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String resultName = resultSet.getString("name");
				Integer resultAge = resultSet.getInt("age");
				String resultGender = resultSet.getString("gender");
				String resultAddress = resultSet.getString("address");
				String date = resultSet.getString("birthday");
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date birthday = null;
				try {
					birthday = simpleDateFormat.parse(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				student = new Student(id, resultName, resultAge, resultGender, resultAddress,birthday);
				studentList.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}
		return studentList;
	}

	@Override
	public List<Student> findByAge(Integer age) {
		List<Student> studentList = new ArrayList<Student>();
		Student student = new Student();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select id,name,age,gender,address,birthday from student where age = ?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,age);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String resultName = resultSet.getString("name");
				Integer resultAge = resultSet.getInt("age");
				String resultGender = resultSet.getString("gender");
				String resultAddress = resultSet.getString("address");
				String date = resultSet.getString("birthday");
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date birthday = null;
				try {
					birthday = simpleDateFormat.parse(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				student = new Student(id, resultName, resultAge, resultGender, resultAddress,birthday);
				studentList.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}
		return studentList;
	}

	@Override
	public List<Student> chekDate(Date beginDate, Date endDate) {
		List<Student> list = new ArrayList<Student>();
		
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select id,name,gender,age,address,birthday from student where birthday between ? and ?; ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDate(1, new java.sql.Date(beginDate.getTime()));
			preparedStatement.setDate(2,new java.sql.Date(endDate.getTime()));
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String gender = resultSet.getString("gender");
				Integer age = resultSet.getInt("age");
				String address = resultSet.getString("address");
				Date birthday = resultSet.getDate("birthday");
				Student student = new Student(id, name, age, gender, address, birthday);
				list.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}
		return list;
	}

	@Override
	public Student findById(Integer id) {
		Student student = new Student();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select student.id,student.name,age,gender,address,birthday,banji_id,banji.name as banjiName from student left join banji on student.banji_id=banji.id where student.id = ?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String resultName = resultSet.getString("name");
				Integer resultAge = resultSet.getInt("age");
				String resultGender = resultSet.getString("gender");
				String resultAddress = resultSet.getString("address");
				Date resultbirthday = resultSet.getDate("birthday");
				Integer banji_id = resultSet.getInt("banji_id");
				String banjiName = resultSet.getString("banjiName");
				Banji banji = new Banji(String.valueOf(banji_id),banjiName);
				student = new Student(id, resultName, resultAge, resultGender, resultAddress,resultbirthday,banji_id,banji);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}
		return student;
	}

	@Override
	public List<Student> specialSelect(SearchCondition searchCondition) {
		List<Student> list = new ArrayList<Student>();
		String specialName = searchCondition.getName();
		String specialAge = searchCondition.getAge();
		String specialAddress = searchCondition.getAddress();
		String specialGender = searchCondition.getGender();
		String specialBirthday = searchCondition.getBirthday();
		List<String> listCondition = new ArrayList<String>();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select * from student where 1=1";
			if (specialName != null && !specialName.equals("")) {
				sql += " and name like ?";
				listCondition.add("%" + specialName + "%");
			}  
			if (specialAge != null && !specialAge.equals("")) {
				sql += " and age = ?";
				listCondition.add(specialAge);
			} 
			if (specialAddress != null && !specialAddress.equals("")) {
				sql += " and address = ?";
				listCondition.add(specialAddress);
			}  
			if (specialGender != null && !specialGender.equals("")) {
				sql += " and gender = ?";
				listCondition.add(specialGender);
			} 
			if (specialBirthday != null && !specialBirthday.equals("")) {
				sql += " and birthday = ?";
				listCondition.add(specialBirthday);
			}
			sql += " ;";
			preparedStatement = connection.prepareStatement(sql);
			
			for (int i = 0; i < listCondition.size(); i++) {
				preparedStatement.setObject(i + 1, listCondition.get(i));
			}
			
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String gender = resultSet.getString("gender");
				Integer age = resultSet.getInt("age");
				String address = resultSet.getString("address");
				Date birthday = resultSet.getDate("birthday");
				Student student = new Student(id, name, age, gender, address, birthday);
				list.add(student);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}
		return list;
	}

	@Override
	public Integer getTotalCount() {
		int count = 0;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select count(*) from student;";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				count = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Student> getPageBean(Integer pageIndex, Integer pageSize) {
		List<Student> list = new ArrayList<Student>();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select student.id,student.name,gender,age,address,birthday,banji_id,banji.name as banji_name from student left join banji on student.banji_id=banji.id limit ?,?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, pageIndex);
			preparedStatement.setInt(2, pageSize);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String gender = resultSet.getString("gender");
				Integer age = resultSet.getInt("age");
				String address = resultSet.getString("address");
				Date birthday = resultSet.getDate("birthday");
				Integer banjiId = resultSet.getInt("banji_id");
				String banjiName = resultSet.getString("banji_name");
				Banji banji = new Banji(String.valueOf(banjiId),banjiName);
				Student student = new Student(id, name, age, gender, address, birthday,banjiId,banji);
				list.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Integer getTotalCountCondition(SearchCondition searchCondition) {
			String specialName = searchCondition.getName();
			String specialAge = searchCondition.getAge();
			String specialAddress = searchCondition.getAddress();
			String specialGender = searchCondition.getGender();
			String specialBirthday = searchCondition.getBirthday();
			String speciaBanjiId= searchCondition.getBanjiId();
			List<String> listCondition = new ArrayList<String>();
			int count = 0;
			try {
				connection = JdbcUtil.getConnection();
				String sql = "select count(*) from student left join banji on student.banji_id = banji.id where 1=1";
				if (specialName != null && !specialName.equals("")) {
					sql += " and name like ?";
					listCondition.add("%" + specialName + "%");
				}  
				if (specialAge != null && !specialAge.equals("")) {
					sql += " and age = ?";
					listCondition.add(specialAge);
				} 
				if (specialAddress != null && !specialAddress.equals("")) {
					sql += " and address = ?";
					listCondition.add(specialAddress);
				}  
				if (specialGender != null && !specialGender.equals("")) {
					sql += " and gender = ?";
					listCondition.add(specialGender);
				} 
				if (specialBirthday != null && !specialBirthday.equals("")) {
					sql += " and birthday = ?";
					listCondition.add(specialBirthday);
				}
				if (speciaBanjiId != null && !speciaBanjiId.equals("")) {
					sql += "and banji_id = ?";
					listCondition.add(speciaBanjiId);
				}
				sql += " ;";
				preparedStatement = connection.prepareStatement(sql);
				
				for (int i = 0; i < listCondition.size(); i++) {
					preparedStatement.setObject(i + 1, listCondition.get(i));
				}
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					count  = resultSet.getInt(1);
					
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;

	}

	@Override
	public List<Student> getPageBeanCondition(SearchCondition searchCondition) {
		List<Student> list = new ArrayList<Student>();
		String specialName = searchCondition.getName();
		String specialAge = searchCondition.getAge();
		String specialAddress = searchCondition.getAddress();
		String specialGender = searchCondition.getGender();
		String specialBirthday = searchCondition.getBirthday();
		String speciaBanjiId = searchCondition.getBanjiId();
		Integer pageIndex = searchCondition.getPageIndex();
		Integer pageSize = searchCondition.getPageSize();
		List<String> listCondition = new ArrayList<String>();
		int index = (pageIndex - 1) * pageSize;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select student.id,student.name,age,gender,address,birthday,banji_id,banji.name as banjiName from student left join banji on student.banji_id = banji.id where 1=1";
			if (specialName != null && !specialName.equals("")) {
				sql += " and name like ?";
				listCondition.add("%" + specialName + "%");
			}  
			if (specialAge != null && !specialAge.equals("")) {
				sql += " and age = ?";
				listCondition.add(specialAge);
			} 
			if (specialAddress != null && !specialAddress.equals("")) {
				sql += " and address = ?";
				listCondition.add(specialAddress);
			}  
			if (specialGender != null && !specialGender.equals("")) {
				sql += " and gender = ?";
				listCondition.add(specialGender);
			} 
			if (specialBirthday != null && !specialBirthday.equals("")) {
				sql += " and birthday = ?";
				listCondition.add(specialBirthday);
			}
			if (speciaBanjiId != null && !speciaBanjiId.equals("")) {
				sql += " and banji_id = ?";
				listCondition.add(speciaBanjiId);
			}
			sql += " limit ?,?;";
			preparedStatement = connection.prepareStatement(sql);
			
			for (int i = 0; i < listCondition.size(); i++) {
				preparedStatement.setObject(i + 1, listCondition.get(i));
			}
			preparedStatement.setInt(listCondition.size() + 1, index);
			preparedStatement.setInt(listCondition.size() + 2, pageSize);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String gender = resultSet.getString("gender");
				Integer age = resultSet.getInt("age");
				String address = resultSet.getString("address");
				Date birthday = resultSet.getDate("birthday");
				Integer banjiId = resultSet.getInt("banji_id");
				String banjiName = resultSet.getString("banjiName");
				Banji banji = new Banji(String.valueOf(banjiId), banjiName);
				Student student = new Student(id, name, age, gender, address, birthday,banjiId,banji);
				list.add(student);
			}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally{
		JdbcUtil.close(connection, preparedStatement, resultSet);
	}
		return list;
	}

	@Override
	public int addAdmin(Admin admin) {
		int result = 0;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "insert into account(ursename,password) values(?,?);";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, admin.getUrsename());
			preparedStatement.setString(2, admin.getPassword());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement);;
		}
		return result;
	}

	@Override
	public boolean isExsitAdmin(String ursename) {
		boolean result = false;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select * from account where ursename = ?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, ursename);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()){
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Admin exsitUrsename(String urname) {
		Admin admin = new Admin();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select * from account where ursename = ?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, urname);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()){
				String ursename = resultSet.getString("ursename");
				String password = resultSet.getString("password");
				admin.setUrsename(ursename);
				admin.setPassword(password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}
		return admin;
	}

	@Override
	public List<Banji> getBanjiList() {
		List<Banji> banjiList = new ArrayList<Banji>();
		  try {
			connection = JdbcUtil.getConnection();
			String sql="select * from banji;";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer intId = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String id = String.valueOf(intId);
				Banji banji = new Banji(id, name);
				banjiList.add(banji);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return banjiList;
	}
}
