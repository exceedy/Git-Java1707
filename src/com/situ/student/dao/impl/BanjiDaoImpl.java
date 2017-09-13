package com.situ.student.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.situ.student.dao.IBanjiDao;
import com.situ.student.pojo.Banji;
import com.situ.student.pojo.Coures;
import com.situ.student.util.JdbcUtil;

public class BanjiDaoImpl implements IBanjiDao {
	Connection connection = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	@Override
	public Integer getTotalCount() {
		int count = 0;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select count(*) from banji;"; 
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				count = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	@Override
	public List<Banji> getBanji(int index, int pageSize) {
		List<Banji> list = new ArrayList<Banji>();
		
		try {
			connection = JdbcUtil.getConnection();
			String sql = "SELECT b.name,COUNT(student.banji_id) AS COUNT ,b.id  FROM banji AS b LEFT JOIN student ON b.id = student.banji_id GROUP BY b.name limit ?,?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, index);
			preparedStatement.setInt(2, pageSize);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				Integer count = resultSet.getInt("count");
				Banji banji = new Banji(String.valueOf(id), name, count);
				list.add(banji);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}
		return list;
	}
	@Override
	public void deleteAll(int parseInt) {
		try {
			connection = JdbcUtil.getConnection();
			String sql = "delete from banji where id =?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, parseInt);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement);
		}
	}
	@Override
	public int addbanji(String name) {
		int result = 0;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "insert into banji(name) values(?);";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public Banji getBanjiById(int id) {
		Banji banji = new Banji();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select id,name from banji where id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer resultId = resultSet.getInt("id");
				String name = resultSet.getString("name");
				banji.setId(String.valueOf(resultId));
				banji.setName(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}
		return banji;
	}
	@Override
	public int updatebanji(Banji banji) {
		int result = 0;
		String id  = banji.getId();
		String name = banji.getName();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "update banji set name = ? where id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, Integer.parseInt(id));
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement);
		}
		return result;
	}

}
