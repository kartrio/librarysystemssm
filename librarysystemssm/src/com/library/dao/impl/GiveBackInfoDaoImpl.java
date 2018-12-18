package com.library.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.library.dao.GiveBackInfoDao;
import com.library.model.GiveBackInfo;

public class GiveBackInfoDaoImpl implements GiveBackInfoDao {
	private SqlSessionFactory sqlSessionFactory;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public void insertGiveBackInfo(Map<String, Object> clausesMap) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		sqlSession.insert("insertGiveBackInfo", clausesMap);
	}

	@Override
	public List<GiveBackInfo> getGiveBackInfo(Map<String, Object> clausesMap) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectList("getGiveBackInfo", clausesMap);
	}

	@Override
	public int getGiveBackInfoCount(Map<String, Object> clausesMap) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectOne("getGiveBackInfoCount", clausesMap);
	}

	@Override
	public void updateGiveBackInfo(Map<String, Object> clausesMap) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		sqlSession.insert("updateGiveBackInfo", clausesMap);
	}

	@Override
	public void deleteGiveBackInfo(Integer id) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		sqlSession.delete("deleteGiveBackInfo", id);		
	}

}
