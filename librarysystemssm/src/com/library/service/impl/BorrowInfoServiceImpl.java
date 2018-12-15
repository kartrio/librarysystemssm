package com.library.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.library.dao.BorrowInfoDao;
import com.library.model.BorrowInfo;
import com.library.service.BorrowInfoService;

@Service
public class BorrowInfoServiceImpl implements BorrowInfoService {

	private BorrowInfoDao borrowInfoDao;
	
	public void setBorrowInfoDao(BorrowInfoDao borrowInfoDao) {
		this.borrowInfoDao = borrowInfoDao;
	}

	@Override
	public List<BorrowInfo> getBorrowInfo(Map<String, Object> clausesMap) {
		return borrowInfoDao.getBorrowInfo(clausesMap);
	}

	@Override
	public int getBorrowInfoCount() {
		return borrowInfoDao.getBorrowInfoCount();
	}

	@Override
	public void updateBorrowInfo(Map<String, Object> clausesMap) {
		borrowInfoDao.updateBorrowInfo(clausesMap);		
	}

	@Override
	public void addBorrowInfo(Map<String, Object> clauseMap) {
		borrowInfoDao.addBorrowInfo(clauseMap);
	}

}
