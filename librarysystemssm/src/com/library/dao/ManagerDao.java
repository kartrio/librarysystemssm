package com.library.dao;

import java.util.List;
import java.util.Map;

import com.library.model.Manager;

public interface ManagerDao {
	public Manager queryManagerByNameAndPwd(Map<String, Object> infoMap);

	// 获取管理员信息的总数量
	public int getManagerCount();

	// 修改管理员信息
	public void editManager(Manager manager);

	// 删除管理员信息
	public void deleteManager(int id);

	// 分页查询管理员信息
	public List<Manager> getManager(Map<String, Object> clausesMap);

	//新增管理员信息
	public void addManager(Manager manager);

	//根据id获取管理员信息
	public Manager getManagerById(Integer id);
}
