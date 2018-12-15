package com.library.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.model.LibraryInfo;
import com.library.service.LibraryInfoService;
import com.library.util.AJAXResult;

@Controller
public class LibraryInfoController {

	@Autowired
	private LibraryInfoService libraryInfoService;
	
	@RequestMapping("/libraryInfoPage")
	public String libraryInfoPage() {
		return "library/findLibraryInfo";
	}

	
	/**
	 * 查询图书馆信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findLibraryInfo")
	public Object findLibraryInfo() {
		AJAXResult result = new AJAXResult();
		LibraryInfo libraryInfo = null;
		try {
			libraryInfo = libraryInfoService.getLibraryInfo();
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		result.setData(libraryInfo);
		return result;
	}
	
	@RequestMapping("/updateLibraryInfo")
	public String updateLibraryInfo(LibraryInfo libraryInfo){
		Map<String, Object> clausesMap = new HashMap<String, Object>();
		clausesMap.put("id", libraryInfo.getId());
		clausesMap.put("libraryname", libraryInfo.getLibraryname());
		clausesMap.put("curator", libraryInfo.getCurator());
		clausesMap.put("tel", libraryInfo.getTel());
		clausesMap.put("address", libraryInfo.getAddress());
		clausesMap.put("email", libraryInfo.getEmail());
		clausesMap.put("createDate", libraryInfo.getCreateDate());
		clausesMap.put("url", libraryInfo.getUrl());
		libraryInfoService.updateLibraryInfo(clausesMap);
		return "redirect:findLibraryInfo";
	}
}
