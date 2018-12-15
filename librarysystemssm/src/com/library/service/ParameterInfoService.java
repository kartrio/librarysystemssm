package com.library.service;

import com.library.model.ParameterInfo;

public interface ParameterInfoService {

	//查询参数信息
	ParameterInfo findParameterInfo();

	//修改参数信息
	void updateParameterInfo(ParameterInfo parameterInfo);

}
