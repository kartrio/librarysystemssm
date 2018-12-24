package com.library.dao;

import java.util.List;
import java.util.Map;

import com.library.model.BookInfo;

public interface BookInfoDao {
	//根据书名和作者名查询书籍信息
	List<BookInfo> findBookInfo(Map<String, Object> clausesMap);

	//删除书籍信息
	void deleteBookInfo(int id);

    //新增书籍信息
	void addBookInfo(Map<String, Object> clausesMap);

	void editBookInfo(Map<String, Object> clausesMap);

	int getBookInfoCount(Map<String, Object> clausesMap);
}
