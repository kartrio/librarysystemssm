package com.library.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.library.dao.BookInfoDao;
import com.library.model.BookInfo;
import com.library.service.BookInfoService;

@Service
public class BookInfoServiceImpl implements BookInfoService {

	private BookInfoDao bookInfoDao;

	public void setBookInfoDao(BookInfoDao bookInfoDao) {
		this.bookInfoDao = bookInfoDao;
	}

	@Override
	public List<BookInfo> findBookInfo(Map<String, Object> clausesMap) {
		return bookInfoDao.findBookInfo(clausesMap);
	}

	@Override
	public void deleteBookInfo(int id) {
		bookInfoDao.deleteBookInfo(id);
	}

	@Override
	public void addBookInfo(Map<String, Object> clausesMap) {
		bookInfoDao.addBookInfo(clausesMap);
	}

	@Override
	public void editBookInfo(Map<String, Object> clausesMap) {
		bookInfoDao.editBookInfo(clausesMap);
	}

	@Override
	public int getBookInfoCount(Map<String, Object> clausesMap) {
		return bookInfoDao.getBookInfoCount(clausesMap);
	}

}
