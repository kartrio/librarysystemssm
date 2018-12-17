package com.library.dao.impl;

import com.library.dao.ReaderDao;
import com.library.model.ReaderInfo;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class ReaderDaoImpl implements ReaderDao {
	private SqlSessionFactory sqlSessionFactory;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public ReaderInfo queryReaderByNameAndPwd(Map<String, Object> infoMap) {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		return (ReaderInfo) sqlSession.selectOne("queryReaderByNameAndPwd", infoMap);
	}

	@Override
	public List<ReaderInfo> getReaderInfo(Map<String, Object> clausesMap) {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		return sqlSession.selectList("getRederInfo", clausesMap);
	}

	@Override
	public int getReaderInfoCount() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		return sqlSession.selectOne("getReaderInfoCount");
	}

	@Override
	public void deleteReaderInfo(int id) {
		SqlSession sqlSession = this.sqlSessionFactory.openSession(true);
		sqlSession.delete("deleteReaderInfo", id);
	}

	@Override
	public void addReaderInfo(Map<String, Object> infoMap) {
		SqlSession sqlSession = this.sqlSessionFactory.openSession(true);	
		sqlSession.insert("insertReader", infoMap);
	}

	@Override
	public void updateReaderInfo(Map<String, Object> clausesMap) {
		SqlSession sqlSession = this.sqlSessionFactory.openSession(true);	
		sqlSession.insert("updateReaderInfo", clausesMap);
	}
}
