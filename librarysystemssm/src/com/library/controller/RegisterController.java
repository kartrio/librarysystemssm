package com.library.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.model.ReaderInfo;
import com.library.model.ReaderType;
import com.library.service.ReaderService;
import com.library.service.ReaderTypeService;
import com.library.util.AJAXResult;
import com.library.util.EncodeCheckCode;
import com.library.util.GenerateBarcode;

@Controller
public class RegisterController {

	@Autowired
	private ReaderTypeService readerTypeService;

	@Autowired
	private ReaderService readerService;

	@RequestMapping("/registerPage")
	public String registerPage(Model model) {
		List<ReaderType> readerTypeList = readerTypeService.getReaderType(null);
		if (readerTypeList != null) {
			model.addAttribute("readerTypeList", readerTypeList);
		} else {
			model.addAttribute("readerTypeList", "");
		}
		return "register";
	}

	/**
	 * 注册
	 * 
	 * @param readeerInfo
	 * @param checkcode
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/doRegister")
	public Object doRegister(ReaderInfo readerInfo, String checkcode, HttpSession session) {
		AJAXResult result = new AJAXResult();
		String msg = "";
		Map<String, Object> infoMap = new HashMap<String, Object>();
		infoMap.put("name", readerInfo.getName());
		infoMap.put("pwd", readerInfo.getPwd());
		infoMap.put("sex", readerInfo.getSex());
		infoMap.put("typeid", readerInfo.getReaderType().getId());
		infoMap.put("vocation", readerInfo.getReaderType().getName());
		infoMap.put("barcode", GenerateBarcode.generBarcode());
		infoMap.put("birthday", readerInfo.getBirthday());
		infoMap.put("paperType", readerInfo.getPaperType());
		infoMap.put("paperNO", readerInfo.getPaperNO());
		infoMap.put("tel", readerInfo.getTel());
		infoMap.put("email", readerInfo.getEmail());
		infoMap.put("createDate", new Date());
		infoMap.put("remark", readerInfo.getRemark());
		infoMap.put("status", "新建");
		try {
			String checkcodese = (String) session.getAttribute("check_code");
			String encheckcode = EncodeCheckCode.encodeByMD5(checkcode);
			if (checkcodese.equals(encheckcode)) {
				ReaderInfo reader = readerService.queryReaderByNameAndPwd(infoMap);
				if(reader == null){
					try {
						readerService.addReaderInfo(infoMap);
						result.setSuccess(true);
					} catch (Exception e) {
						e.printStackTrace();
						msg = "新增失败!";
						result.setSuccess(false);
					}
					
				}else{
					msg = "该用户已存在!";
					result.setSuccess(false);
				}
			} else {
				msg = "验证码错误!";
				result.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = "未知错误,请联系管理员!";
			result.setSuccess(false);
		}
		
		result.setData(msg);
		return result;
	}

}
