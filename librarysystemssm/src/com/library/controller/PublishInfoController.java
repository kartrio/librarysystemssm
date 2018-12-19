package com.library.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.model.PublishInfo;
import com.library.service.PublishInfoService;


@Controller
public class PublishInfoController {

	@Autowired
	private PublishInfoService publishInfoService;
	
	/**
	 * 跳转到出版社信息页面
	 * @return
	 */
	@RequestMapping("publishInfoPage")
	public String publishInfoPage(){
		return "book/findPublishInfo";
	}
	
	/**
	 * 分页查询出版社信息
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findPublishInfo")
	public Object findPublishInfo( @RequestParam(required=false,defaultValue="1")Integer page, 
			@RequestParam(required=false,defaultValue="8")Integer rows) {
		int startRow = (page - 1) * rows; 
		Map<String, Object> clausesMap = new HashMap<>();
		clausesMap.put("startRow", startRow);
		clausesMap.put("rows", rows);
		
		Map<String, Object> pages = new HashMap<String, Object>();
		
		try {
			List<PublishInfo> publishInfoList = publishInfoService.findPublishInfo(clausesMap);
			int count = publishInfoService.getPublishInfoCount();
			pages.put("total", count);
		    pages.put("rows", publishInfoList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pages;
	}
	
	/**
	 * 新增出版社信息
	 * @param publishInfo
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/addPublishInfo")
	public String addPublishInfo(PublishInfo publishInfo, Integer page, Integer rows){
		publishInfoService.addPublishInfo(publishInfo);
		return "redirect:findPublishInfo?page=" + page + "&rows=" + rows;
	}
	
	/**
	 * 修改出版社信息
	 * @param publishInfo
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/editPublishInfo")
	public String editPublishInfo(PublishInfo publishInfo, Integer page, Integer rows){
		publishInfoService.editPublishInfo(publishInfo);
		return "redirect:findPublishInfo?page=" + page + "&rows=" + rows;
	}
	
	/**
	 * 删除出版社信息
	 * @param ISBN
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/deletePublishInfo")
	public String deletePublishInfo(String ISBN, Integer page, Integer rows){
		publishInfoService.deletePublishInfo(ISBN);
		return "redirect:findPublishInfo?page=" + page + "&rows=" + rows;
	}
}
