package com.library.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.library.dao.BookcaseDao;
import com.library.model.Bookcase;
import com.library.service.BookcaseService;
@Service
public class BookcaseServiceImpl implements BookcaseService {

	private BookcaseDao bookcaseDao;
	
	public void setBookcaseDao(BookcaseDao bookcaseDao) {
		this.bookcaseDao = bookcaseDao;
	}

	@Override
	public List<Bookcase> getBookcase(Map<String, Object> clausesMap) {
		return bookcaseDao.getBookcase(clausesMap);
	}

	@Override
	public int getBookcaseCount() {
		return bookcaseDao.getBookcaseCount();
	}

	@Override
	public void addBookcase(Bookcase bookcase) {
		bookcaseDao.addBookcase(bookcase);	
	}

	@Override
	public void editBookcase(Bookcase bookcase) {
		bookcaseDao.editBookcase(bookcase);
	}

	@Override
	public void deleteBookcase(int id) {
		bookcaseDao.deleteBookcase(id);
	}

}
