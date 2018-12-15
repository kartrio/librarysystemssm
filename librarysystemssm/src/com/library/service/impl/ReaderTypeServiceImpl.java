package com.library.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.library.dao.ReaderTypeDao;
import com.library.model.ReaderType;
import com.library.service.ReaderTypeService;

@Service
public class ReaderTypeServiceImpl implements ReaderTypeService {

	private ReaderTypeDao readerTypeDao;

	public void setReaderTypeDao(ReaderTypeDao readerTypeDao) {
		this.readerTypeDao = readerTypeDao;
	}

	@Override
	public List<ReaderType> getReaderType(Map<String, Object> clausesMap) {
		return readerTypeDao.getReaderType(clausesMap);
	}

	@Override
	public int getReaderTypeCount() {
		return readerTypeDao.getReaderTypeCount();
	}

	@Override
	public void addReaderType(ReaderType readerType) {
		readerTypeDao.addReaderType(readerType);
	}

	@Override
	public void editReaderType(ReaderType readerType) {
		readerTypeDao.editReaderType(readerType);
	}

	@Override
	public void deleteReaderType(int id) {
		readerTypeDao.deleteReaderType(id);
	}

}
