package com.library.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.library.dao.PublishInfoDao;
import com.library.model.PublishInfo;

public class PublishInfoDaoImpl implements PublishInfoDao {

	private SqlSessionFactory sqlSessionFactory;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public List<PublishInfo> getPublishInfo() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectList("getPublishInfo");
	}

}
