package com.library.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.model.BookType;
import com.library.service.BookTypeService;

@Controller
public class BookTypeController {

	@Autowired
	private BookTypeService bookTypeService;
	
	@RequestMapping("/bookTypePage")
	public String bookTypePage() {
		return "book/findBookType";
	}

	/**
	 * 根据条件分页查询图书类别信息
	 * @param bookType
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findBookType")
	public Object findBookType(BookType bookType, 
			@RequestParam(required=false,defaultValue="1")Integer page, 
			@RequestParam(required=false,defaultValue="8")Integer rows) {
		Map<String, Object> clausesMap = new HashMap<>();
		int startRow = (page - 1) * rows;
		clausesMap.put("typename", bookType.getTypename());
		clausesMap.put("days", bookType.getDays());
		clausesMap.put("startRow", startRow);
		clausesMap.put("rows", rows);
		
		Map<String, Object> bookTypes = new HashMap<>();
		try {
			int count = bookTypeService.getBookTypeCount(clausesMap);
			List<BookType> bookTypeList = bookTypeService.getBookType(clausesMap);
			bookTypes.put("total", count);
			bookTypes.put("rows", bookTypeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookTypes;
	}
	
	@RequestMapping("/addBookType")
	public String addBookType(BookType bookType, Integer page, Integer rows){
		bookTypeService.addBookType(bookType);
		return "redirect:findBookType?page=" + page + "&rows=" + rows;
	}
	
	@RequestMapping("/editBookType")
	public String editBookType(BookType bookType, Integer page, Integer rows){
		bookTypeService.editBookType(bookType);
		return "redirect:findBookType?page=" + page + "&rows=" + rows;
	}
	
	@RequestMapping("/deleteBookType")
	public String deleteBookType(int id, Integer page, Integer rows){
		bookTypeService.deleteBookType(id);
		return "redirect:findBookType?page=" + page + "&rows=" + rows;
	}
}
