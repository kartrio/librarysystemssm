package com.library.dao.impl;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.library.dao.LibraryInfoDao;
import com.library.model.LibraryInfo;

public class LibraryInfoDaoImpl implements LibraryInfoDao{

	private SqlSessionFactory sqlSessionFactory;
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public LibraryInfo getLibraryInfo() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectOne("getLibraryInfo");
	}

	@Override
	public void updateLibraryInfo(Map<String, Object> clausesMap) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		sqlSession.update("updateLibraryInfo" ,clausesMap);
	}

}
