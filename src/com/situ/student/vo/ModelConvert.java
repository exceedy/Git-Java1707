package com.situ.student.vo;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Request;

public class ModelConvert {

	public static List<Map<String, Object>> converList(ResultSet resultSet) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			ResultSetMetaData md = resultSet.getMetaData();
			int count = md.getColumnCount();
			while (resultSet.next()) {
				Map<String, Object> map = new  HashMap<String, Object>();
				for (int i = 1; i <= count; i++) {
					map.put(md.getColumnLabel(i), resultSet.getObject(i));
				}
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if ( resultSet != null) {
				
				try {
					resultSet.close();
					resultSet = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;
	}

}
