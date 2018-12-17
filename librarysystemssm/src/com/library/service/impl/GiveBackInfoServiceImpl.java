package com.library.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.library.dao.GiveBackInfoDao;
import com.library.model.GiveBackInfo;
import com.library.service.GiveBackInfoService;

@Service
public class GiveBackInfoServiceImpl implements GiveBackInfoService {

	private GiveBackInfoDao giveBackInfoDao;

	public void setGiveBackInfoDao(GiveBackInfoDao giveBackInfoDao) {
		this.giveBackInfoDao = giveBackInfoDao;
	}

	@Override
	public void insertGiveBackInfo(Map<String, Object> clausesMap) {
		giveBackInfoDao.insertGiveBackInfo(clausesMap);
	}

	@Override
	public List<GiveBackInfo> getGiveBackInfo(Map<String, Object> clausesMap) {
		return giveBackInfoDao.getGiveBackInfo(clausesMap);
	}

	@Override
	public int getGiveBackInfoCount(Map<String, Object> clausesMap) {
		return giveBackInfoDao.getGiveBackInfoCount(clausesMap);
	}

	@Override
	public void updateGiveBackInfo(Map<String, Object> clausesMap) {
		giveBackInfoDao.updateGiveBackInfo(clausesMap);
	}

}
