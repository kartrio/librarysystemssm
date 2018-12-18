package com.library.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.model.Manager;
import com.library.service.ManagerService;
import com.library.util.AJAXResult;

@Controller
public class ManagerController {

	@Autowired
	private ManagerService managerService;

	/**
	 * 跳转到管理员信息页面
	 * @return
	 */
	@RequestMapping("/managerPage")
	public String managerPage() {
		return "library/findManager";
	}

	@RequestMapping("/findReader")
	public String readerPage(){
		return "library/findReader";
	}
	
	/**
	 * 分页查询管理员信息
	 * @param name
	 * @param errorMsg
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findManager")
	public Object findManager(String name,
			@RequestParam(required = false, defaultValue = "0") Integer errorMsg,
			@RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "8") Integer rows) {
		Map<String, Object> pages = new HashMap<String, Object>();
		if(errorMsg == 0){
			int startRow = (page - 1) * rows;
			Map<String, Object> clausesMap = new HashMap<>();
			clausesMap.put("name", name);
			clausesMap.put("startRow", startRow);
			clausesMap.put("rows", rows);
			
			try {
				List<Manager> managerList = managerService.getManager(clausesMap);
				int count = managerService.getManagerCount();
				pages.put("total", count);
				pages.put("rows", managerList);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			pages.put("errorMsg", errorMsg);
		}
		return pages;
	}
	
	/**
	 * 新增管理员信息
	 * @param name
	 * @param PWD
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/addManager")
	public String addManager(String name, String PWD, Integer page, Integer rows){
		Map<String, Object> clauseMap = new HashMap<>();
		Manager manager = new Manager();
		manager.setName(name);
		manager.setPWD(PWD);
		clauseMap.put("userName", name);
		Manager managerExist = managerService.queryManagerByNameAndPwd(clauseMap);
		if(managerExist != null){
			return "redirect:findManager?page=" + page + "&rows=" + rows + "&errorMsg=1";
		}else{
			managerService.addManager(manager);
			return "redirect:findManager?page=" + page + "&rows=" + rows;
		}
		
	}
	
	/**
	 * 修改管理员信息
	 * @param manager
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/editManager")
	public String editManager(Manager manager, Integer page, Integer rows){
		managerService.editManager(manager);
		return "redirect:findManager?page=" + page + "&rows=" + rows;
	}
	
	/**
	 * 删除管理员信息
	 * @param id
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/deleteManager")
	public String deleteManager(int id, Integer page, Integer rows){
		managerService.deleteManager(id);
		return "redirect:findManager?page=" + page + "&rows=" + rows;
	}
	
	/**
	 * 根据id查询管理员信息
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getManagerById")
	public Object getManagerById(Integer id){
		AJAXResult result = new AJAXResult();
		Manager manager = null;
		try {
			manager = managerService.getManagerById(id);
		    result.setSuccess(true);	
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		result.setData(manager);
		return result;
	}
	
	/**
	 * findManagerById页面的更新管理员信息方法
	 * @param manager
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateManager")
	public Object updateManager(Manager manager){
		AJAXResult result = new AJAXResult();
		String msg = "";
		try {
			managerService.editManager(manager);
		    result.setSuccess(true);	
		} catch (Exception e) {
			e.printStackTrace();
			msg = "未知错误!";
			result.setSuccess(false);
		}
		result.setData(msg);
		return result;
	}
}
