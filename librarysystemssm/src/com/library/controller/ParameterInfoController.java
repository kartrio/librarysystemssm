package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.model.ParameterInfo;
import com.library.service.ParameterInfoService;
import com.library.util.AJAXResult;

@Controller
public class ParameterInfoController {

	@Autowired
	private ParameterInfoService parameterInfoService;
	
	/**
	 * 跳转到参数信息页面
	 * 
	 * @return
	 */
	@RequestMapping("/parameterInfoPage")
	public String parameterInfoPage() {
		return "/jsp/library/findParameterInfo.jsp";
	}

	/**
	 * 查询参数信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findParameterInfo")
	public Object findParameterInfo() {
		AJAXResult result = new AJAXResult();
		ParameterInfo parameterInfo = null;
		try {
			parameterInfo = parameterInfoService.findParameterInfo();
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}

		result.setData(parameterInfo);
		return result;
	}
	
	@RequestMapping("/updateParameterInfo")
	public String updateParameterInfo(ParameterInfo parameterInfo){
		parameterInfoService.updateParameterInfo(parameterInfo);
		return "redirect:findParameterInfo";
	}
}
