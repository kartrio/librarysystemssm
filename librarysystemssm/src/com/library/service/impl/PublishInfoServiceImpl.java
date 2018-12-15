package com.library.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.library.dao.PublishInfoDao;
import com.library.model.PublishInfo;
import com.library.service.PublishInfoService;

@Service
public class PublishInfoServiceImpl implements PublishInfoService{

	private PublishInfoDao publishInfoDao;
	
	public void setPublishInfoDao(PublishInfoDao publishInfoDao) {
		this.publishInfoDao = publishInfoDao;
	}

	@Override
	public List<PublishInfo> getPublishInfo() {
		return publishInfoDao.getPublishInfo();
	}

}
