package com.library.service.impl;

import java.util.List;
import java.util.Map;

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

	@Override
	public List<PublishInfo> findPublishInfo(Map<String, Object> clausesMap) {
		return publishInfoDao.findPublishInfo(clausesMap);
	}

	@Override
	public int getPublishInfoCount() {
		return publishInfoDao.getPublishInfoCount();
	}

	@Override
	public void addPublishInfo(PublishInfo publishInfo) {
		publishInfoDao.addPublishInfo(publishInfo);		
	}

	@Override
	public void editPublishInfo(PublishInfo publishInfo) {
		publishInfoDao.editPublishInfo(publishInfo);	
	}

	@Override
	public void deletePublishInfo(String ISBN) {
		publishInfoDao.deletePublishInfo(ISBN);		
	}

}
