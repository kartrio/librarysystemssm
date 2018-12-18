package com.library.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.library.dao.ApplyInfoDao;
import com.library.model.ApplyInfo;
import com.library.service.ApplyInfoService;

@Service
public class ApplyInfoServiceImpl implements ApplyInfoService {

	private ApplyInfoDao applyInfoDao;

	public void setApplyInfoDao(ApplyInfoDao applyInfoDao) {
		this.applyInfoDao = applyInfoDao;
	}

	@Override
	public void addApplyInfo(ApplyInfo applyInfo) {
		applyInfoDao.addApplyInfo(applyInfo);
	}

	@Override
	public List<ApplyInfo> getApplyInfo(Map<String, Object> clausesMap) {
		return applyInfoDao.getApplyInfo(clausesMap);
	}

	@Override
	public int getApplyInfoCount(Map<String, Object> clausesMap) {
		return applyInfoDao.getApplyInfoCount(clausesMap);
	}

	@Override
	public void updateApplyInfo(Map<String, Object> clausesMap) {
		applyInfoDao.updateApplyInfo(clausesMap);		
	}

	@Override
	public void deleteApplyInfo(Integer id) {
		applyInfoDao.deleteApplyInfo(id);
	}

}
