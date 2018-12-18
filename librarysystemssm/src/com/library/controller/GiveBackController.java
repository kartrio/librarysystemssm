package com.library.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.model.BorrowInfo;
import com.library.model.GiveBackInfo;
import com.library.service.BookInfoService;
import com.library.service.BorrowInfoService;
import com.library.service.GiveBackInfoService;

/**
 * 图书归还控制器
 * 
 * @author Administrator
 *
 */
@Controller
public class GiveBackController {

	@Autowired
	private BorrowInfoService borrowInfoService;

	@Autowired
	private GiveBackInfoService giveBackInfoService;
	
	@Autowired
	private BookInfoService bookInfoService;
	
	@RequestMapping("/giveBackPage")
	public String giveBackPage() {
		return "giveback/giveBackBook";
	}

	@RequestMapping("/delGiveBackInfoPage")
	public String delGiveBackInfoPage() {
		return "giveback/delGiveBackInfo";
	}
	/**
	 * 查询当前用户需要归还的书籍信息
	 * 
	 * @param readerid
	 * @param ifback
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findNeedBackInfo")
	public Object findNeedBackInfo(String bookname , Integer readerid, 
			Integer ifback,Integer status,
			@RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "8") Integer rows) {
		int startRow = (page - 1) * rows;
		Map<String, Object> clausesMap = new HashMap<>();
		clausesMap.put("bookname", bookname);
		clausesMap.put("readerid", readerid);
		clausesMap.put("ifback", ifback);
		clausesMap.put("status", status);
		clausesMap.put("startRow", startRow);
		clausesMap.put("rows", rows);
		Map<String, Object> pages = new HashMap<String, Object>();

		try {
			List<BorrowInfo> borrowInfoList = borrowInfoService.getBorrowInfo(clausesMap);
			int count = borrowInfoService.getBorrowInfoCount(clausesMap);
			pages.put("total", count);
			pages.put("rows", borrowInfoList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(pages);
		return pages;
	}
	
	/**
	 * 分页查询已归还信息
	 * @param status
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findGiveBackInfo")
	public Object findGiveBackInfo(Integer status,
			@RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "8") Integer rows) {
		int startRow = (page - 1) * rows;
		Map<String, Object> clausesMap = new HashMap<>();
		clausesMap.put("status", status);
		clausesMap.put("startRow", startRow);
		clausesMap.put("rows", rows);
		Map<String, Object> pages = new HashMap<String, Object>();

		try {
			List<GiveBackInfo> giveBackInfoList = giveBackInfoService.getGiveBackInfo(clausesMap);
			int count = giveBackInfoService.getGiveBackInfoCount(clausesMap);
			pages.put("total", count);
			pages.put("rows", giveBackInfoList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(pages);
		return pages;
	}
	
	/**
	 * 归还书籍
	 * @param readerid
	 * @param bookid
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/giveBackBook")
	public String giveBackBook(Integer id,Integer readerid, Integer bookid, Integer page, Integer rows){
		Map<String, Object> clausesMap = new HashMap<>();
		clausesMap.put("readerid", readerid);
		clausesMap.put("bookid", bookid);
		clausesMap.put("backTime", new Date());
		clausesMap.put("status", 2);
		giveBackInfoService.insertGiveBackInfo(clausesMap);
		Map<String, Object> borrowMap = new HashMap<>();
		borrowMap.put("id", id);
		borrowMap.put("ifback", 1);
		borrowInfoService.updateBorrowInfo(borrowMap);
		return "redirect:findNeedBackInfo?ifback=0&readerid=" + readerid + "&status=1&page=" 
		+ page + "&rows=" + rows;
	}
	
	/**
	 * 确认归还书籍
	 * @param id
	 * @param operator
	 * @param bookid
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/confirmGiveBack")
	public String confirmGiveBack(Integer id, Integer bookid,String operator, Integer page, Integer rows){
		Map<String, Object> clausesMap = new HashMap<>();
		clausesMap.put("id", id);
		clausesMap.put("operator", operator);
		clausesMap.put("status", 1);
		giveBackInfoService.updateGiveBackInfo(clausesMap);
		Map<String, Object> bookInfoMap = new HashMap<>();
		bookInfoMap.put("id", bookid);
		bookInfoMap.put("del", 0);
		bookInfoService.editBookInfo(bookInfoMap);
		return "redirect:findGiveBackInfo?status=2&page=" + page + "&rows=" + rows;
	}
	
	/**
	 * 拒绝归还申请
	 * @param id
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/refuseGiveBack")
	public String refuseGiveBack(Integer id, Integer page, Integer rows){
		giveBackInfoService.deleteGiveBackInfo(id);
		return "redirect:findGiveBackInfo?status=2&page=" + page + "&rows=" + rows;
	}
}
