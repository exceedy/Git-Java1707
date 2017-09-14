package com.situ.student.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.situ.student.dao.IBanjiCouresDao;
import com.situ.student.pojo.BanjiCoures;
import com.situ.student.util.JdbcUtil;
import com.situ.student.vo.ModelConvert;

public class BanjiCouresDaoImpl implements IBanjiCouresDao {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	Statement statement = null;
	@Override
	public int addBanjiCoures(BanjiCoures banjiCoures) {
		int result = 0;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "insert into banji_coures(banji_id,coure_id) values(?,?);";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, banjiCoures.getBanjiId());
			preparedStatement.setInt(2, banjiCoures.getCouresId());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement);
		}
		return result;
	}
	@Override
	public int deleteBanjiCoures(BanjiCoures banjiCoures) {
		int result = 0;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "delete from banji_coures where banji_id = ? and coure_id = ?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, banjiCoures.getBanjiId());
			preparedStatement.setInt(2, banjiCoures.getCouresId());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement);
		}

		return result;
	}
	@Override
	public int getTotalCount() {
		int count = 0;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select count(*) "
					+ "from student inner join banji on student.banji_id=banji.id "
					+ "inner join banji_coures on banji.id=banji_coures.banji_id "
					+ "inner join coures on banji_coures.coure_id=coures.id;";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				count = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, statement);
		}
		return count;
	}
	@Override
	public List<Map<String, Object>> getPageList(int index, int pageSize) {
		List<Map<String, Object>> list = null;
		try {
			connection = JdbcUtil.getConnection();
			String sql = " SELECT s.name AS student_name, b.name AS banji_name, c.name AS coures_name,c.grade "
					+ "FROM student s INNER JOIN banji b ON s.banji_id = b.id "
					+ "INNER JOIN banji_coures AS bc ON b.id=bc.banji_id "
					+ "INNER JOIN coures AS c ON bc.coure_id = c.id LIMIT ?,? ;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, index);
			preparedStatement.setInt(2, pageSize);
			resultSet = preparedStatement.executeQuery();
			list = ModelConvert.converList(resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
