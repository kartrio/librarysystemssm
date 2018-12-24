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

import com.library.model.Bookcase;
import com.library.service.BookcaseService;

/**
 * 书架信息控制器
 * @author shao
 *
 */
@Controller
public class BookcaseController {

	@Autowired
	private BookcaseService bookcaseService;
	
	@RequestMapping("/bookcasePage")
	public String bookcasePage(Integer reader,Model model){
		model.addAttribute("reader", reader);
		return "library/findBookcase";
	}
	
	/**
	 * 分页查询书架信息
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findBookcase")
	public Object findBookcase( @RequestParam(required=false,defaultValue="1")Integer page, 
			@RequestParam(required=false,defaultValue="8")Integer rows) {
		int startRow = (page - 1) * rows; 
		Map<String, Object> clausesMap = new HashMap<>();
		clausesMap.put("startRow", startRow);
		clausesMap.put("rows", rows);
		
		Map<String, Object> pages = new HashMap<String, Object>();
		
		try {
			List<Bookcase> bookcaseList = bookcaseService.getBookcase(clausesMap);
			int count = bookcaseService.getBookcaseCount();
			pages.put("total", count);
		    pages.put("rows", bookcaseList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pages;
	}
	
	@RequestMapping("/addBookcase")
	public String addBookcase(Bookcase bookcase, Integer page, Integer rows){
		bookcaseService.addBookcase(bookcase);
		return "redirect:findBookcase?page=" + page + "&rows=" + rows;
	}
	
	@RequestMapping("/editBookcase")
	public String editBookcase(Bookcase bookcase, Integer page, Integer rows){
		bookcaseService.editBookcase(bookcase);
		return "redirect:findBookcase?page=" + page + "&rows=" + rows;
	}
	
	@RequestMapping("/deleteBookcase")
	public String deleteBookcase(int id, Integer page, Integer rows){
		bookcaseService.deleteBookcase(id);
		return "redirect:findBookcase?page=" + page + "&rows=" + rows;
	}
}
