package com.library.dao;

import java.util.List;
import java.util.Map;

import com.library.model.PublishInfo;

public interface PublishInfoDao {
	// 查询出版社信息
	List<PublishInfo> getPublishInfo();

	List<PublishInfo> findPublishInfo(Map<String, Object> clausesMap);

	int getPublishInfoCount();

	void addPublishInfo(PublishInfo publishInfo);

	void editPublishInfo(PublishInfo publishInfo);

	void deletePublishInfo(String ISBN);
}
