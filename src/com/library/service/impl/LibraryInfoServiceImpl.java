package com.library.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.library.dao.LibraryInfoDao;
import com.library.model.LibraryInfo;
import com.library.service.LibraryInfoService;

@Service
public class LibraryInfoServiceImpl implements LibraryInfoService {

	private LibraryInfoDao libraryInfoDao;

	public void setLibraryInfoDao(LibraryInfoDao libraryInfoDao) {
		this.libraryInfoDao = libraryInfoDao;
	}

	@Override
	public LibraryInfo getLibraryInfo() {
		return libraryInfoDao.getLibraryInfo();
	}

	@Override
	public void updateLibraryInfo(Map<String, Object> clausesMap) {
		libraryInfoDao.updateLibraryInfo(clausesMap);
	}

}
