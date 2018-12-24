package com.library.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.model.ReaderType;
import com.library.service.ReaderTypeService;

@Controller
public class ReaderTypeController {
	
	 @Autowired
	 private ReaderTypeService readerTypeService;
	
	 @RequestMapping("/readerTypePage")
     public String readerTypePage(){
    	 return "reader/findReaderType";
     }
	 
	 /**
		 * 根据条件分页查询读者类别信息
		 * @param readerType
		 * @param page
		 * @param rows
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/findReaderType")
		public Object findReaderType(ReaderType readerType, 
				@RequestParam(required=false,defaultValue="1")Integer page, 
				@RequestParam(required=false,defaultValue="8")Integer rows) {
			Map<String, Object> clausesMap = new HashMap<>();
			int startRow = (page - 1) * rows;
			clausesMap.put("name", readerType.getName());
			clausesMap.put("number", readerType.getNumber());
			clausesMap.put("startRow", startRow);
			clausesMap.put("rows", rows);
			
			Map<String, Object> readerTypes = new HashMap<>();
			try {
				List<ReaderType> readerTypeList = readerTypeService.getReaderType(clausesMap);
				int count = readerTypeService.getReaderTypeCount();
				readerTypes.put("total", count);
				readerTypes.put("rows", readerTypeList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return readerTypes;
		}
		
		@RequestMapping("/addReaderType")
		public String addReaderType(ReaderType readerType, Integer page, Integer rows){
			readerTypeService.addReaderType(readerType);
			return "redirect:findReaderType?page=" + page + "&rows=" + rows;
		}
		
		@RequestMapping("/editReaderType")
		public String editReaderType(ReaderType readerType, Integer page, Integer rows){
			readerTypeService.editReaderType(readerType);
			return "redirect:findReaderType?page=" + page + "&rows=" + rows;
		}
		
		@RequestMapping("/deleteReaderType")
		public String deleteReaderType(int id, Integer page, Integer rows){
			readerTypeService.deleteReaderType(id);
			return "redirect:findReaderType?page=" + page + "&rows=" + rows;
		}
}
