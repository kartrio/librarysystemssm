package com.library.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.library.dao.ReaderTypeDao;
import com.library.model.ReaderType;

public class ReaderTypeDaoImpl implements ReaderTypeDao {
 
	private SqlSessionFactory sqlSessionFactory;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public List<ReaderType> getReaderType(Map<String, Object> clausesMap) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectList("getReaderTypeInfo", clausesMap);
	}

	@Override
	public int getReaderTypeCount() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectOne("getReaderTypeCount");
	}

	@Override
	public void addReaderType(ReaderType readerType) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		sqlSession.insert("insertReaderTypeInfo", readerType);
	}

	@Override
	public void editReaderType(ReaderType readerType) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		sqlSession.update("updateReaderTypeInfo", readerType);
	}

	@Override
	public void deleteReaderType(int id) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		sqlSession.delete("deleteReaderTypeInfo", id);
	}

}
