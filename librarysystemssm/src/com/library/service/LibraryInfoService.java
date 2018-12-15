package com.library.service;

import java.util.Map;

import com.library.model.LibraryInfo;

public interface LibraryInfoService {

	//查询图书馆信息
	LibraryInfo getLibraryInfo();

	//修改图书馆信息
	void updateLibraryInfo(Map<String, Object> clausesMap);
}
