package com.library.dao;

import java.util.List;
import java.util.Map;

import com.library.model.Bookcase;

public interface BookcaseDao {

	//分页查询书架信息
	List<Bookcase> getBookcase(Map<String, Object> clausesMap);

	//查询书架的总数
	int getBookcaseCount();

	//新增书架信息
	void addBookcase(Bookcase bookcase);

	//修改书架信息
	void editBookcase(Bookcase bookcase);

	//删除书架信息
	void deleteBookcase(int id);

}
