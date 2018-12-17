package com.library.controller;

import java.util.ArrayList;
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

import com.library.model.BookInfo;
import com.library.model.BookType;
import com.library.model.Bookcase;
import com.library.model.PublishInfo;
import com.library.service.BookInfoService;
import com.library.service.BookTypeService;
import com.library.service.BookcaseService;
import com.library.service.PublishInfoService;
import com.library.util.GenerateBarcode;

@Controller
public class BookInfoController {

	@Autowired
	private BookInfoService bookInfoService;

	@Autowired
	private BookTypeService bookTypeService;

	@Autowired
	private PublishInfoService publishInfoService;

	@Autowired
	private BookcaseService bookcaseService;

	/**
	 * 跳转到查询图书档案页面
	 * 
	 * @return
	 */
	@RequestMapping("/bookInfoPage")
	public String bookInfoPage(Integer reader, Model model) {
		model.addAttribute("reader", reader);
		return "book/findBookInfo";
	}

	/**
	 * 获取包含了id和typename的书籍类别信息
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getBookType")
	public Object getBookType() {
		List<BookType> bookTypeList = bookTypeService.getBookType(null);
		List<Map<String, Object>> comboDataList = new ArrayList<>();
		if (bookTypeList != null) {
			for (BookType bookType : bookTypeList) {
				Map<String, Object> comboData = new HashMap<>();
				comboData.put("id", bookType.getId());
				comboData.put("typename", bookType.getTypename());
				comboDataList.add(comboData);
			}
		}
		return comboDataList;

	}

	/**
	 * 获取包含了isbn和pubname的出版社的信息
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getPublishInfo")
	public Object getPublishInfo() {
		List<PublishInfo> publishInfoList = publishInfoService.getPublishInfo();
		List<Map<String, Object>> comboDataList = new ArrayList<>();
		if (publishInfoService != null) {
			for (PublishInfo publishInfo : publishInfoList) {
				Map<String, Object> comboData = new HashMap<>();
				comboData.put("isbn", publishInfo.getIsbn());
				comboData.put("pubname", publishInfo.getPubname());
				comboDataList.add(comboData);
			}
		}
		return comboDataList;
	}

	/**
	 * 获取包含了id和name的书架的信息
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getBookcase")
	public Object getBookcase() {
		List<Bookcase> bookcaseList = bookcaseService.getBookcase(null);
		List<Map<String, Object>> comboDataList = new ArrayList<>();
		if (bookcaseList != null) {
			for (Bookcase bookcase : bookcaseList) {
				Map<String, Object> comboData = new HashMap<>();
				comboData.put("id", bookcase.getId());
				comboData.put("name", bookcase.getName());
				comboDataList.add(comboData);
			}
		}
		return comboDataList;
	}

	/**
	 * 根据书名和作者名查询书籍信息
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findBookInfo")
	public Object findBookInfo(String barcode, String bookname, String author, Integer del,
			@RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "8") Integer rows) {
		int startRow = (page - 1) * rows;
		Map<String, Object> clausesMap = new HashMap<>();
		clausesMap.put("startRow", startRow);
		clausesMap.put("rows", rows);
		clausesMap.put("barcode", barcode);
		clausesMap.put("bookname", bookname);
		clausesMap.put("author", author);
		clausesMap.put("del", del);
		Map<String, Object> pages = new HashMap<String, Object>();
		try {
			List<BookInfo> bookInfoList = bookInfoService.findBookInfo(clausesMap);
			int count = bookInfoService.getBookInfoCount(clausesMap);
			pages.put("total", count);
			pages.put("rows", bookInfoList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pages;
	}

	/**
	 * 删除书籍信息
	 * 
	 * @param barcode
	 * @return
	 */
	@RequestMapping("/deleteBookInfo")
	public String deleteBookInfo(int id, Integer page, Integer rows) {
		try {
			bookInfoService.deleteBookInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:findBookInfo?page=" + page + "&rows=" + rows;
	}

	/**
	 * 新增书籍信息
	 * 
	 * @param bookInfo
	 * @param isbn
	 * @return
	 */
	@RequestMapping("/addBookInfo")
	public Object addBookInfo(BookInfo bookInfo, Integer page, Integer rows) {
		Map<String, Object> clausesMap = new HashMap<String, Object>();
		clausesMap.put("barcode", GenerateBarcode.generBarcode());
		clausesMap.put("bookname", bookInfo.getBookname());
		clausesMap.put("typeid", bookInfo.getBookType().getId());
		clausesMap.put("author", bookInfo.getAuthor());
		clausesMap.put("isbn", bookInfo.getPublishInfo().getIsbn());
		clausesMap.put("price", bookInfo.getPrice());
		clausesMap.put("bookcase", bookInfo.getBookcase().getId());
		clausesMap.put("translator", bookInfo.getTranslator());
		clausesMap.put("page", bookInfo.getPage());
		clausesMap.put("operator", bookInfo.getOperator());
		clausesMap.put("inTime", new Date());
		try {
			bookInfoService.addBookInfo(clausesMap);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:findBookInfo?page=" + page + "&rows=" + rows;
	}

	/**
	 * 修改书籍信息
	 * 
	 * @param bookInfo
	 * @param isbn
	 * @return
	 */
	@RequestMapping("/editBookInfo")
	public String editBookInfo(BookInfo bookInfo, Integer page, Integer rows) {
		Map<String, Object> clausesMap = new HashMap<String, Object>();
		clausesMap.put("id", bookInfo.getId());
		clausesMap.put("barcode", bookInfo.getBarcode());
		clausesMap.put("typeid", bookInfo.getBookType().getId());
		clausesMap.put("bookname", bookInfo.getBookname());
		clausesMap.put("author", bookInfo.getAuthor());
		clausesMap.put("isbn", bookInfo.getPublishInfo().getIsbn());
		clausesMap.put("price", bookInfo.getPrice());
		clausesMap.put("bookcase", bookInfo.getBookcase().getId());
		clausesMap.put("page", bookInfo.getPage());
		clausesMap.put("operator", bookInfo.getOperator());
		clausesMap.put("inTime", new Date());

		bookInfoService.editBookInfo(clausesMap);
		return "redirect:findBookInfo?page=" + page + "&rows=" + rows;
	}

}
