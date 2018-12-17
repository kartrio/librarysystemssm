package com.library.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.library.service.BorrowInfoService;
import com.library.util.DateUtil;

@Controller
public class RenewBookController {
	
	@Autowired
	private BorrowInfoService borrowInfoService;

	@RequestMapping("/renewBookPage")
	public String renewBookPage() {
		return "borrow/renewBook";
	}

	@RequestMapping("/delRenewBookPage")
	public String delRenewBookPage() {
		return "borrow/delRenewBookInfo";
	}
	/**
	 * 图书续借,时间为一个月
	 * 
	 * @param id
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/renewBook")
	public String renewBook(Integer id,Integer readerid, Integer page, Integer rows) {
		Date date = new Date();
		Map<String, Object> clausesMap = new HashMap<>();
		clausesMap.put("id", id);
		clausesMap.put("borrowTime", date);
		clausesMap.put("backTime", DateUtil.addDays(date, 30));
		clausesMap.put("status", 3);
		borrowInfoService.updateBorrowInfo(clausesMap);
		return "redirect:findNeedBackInfo?ifback=0&readerid="+ readerid + "&status=1&page=" + page + "&rows=" + rows;
	}
	
	/**
	 * 同意进行图书续借
	 * @param id
	 * @param operator
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/agreeRenew")
	public String agreeRenew(Integer id, String operator, Integer page, Integer rows){
		Map<String, Object> clausesMap = new HashMap<>();
		clausesMap.put("id", id);
		clausesMap.put("operator", operator);
		clausesMap.put("status", 1);
		borrowInfoService.updateBorrowInfo(clausesMap);
		return "redirect:findBorrowInfo?status=3&page=" + page + "&rows=" + rows;
	}
}
