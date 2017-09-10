package com.situ.student.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.situ.student.dao.ICouresDao;
import com.situ.student.pojo.Coures;
import com.situ.student.util.JdbcUtil;

public class CouresDaoImpl implements ICouresDao {
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
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

}
