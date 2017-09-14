package com.situ.student.service;

import java.util.List;
import java.util.Map;

import com.situ.student.pojo.BanjiCoures;
import com.situ.student.vo.PageBean;

public interface IBanjiCouresService {

	int addBanjiCoures(BanjiCoures banjiCoures);

	int deleteBanjiCoures(BanjiCoures banjiCoures);

	PageBean<Map<String, Object>> getPageList(int pageIndex, int pageSize);

}
