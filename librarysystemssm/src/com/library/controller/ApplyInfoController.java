package com.library.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.model.ApplyInfo;
import com.library.model.ReaderInfo;
import com.library.service.ApplyInfoService;
import com.library.service.ReaderService;
import com.library.util.AJAXResult;
import com.library.util.GenerateBarcode;

@Controller
public class ApplyInfoController {
	
	@Autowired
	private ApplyInfoService applyInfoService;
	
	@Autowired
	private ReaderService readerService;
	
	/**
	 * 跳转到办证信息处理页面
	 * @return
	 */
	@RequestMapping("/delApplyInfoPage")
	public String delApplyInfoPage(){
		return "library/delApplyInfoPage";
	}
	
	/**
	 * 申请办理借书证
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/applyLibraryCard")
	public Object applyLibraryCard(Integer readerId){
		AJAXResult result = new AJAXResult();
		String msg = "";
		try {
			ReaderInfo readerInfo = new ReaderInfo();
			readerInfo.setId(readerId);
			ApplyInfo applyInfo = new ApplyInfo();
			applyInfo.setReaderInfo(readerInfo);
			applyInfo.setDel(0);
			applyInfoService.addApplyInfo(applyInfo);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			msg = "申请失败！";
			result.setSuccess(false);
		}
		result.setData(msg);
		return result;
	}
	
	/**
	 * 分页查询办证信息
	 * @param del
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findApplyInfo")
	public Object findApplyInfo(Integer del,
		   @RequestParam(required=false,defaultValue="1")Integer page, 
		   @RequestParam(required=false,defaultValue="8")Integer rows){
		int startRow = (page - 1) * rows; 
		Map<String, Object> clausesMap = new HashMap<>();
		clausesMap.put("del", del);
		clausesMap.put("startRow", startRow);
		clausesMap.put("rows", rows);
		List<ApplyInfo> applyInfo = applyInfoService.getApplyInfo(clausesMap);
		int count = applyInfoService.getApplyInfoCount(clausesMap);
		
		Map<String, Object> pages = new HashMap<>();
		pages.put("total", count);
		pages.put("rows", applyInfo);
		
		return pages;
	}
	
	/**
	 * 同意申请
	 * @param id
	 * @param readerid
	 * @param operator
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/agreeApply")
	public String agreeApply(Integer id,Integer readerid, String operator
			,Integer page, Integer rows){
		Map<String, Object> clausesMap = new HashMap<>();
		clausesMap.put("id", id);
		clausesMap.put("del", 1);
		clausesMap.put("operator", operator);
		applyInfoService.updateApplyInfo(clausesMap);
		
		Map<String, Object> readerMap = new HashMap<>();
		readerMap.put("id", readerid);
		readerMap.put("libraryCard", GenerateBarcode.generBarcode());
		readerService.updateReaderInfo(readerMap);
		return "redirect:findApplyInfo?page=" + page + "&rows=" + rows + "&del=0";
	}
	
	/**
	 * 拒绝办证申请
	 * @param id
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/disagreeApply")
	public String disagreeApply(Integer id,String operator, Integer page, Integer rows){
		Map<String, Object> clausesMap = new HashMap<>();
		clausesMap.put("id", id);
		clausesMap.put("del", 3);
		clausesMap.put("operator", operator);
		applyInfoService.updateApplyInfo(clausesMap);
		return "redirect:findApplyInfo?page=" + page + "&rows=" + rows + "&del=0";
	}
}
