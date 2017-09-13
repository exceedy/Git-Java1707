package com.situ.student.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.situ.student.dao.IBanjiCouresDao;
import com.situ.student.pojo.BanjiCoures;
import com.situ.student.util.JdbcUtil;

public class BanjiCouresDaoImpl implements IBanjiCouresDao {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
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

}
