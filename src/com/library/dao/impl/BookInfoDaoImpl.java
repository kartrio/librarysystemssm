package com.library.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.library.dao.BookInfoDao;
import com.library.model.BookInfo;

public class BookInfoDaoImpl implements BookInfoDao {
	private SqlSessionFactory sqlSessionFactory;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public List<BookInfo> findBookInfo(Map<String, Object> clausesMap) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		return sqlSession.selectList("getBookInfo", clausesMap);
	}

	@Override
	public void deleteBookInfo(int id) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		sqlSession.delete("deleteBookInfo", id);
	}

	@Override
	public void addBookInfo(Map<String, Object> clausesMap) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		sqlSession.insert("insertBookInfo", clausesMap);		
	}

	@Override
	public void editBookInfo(Map<String, Object> clausesMap) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		sqlSession.update("updateBookInfo", clausesMap);			
	}

	@Override
	public int getBookInfoCount(Map<String, Object> clausesMap) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		return sqlSession.selectOne("getBookInfoCount" ,clausesMap);
	}

}
