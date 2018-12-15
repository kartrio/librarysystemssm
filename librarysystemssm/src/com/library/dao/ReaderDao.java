package com.library.dao;

import java.util.List;
import java.util.Map;

import com.library.model.ReaderInfo;

public interface ReaderDao {
	ReaderInfo queryReaderByNameAndPwd(Map<String, Object> infoMap);

	// 分页查询读者信息
	List<ReaderInfo> getReaderInfo(Map<String, Object> clausesMap);

	// 获取读者的总数
	int getReaderInfoCount();

	// 删除读者信息
	void deleteReaderInfo(int id);

	// 添加读者信息
	void addReaderInfo(Map<String, Object> infoMap);
}
