package com.library.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.model.ReaderInfo;
import com.library.service.ReaderService;
import com.library.util.AJAXResult;

@Controller
public class ReaderInfoController {

	@Autowired
	private ReaderService readerService;
	
	/**
	 * 跳转到读者信息页面
	 * @param manager
	 * @param page
	 * @param rows
	 * @param model
	 * @return
	 */
	@RequestMapping("/readerInfoPage")
	public String readerInfoPage(boolean manager,
			@RequestParam(required=false,defaultValue="1")Integer page,
			@RequestParam(required=false,defaultValue="8")Integer rows,
			Model model) {
		model.addAttribute("manager", manager);
		model.addAttribute("page", page);
		model.addAttribute("rows", rows);
		return "reader/findReaderInfo";
	}

	/**
	 * 分页查询读者信息
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findReaderInfo")
	public Object findReaderInfo(String name,Integer status,
			@RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "8") Integer rows) {
		int startRow = (page - 1) * rows;
		Map<String, Object> clausesMap = new HashMap<>();
		clausesMap.put("name", name);
		clausesMap.put("status", status);
		clausesMap.put("startRow", startRow);
		clausesMap.put("rows", rows);

		Map<String, Object> pages = new HashMap<String, Object>();

		try {
			List<ReaderInfo> readerInfoList = readerService.getReaderInfo(clausesMap);
			int count = readerService.getReaderInfoCount();
			pages.put("total", count);
			pages.put("rows", readerInfoList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pages;
	}
	
	/**
	 * 根据id查询用户信息
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findReaderInfoById")
	public Object findReaderInfoById(Integer id){
		AJAXResult result = new AJAXResult();
		ReaderInfo readerInfo = null;
		try {
			readerInfo = readerService.getReaderInfoById(id);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		result.setData(readerInfo);
		System.out.println(readerInfo);
		return result;
	}
	
	/**
	 * 修改读者信息
	 * @param readerInfo
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateReaderInfo")
	public Object updateReaderInfo(ReaderInfo readerInfo){
		AJAXResult result = new AJAXResult();
		String msg = "";
		Map<String, Object> clausesMap = new HashMap<>();
		clausesMap.put("id", readerInfo.getId());
		clausesMap.put("name", readerInfo.getName());
		clausesMap.put("sex", readerInfo.getSex());
		clausesMap.put("birthday", readerInfo.getBirthday());
		clausesMap.put("paperType", readerInfo.getPaperType());
		clausesMap.put("paperNO", readerInfo.getPaperNO());
		clausesMap.put("tel", readerInfo.getTel());
		clausesMap.put("email", readerInfo.getEmail());
		try {
			readerService.updateReaderInfo(clausesMap);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			msg = "未知错误,请联系管理员!";
			result.setSuccess(false);
		}
		result.setData(msg);
		return result;
	}
	
	/**
	 * 删除读者信息
	 * @param id
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/deleteReaderInfo")
	public String deleteReaderInfo(int id, Integer page, Integer rows){
	    readerService.deleteReaderInfo(id);
		return "redirect:findReaderInfo?page=" + page + "&rows=" + rows;
	}
	
}
