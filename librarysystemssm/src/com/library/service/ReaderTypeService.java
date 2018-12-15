package com.library.service;

import java.util.List;
import java.util.Map;

import com.library.model.ReaderType;

public interface ReaderTypeService {

	//分页查询读者类别信息
	List<ReaderType> getReaderType(Map<String, Object> clausesMap);

	//查询读者类别总数
	int getReaderTypeCount();

	//新增读者类别信息
	void addReaderType(ReaderType readerType);

	//修改读者类别信息
	void editReaderType(ReaderType readerType);

	//删除读者类别信息
	void deleteReaderType(int id);

}
