package com.library.dao;

import java.util.List;

import com.library.model.PublishInfo;

public interface PublishInfoDao {
	//查询出版社信息
		List<PublishInfo> getPublishInfo();
}
