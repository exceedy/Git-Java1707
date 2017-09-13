package com.situ.student.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.situ.student.dao.ICouresDao;
import com.situ.student.pojo.Banji;
import com.situ.student.pojo.Coures;
import com.situ.student.util.JdbcUtil;

public class CouresDaoImpl implements ICouresDao {
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;
	@Override
	public List<Coures> getCoures() {
		List<Coures> list = new ArrayList<Coures>();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select b.name  as banji_name, c.name as coures_name from banji as b left join banji_coures as bc on  b.id = bc.banji_id left join coures as c on bc.coure_id = c.id ;";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String banjiName = resultSet.getString("banji_name");
				String name = resultSet.getString("coures_name");
				Coures coures = new Coures(name, banjiName);
				list.add(coures);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public Integer getTotalCount() {
		int count = 0;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select count(*) from coures;"; 
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				count = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}
		return count;
	}
	@Override
	public List<Coures> getBanji(int index, int pageSize) {
		List <Coures> list = new ArrayList<Coures>();
		try {
			connection  = JdbcUtil.getConnection();
			String sql = "SELECT c.id,c.name,COUNT(bc.banji_id) AS COUNT ,grade FROM coures AS c LEFT JOIN banji_coures AS bc ON c.id = bc.coure_id LEFT JOIN banji AS b ON bc.banji_id = b.id GROUP BY c.name limit ?,?;";
			preparedStatement= connection.prepareStatement(sql);
			preparedStatement .setInt(1, index);
			preparedStatement.setInt(2, pageSize);
			resultSet = preparedStatement.executeQuery();
			while ( resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				Integer count = resultSet.getInt("count");
				Integer grade = resultSet.getInt("grade");
				Coures coures = new Coures(String.valueOf(id), name, grade, count);
				list.add(coures);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public int deleteCoures(int parseInt) {
		int result = 0;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "delete from coures where id =?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, parseInt);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement);
		}
		return result;
	}
	@Override
	public Coures getCouresById(int id) {
		Coures coures = new Coures();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select id,name,grade from coures where id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer resultId = resultSet.getInt("id");
				String name = resultSet.getString("name");
				Integer grade = resultSet.getInt("grade");
				coures.setId(String.valueOf(resultId));
				coures.setName(name);
				coures.setGrade(grade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}
		return coures;
	}
	@Override
	public int updateCoures(Coures coures) {
		int result = 0;
		String id  = coures.getId();
		String name = coures.getName();
		Integer grade = coures.getGrade();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "update coures set name = ? , grade = ? where id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, grade);
			preparedStatement.setInt(3, Integer.parseInt(id));
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement);
		}
		return result;
	}
	@Override
	public int addCoures(Coures coures) {
		int result = 0;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "insert into coures(name,grade) values(?,?);";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, coures.getName());
			preparedStatement.setInt(2, coures.getGrade());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public List<Coures> getCouresList() {
		List<Coures> list = new ArrayList<Coures>();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select * from coures;";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				Coures coures = new Coures();
				coures.setId(String.valueOf(id));
				coures.setName(name);
				list.add(coures);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
