package com.library.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.library.dao.BookTypeDao;
import com.library.model.BookType;
import com.library.service.BookTypeService;

@Service
public class BookTypeServiceImpl implements BookTypeService {

	private BookTypeDao bookTypeDao;

	public void setBookTypeDao(BookTypeDao bookTypeDao) {
		this.bookTypeDao = bookTypeDao;
	}

	@Override
	public int getBookTypeCount(Map<String, Object> clausesMap) {
		return bookTypeDao.getBookTypeCount(clausesMap);
	}

	@Override
	public List<BookType> getBookType(Map<String, Object> clausesMap) {
		return bookTypeDao.getBookType(clausesMap);
	}

	@Override
	public void addBookType(BookType bookType) {
		bookTypeDao.addBookType(bookType);		
	}

	@Override
	public void editBookType(BookType bookType) {
		bookTypeDao.editBookType(bookType);		
	}

	@Override
	public void deleteBookType(int id) {
		bookTypeDao.deleteBookType(id);
	}

}
