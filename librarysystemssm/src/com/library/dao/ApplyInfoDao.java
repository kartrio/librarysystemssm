package com.library.dao;

import java.util.List;
import java.util.Map;

import com.library.model.ApplyInfo;

public interface ApplyInfoDao {
	// 新增办证信息
	void addApplyInfo(ApplyInfo applyInfo);

	//分页查询办证信息
	List<ApplyInfo> getApplyInfo(Map<String, Object> clausesMap);

	//根据指定条件查询办证信息的总数
	int getApplyInfoCount(Map<String, Object> clausesMap);

	void updateApplyInfo(Map<String, Object> clausesMap);

	void deleteApplyInfo(Integer id);
}
