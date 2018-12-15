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

@Controller
public class ReaderInfoController {

	@Autowired
	private ReaderService readerService;

	@RequestMapping("/readerInfoPage")
	public String readerInfoPage(boolean manager,
			@RequestParam(required=false,defaultValue="1")Integer page,
			@RequestParam(required=false,defaultValue="8")Integer rows,
			Model model) {
		model.addAttribute("manager", manager);
		model.addAttribute("page", page);
		model.addAttribute("rows", rows);
		return "/jsp/reader/findReaderInfo.jsp";
	}

	/**
	 * 分页查询读者信息
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findReaderInfo")
	public Object findReaderInfo(String name, @RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "8") Integer rows) {
		int startRow = (page - 1) * rows;
		Map<String, Object> clausesMap = new HashMap<>();
		clausesMap.put("name", name);
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
	
	@RequestMapping("/deleteReaderInfo")
	public String deleteReaderInfo(int id, Integer page, Integer rows){
	    readerService.deleteReaderInfo(id);
		return "redirect:findReaderInfo?page=" + page + "&rows=" + rows;
	}
}
