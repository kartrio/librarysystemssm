package com.library.dao.impl;

import com.library.dao.ManagerDao;
import com.library.model.Manager;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class ManagerDaoImpl implements ManagerDao {
	private SqlSessionFactory sqlSessionFactory;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public Manager queryManagerByNameAndPwd(Map<String, Object> infoMap) {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		return (Manager) sqlSession.selectOne("getManByNaAndPwd", infoMap);
	}

	@Override
	public int getManagerCount() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		return sqlSession.selectOne("getManagerCount");
	}

	@Override
	public void editManager(Manager manager) {
		SqlSession sqlSession = this.sqlSessionFactory.openSession(true);
		sqlSession.update("updateManager", manager);
	}

	@Override
	public void deleteManager(int id) {
		SqlSession sqlSession = this.sqlSessionFactory.openSession(true);
		sqlSession.delete("deleteManager", id);
	}

	@Override
	public List<Manager> getManager(Map<String, Object> clausesMap) {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		return sqlSession.selectList("getManager", clausesMap);
	}

	@Override
	public void addManager(Manager manager) {
		SqlSession sqlSession = this.sqlSessionFactory.openSession(true);	
		sqlSession.insert("insertManager", manager);
	}
}
