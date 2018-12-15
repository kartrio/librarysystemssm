package com.library.service.impl;

import org.springframework.stereotype.Service;

import com.library.dao.ParameterInfoDao;
import com.library.model.ParameterInfo;
import com.library.service.ParameterInfoService;

@Service
public class ParameterInfoServiceImpl implements ParameterInfoService {

	private ParameterInfoDao parameterInfoDao;

	public void setParameterInfoDao(ParameterInfoDao parameterInfoDao) {
		this.parameterInfoDao = parameterInfoDao;
	}

	@Override
	public ParameterInfo findParameterInfo() {
		return parameterInfoDao.findParameterInfo();
	}

	@Override
	public void updateParameterInfo(ParameterInfo parameterInfo) {
		parameterInfoDao.updateParameterInfo(parameterInfo);
	}

}
