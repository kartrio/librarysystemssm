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
import com.library.util.SendEmailUtil;

@Controller
public class BorrowController {

	@Autowired
	private BorrowInfoService borrowInfoService;

	@Autowired
	private BookInfoService bookInfoService;

	/**
	 * 跳转到借阅书籍页面
	 * @return
	 */
	@RequestMapping("/borrowBookPage")
	public String borrowBookPage() {
		return "borrow/borrowBook";
	}

	@RequestMapping("/borrowInfoPage")
	public String borrowInfoPage(Integer source, Model model) {
		model.addAttribute("source", source);
		return "book/findBorrowInfo";
	}

	@RequestMapping("/delBorrowInfoPage")
	public String delBorrowInfoPage() {
		return "borrow/delBorrowInfo";
	}
	
	@RequestMapping("/findAllBorrowBookInfo")
	public String findAllBorrowBookInfo() {
		return "borrow/findAllBorrowBookInfo";
	}
	
	/**
	 * 跳转到借阅到期提醒页面
	 * 离归还时间还有5天时进行提醒
	 * @param model
	 * @return
	 */
	@RequestMapping("/dueToRemind")
	public String dueToRemind(Model model) {
		model.addAttribute("toTime", DateUtil.dateToStr(DateUtil.addDays(new Date(), 5)));
		return "borrow/dueToRemind";
	}

	/**
	 * 分页查询图书借阅信息
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findBorrowInfo")
	public Object findBorrowInfo(String barcode, String fromTime, String toTime, Integer status, Integer ifback,
			@RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "8") Integer rows) {
		int startRow = (page - 1) * rows;
		Map<String, Object> clausesMap = new HashMap<>();
		clausesMap.put("barcode", barcode);
		clausesMap.put("fromTime", fromTime);
		clausesMap.put("toTime", toTime);
		clausesMap.put("startRow", startRow);
		clausesMap.put("rows", rows);
		clausesMap.put("status", status);
		clausesMap.put("ifback", ifback);
		Map<String, Object> pages = new HashMap<String, Object>();

		try {
			List<BorrowInfo> borrowInfoList = borrowInfoService.getBorrowInfo(clausesMap);
			int count = borrowInfoService.getBorrowInfoCount(clausesMap);
			pages.put("total", count);
			pages.put("rows", borrowInfoList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pages;
	}

	/**
	 * 同意借阅
	 * 
	 * @param id
	 * @param operator
	 * @return
	 */
	@RequestMapping("/agreeBorrow")
	public String agreeBorrow(Integer id, Integer bookid, String operator, Integer page, Integer rows) {
		// 更新借阅信息
		Map<String, Object> clausesMap = new HashMap<>();
		clausesMap.put("id", id);
		clausesMap.put("operator", operator);
		clausesMap.put("status", 1);
		borrowInfoService.updateBorrowInfo(clausesMap);

		// 更新图书信息
		Map<String, Object> bookMap = new HashMap<>();
		bookMap.put("id", bookid);
		bookMap.put("del", 1);
		bookInfoService.editBookInfo(bookMap);
		return "redirect:findBorrowInfo?status=0&page=" + page + "&rows=" + rows;
	}

	/**
	 * 拒绝借阅申请
	 * 
	 * @param id
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/disagreeBorrow")
	public String disagreeBorrow(Integer id,Integer bookid, String operator, Integer page, Integer rows) {
		// 更新借阅信息
		Map<String, Object> clausesMap = new HashMap<>();
		clausesMap.put("id", id);
		clausesMap.put("operator", operator);
		clausesMap.put("status", 4);
		borrowInfoService.updateBorrowInfo(clausesMap);

		// 更新图书信息
		Map<String, Object> bookMap = new HashMap<>();
		bookMap.put("id", bookid);
		bookMap.put("del", 0);
		bookInfoService.editBookInfo(bookMap);
		return "redirect:findBorrowInfo?status=0&page=" + page + "&rows=" + rows;
	}

	/**
	 * 借阅书籍
	 * 
	 * @param readerid
	 * @param bookid
	 * @param days
	 * @return
	 */
	@RequestMapping("/borrowBook")
	public String borrowBook(Integer readerid, Integer bookid, Integer days, Integer page, Integer rows) {
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
		return "redirect:findBookInfo?del=0&page=" + page + "&rows=" + rows;
	}
	
    /**
     * 提醒归还书籍
	 * 1.通过调用SMS的接口可以进行短信提醒
	 * 2.可以通过发送邮件的方式提醒
     * @param readerName
     * @param email
     * @param page
     * @param rows
     * @return
     */
	@RequestMapping("/remindGiveBack")
	public String remindGiveBack(String readerName,String email, Integer page, Integer rows){
		String str = DateUtil.dateToStr(DateUtil.addDays(new Date(), 5));
		String subject = "书籍归还提醒";
		String content = readerName + ",您有书籍5天之后需要归还！";
		SendEmailUtil.sendEmail(email, content, subject);
		return "redirect:findBorrowInfo?toTime=" + str + "&ifback=0&page=" + page + "&rows=" + rows;
	}
}
