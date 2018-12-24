package com.library.service;

import java.util.List;
import java.util.Map;

import com.library.model.BookInfo;

public interface BookInfoService {
	
	//根据书名和作者名查询书籍信息
	List<BookInfo> findBookInfo(Map<String, Object> clausesMap);

	//删除书籍信息
	void deleteBookInfo(int id);

	void addBookInfo(Map<String, Object> clausesMap);

	void editBookInfo(Map<String, Object> clausesMap);

	//获取书籍总数
	int getBookInfoCount(Map<String, Object> clausesMap);
}
