package com.library.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.library.dao.ApplyInfoDao;
import com.library.model.ApplyInfo;

public class ApplyInfoDaoImpl implements ApplyInfoDao {

	private SqlSessionFactory sqlSessionFactory;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public void addApplyInfo(ApplyInfo applyInfo) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		sqlSession.insert("insertApplyInfo", applyInfo);
	}

	@Override
	public List<ApplyInfo> getApplyInfo(Map<String, Object> clausesMap) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectList("getApplyInfo", clausesMap);
	}

	@Override
	public int getApplyInfoCount(Map<String, Object> clausesMap) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectOne("getApplyInfoCount", clausesMap);
	}

	@Override
	public void updateApplyInfo(Map<String, Object> clausesMap) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		sqlSession.selectOne("updateApplyInfo", clausesMap);
	}

	@Override
	public void deleteApplyInfo(Integer id) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		sqlSession.delete("deleteApplyInfo", id);		
	}

}
