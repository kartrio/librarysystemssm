package com.library.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.library.dao.BookcaseDao;
import com.library.model.Bookcase;

public class BookcaseDaoImpl implements BookcaseDao {

	private SqlSessionFactory sqlSessionFactory;
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public List<Bookcase> getBookcase(Map<String, Object> clausesMap) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectList("getBookcase", clausesMap);
	}

	@Override
	public int getBookcaseCount() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectOne("getBookcaseCount");
	}

	@Override
	public void addBookcase(Bookcase bookcase) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		sqlSession.insert("insertBookcase", bookcase);
	}

	@Override
	public void editBookcase(Bookcase bookcase) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		sqlSession.update("updateBookcase", bookcase);
	}

	@Override
	public void deleteBookcase(int id) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		sqlSession.delete("deleteBookcase", id);
	}

}
