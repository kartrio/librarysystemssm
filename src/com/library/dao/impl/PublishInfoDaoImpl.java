package com.library.dao.impl;

import java.util.List;
import java.util.Map;

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

	@Override
	public List<PublishInfo> findPublishInfo(Map<String, Object> clausesMap) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectList("getPublishInfo", clausesMap);
	}

	@Override
	public int getPublishInfoCount() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectOne("getPublishInfoCount");
	}

	@Override
	public void addPublishInfo(PublishInfo publishInfo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();	
		sqlSession.insert("insertPublishInfo", publishInfo);
	}

	@Override
	public void editPublishInfo(PublishInfo publishInfo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("updatePublishInfo", publishInfo);
	}

	@Override
	public void deletePublishInfo(String ISBN) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("deletePublishInfo", ISBN);
	}

}
