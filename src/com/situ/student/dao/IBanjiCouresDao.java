package com.situ.student.dao;

import java.util.List;
import java.util.Map;

import com.situ.student.pojo.BanjiCoures;

public interface IBanjiCouresDao {

	int addBanjiCoures(BanjiCoures banjiCoures);

	int deleteBanjiCoures(BanjiCoures banjiCoures);

	int getTotalCount();

	List<Map<String, Object>> getPageList(int index, int pageSize);
		
	
}
