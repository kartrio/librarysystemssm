package com.library.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.library.dao.ParameterInfoDao;
import com.library.model.ParameterInfo;

public class ParameterInfoDaoImpl implements ParameterInfoDao {

	private SqlSessionFactory sqlSessionFactory;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public ParameterInfo findParameterInfo() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectOne("getParameterInfo");
	}

	@Override
	public void updateParameterInfo(ParameterInfo parameterInfo) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		sqlSession.update("updateParameterInfo", parameterInfo);
	}

}
