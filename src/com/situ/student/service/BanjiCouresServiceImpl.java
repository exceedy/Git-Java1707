package com.situ.student.service;

import com.situ.student.dao.IBanjiCouresDao;
import com.situ.student.dao.impl.BanjiCouresDaoImpl;
import com.situ.student.pojo.BanjiCoures;

public class BanjiCouresServiceImpl implements IBanjiCouresService {
	IBanjiCouresDao banjiCouresDao = new BanjiCouresDaoImpl();
	@Override
	public int addBanjiCoures(BanjiCoures banjiCoures) {
		return banjiCouresDao.addBanjiCoures(banjiCoures);
	}
	@Override
	public int deleteBanjiCoures(BanjiCoures banjiCoures) {
		return banjiCouresDao.deleteBanjiCoures(banjiCoures);
	}

}
