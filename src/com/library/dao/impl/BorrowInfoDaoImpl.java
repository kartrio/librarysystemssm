package com.library.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.library.model.BorrowInfo;

public class BorrowInfoDaoImpl implements com.library.dao.BorrowInfoDao {
	
	private SqlSessionFactory sqlSessionFactory;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public List<BorrowInfo> getBorrowInfo(Map<String, Object> clausesMap) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectList("getBorrowInfo", clausesMap);
	}

	@Override
	public int getBorrowInfoCount(Map<String, Object> clausesMap) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectOne("getBorrowInfoCount", clausesMap);
	}

	@Override
	public void updateBorrowInfo(Map<String, Object> clausesMap) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		sqlSession.update("updateBorrowInfo", clausesMap);
	}

	@Override
	public void addBorrowInfo(Map<String, Object> clauseMap) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		sqlSession.update("insertBorrowInfo", clauseMap);
	}

	@Override
	public void deleteBorrowInfo(Integer id) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		sqlSession.delete("deleteBorrowInfo", id);
	}

}
