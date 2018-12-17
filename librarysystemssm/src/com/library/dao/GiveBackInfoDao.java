package com.library.dao;

import java.util.List;
import java.util.Map;

import com.library.model.GiveBackInfo;

public interface GiveBackInfoDao {
	// 新增书籍归还信息
	void insertGiveBackInfo(Map<String, Object> clausesMap);

	// 指定条件分页查询已归还的书籍信息
	List<GiveBackInfo> getGiveBackInfo(Map<String, Object> clausesMap);

	// 指定条件查询已归还书籍信息的总数
	int getGiveBackInfoCount(Map<String, Object> clausesMap);

	// 修改归还信息
	void updateGiveBackInfo(Map<String, Object> clausesMap);
}
