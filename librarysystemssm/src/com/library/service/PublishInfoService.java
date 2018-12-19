package com.library.service;

import java.util.List;
import java.util.Map;

import com.library.model.PublishInfo;

public interface PublishInfoService {

	//查询出版社信息
	List<PublishInfo> getPublishInfo();

	//分页查询出版社信息
	List<PublishInfo> findPublishInfo(Map<String, Object> clausesMap);

	//查询出版社信息的总数
	int getPublishInfoCount();

	//新增出版社信息
	void addPublishInfo(PublishInfo publishInfo);

	//修改出版社信息
	void editPublishInfo(PublishInfo publishInfo);

	//删除出版社信息
	void deletePublishInfo(String ISBN);

}
