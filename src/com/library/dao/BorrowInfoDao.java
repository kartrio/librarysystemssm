package com.library.dao;

import java.util.List;
import java.util.Map;

import com.library.model.BorrowInfo;

public interface BorrowInfoDao {
	// 分页查询图书借阅信息
	List<BorrowInfo> getBorrowInfo(Map<String, Object> clausesMap);

	// 查询图书借阅信息总条数
	int getBorrowInfoCount(Map<String, Object> clausesMap);

	//修改借阅信息
	void updateBorrowInfo(Map<String, Object> clausesMap);

	//新增借阅信息
	void addBorrowInfo(Map<String, Object> clauseMap);

	//删除借阅信息
	void deleteBorrowInfo(Integer id);
}
