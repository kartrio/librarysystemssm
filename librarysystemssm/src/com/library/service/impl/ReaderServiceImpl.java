package com.library.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.library.dao.ReaderDao;
import com.library.model.ReaderInfo;
import com.library.service.ReaderService;

@Service
public class ReaderServiceImpl implements ReaderService {
	private ReaderDao readerDao;

	public void setReaderDao(ReaderDao readerDao) {
		this.readerDao = readerDao;
	}

	public ReaderInfo queryReaderByNameAndPwd(Map<String, Object> infoMap) {
		return this.readerDao.queryReaderByNameAndPwd(infoMap);
	}

	@Override
	public List<ReaderInfo> getReaderInfo(Map<String, Object> clausesMap) {
		return readerDao.getReaderInfo(clausesMap);
	}

	@Override
	public int getReaderInfoCount() {
		return readerDao.getReaderInfoCount();
	}

	@Override
	public void deleteReaderInfo(int id) {
		readerDao.deleteReaderInfo(id);		
	}

	@Override
	public void addReaderInfo(Map<String, Object> infoMap) {
		readerDao.addReaderInfo(infoMap);		
	}

	@Override
	public void updateReaderInfo(Map<String, Object> clausesMap) {
		readerDao.updateReaderInfo(clausesMap);
	}
}
