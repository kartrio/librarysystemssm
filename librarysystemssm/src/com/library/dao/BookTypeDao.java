package com.library.dao;

import java.util.List;
import java.util.Map;

import com.library.model.BookType;

public interface BookTypeDao {
	// 获取图书类别的总数
	int getBookTypeCount(Map<String, Object> clausesMap);

	// 分页查询图书类别信息
	List<BookType> getBookType(Map<String, Object> clausesMap);

	//新增图书类别信息
	void addBookType(BookType bookType);

	//修改图书类别信息
	void editBookType(BookType bookType);

	//删除图书类别信息
	void deleteBookType(int id);

}
