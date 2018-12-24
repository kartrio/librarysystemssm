package com.library.service;

import java.util.List;
import java.util.Map;

import com.library.model.ApplyInfo;

public interface ApplyInfoService {

	//新增办证信息
	void addApplyInfo(ApplyInfo applyInfo);

    //分页查询办证信息
	List<ApplyInfo> getApplyInfo(Map<String, Object> clausesMap);

	//查询指定条件的办证信息的总数
	int getApplyInfoCount(Map<String, Object> clausesMap);

	//更新申请信息
	void updateApplyInfo(Map<String, Object> clausesMap);

	void deleteApplyInfo(Integer id);

}
