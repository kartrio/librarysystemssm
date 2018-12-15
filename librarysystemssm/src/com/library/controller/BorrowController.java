package com.library.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.model.BorrowInfo;
import com.library.service.BookInfoService;
import com.library.service.BorrowInfoService;
import com.library.util.DateUtil;

@Controller
public class BorrowController {
	
	@Autowired
	private BorrowInfoService borrowInfoService;
	
	@Autowired
	private BookInfoService bookInfoService;
	
	@RequestMapping("/borrowBookPage")
    public String borrowBookPage(){
    	return "/jsp/borrow/borrowBook.jsp";
    }
	
	@RequestMapping("/borrowInfoPage")
    public String borrowInfoPage(Integer source, Model model){
		model.addAttribute("source", source);
    	return "/jsp/book/findBorrowInfo.jsp";
    }
	
	@RequestMapping("/delBorrowInfoPage")
	public String delBorrowInfoPage(){
		return "/jsp/borrow/delBorrowInfo.jsp";
	}
	/**
	 * 分页查询图书借阅信息
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findBorrowInfo")
	public Object findBorrowInfo(String barcode, String fromTime, String toTime, Integer status,
			@RequestParam(required=false,defaultValue="1")Integer page, 
			@RequestParam(required=false,defaultValue="8")Integer rows) {
		int startRow = (page - 1) * rows; 
		Map<String, Object> clausesMap = new HashMap<>();
		clausesMap.put("barcode", barcode);
		clausesMap.put("fromTime", fromTime);
		clausesMap.put("toTime", toTime);
		clausesMap.put("startRow", startRow);
		clausesMap.put("rows", rows);
		clausesMap.put("status", status);
		Map<String, Object> pages = new HashMap<String, Object>();
		
		try {
			List<BorrowInfo> borrowInfoList = borrowInfoService.getBorrowInfo(clausesMap);
			int count = borrowInfoService.getBorrowInfoCount();
			pages.put("total", count);
		    pages.put("rows", borrowInfoList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pages;
	} 
	
	/**
	 * 同意借阅
	 * @param id
	 * @param operator
	 * @return
	 */
	@RequestMapping("/agreeBorrow")
	public String agreeBorrow(Integer id, Integer bookid, String operator){
		//更新借阅信息
		Map<String, Object> clausesMap = new HashMap<>();
		clausesMap.put("id", id);
		clausesMap.put("operator", operator);
		clausesMap.put("status", 1);
		borrowInfoService.updateBorrowInfo(clausesMap);
		
		//更新图书信息
		Map<String, Object> bookMap = new HashMap<>();
		bookMap.put("id", bookid);
		bookMap.put("del", 1);
		bookInfoService.editBookInfo(bookMap);
		return "redirect:findBorrowInfo";
	}
	
	/**
	 * 借阅书籍
	 * @param readerid
	 * @param bookid
	 * @param days
	 * @return
	 */
	@RequestMapping("/borrowBook")
	public String borrowBook(Integer readerid, Integer bookid, Integer days){
		Date now = new Date();
		Map<String, Object> clauseMap = new HashMap<>();
		clauseMap.put("readerid", readerid);
		clauseMap.put("bookid", bookid);
		clauseMap.put("borrowTime", now);
		clauseMap.put("backTime", DateUtil.addDays(now, days));
		clauseMap.put("ifback", 0);
		clauseMap.put("status", 0);
		borrowInfoService.addBorrowInfo(clauseMap);
		Map<String, Object> delMap = new HashMap<>();
		delMap.put("id", bookid);
		delMap.put("del", 1);
		bookInfoService.editBookInfo(delMap);
		return "redirect:findBorrowInfo";
	}
}