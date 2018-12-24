package com.library.service.impl;

import com.library.dao.ManagerDao;
import com.library.model.Manager;
import com.library.service.ManagerService;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {
	private ManagerDao managerDao;

	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}

	public Manager queryManagerByNameAndPwd(Map<String, Object> infoMap) {
		return this.managerDao.queryManagerByNameAndPwd(infoMap);
	}

	@Override
	public int getManagerCount() {
		return managerDao.getManagerCount();
	}

	@Override
	public void editManager(Manager manager) {
		managerDao.editManager(manager);		
	}

	@Override
	public void deleteManager(int id) {
		managerDao.deleteManager(id);	
	}

	@Override
	public List<Manager> getManager(Map<String, Object> clausesMap) {
		return managerDao.getManager(clausesMap);
	}

	@Override
	public void addManager(Manager manager) {
		managerDao.addManager(manager);		
	}

	@Override
	public Manager getManagerById(Integer id) {
		return managerDao.getManagerById(id);
	}
}
