package com.library.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.library.dao.BookTypeDao;
import com.library.model.BookType;

public class BookTypeDaoImpl implements BookTypeDao {

	private SqlSessionFactory sqlSessionFactory;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public int getBookTypeCount(Map<String, Object> clausesMap) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectOne("getBookTypeCount", clausesMap);
	}

	@Override
	public List<BookType> getBookType(Map<String, Object> clausesMap) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectList("getBookType", clausesMap);
	}

	@Override
	public void addBookType(BookType bookType) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		sqlSession.insert("insertBookType", bookType);
	}

	@Override
	public void editBookType(BookType bookType) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		sqlSession.update("updateBookType", bookType);		
	}

	@Override
	public void deleteBookType(int id) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		sqlSession.delete("deleteBookType", id);		
	}

}
