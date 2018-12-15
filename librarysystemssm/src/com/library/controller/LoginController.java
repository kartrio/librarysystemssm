package com.library.controller;

import com.library.model.Manager;
import com.library.model.ReaderInfo;
import com.library.service.ManagerService;
import com.library.service.ReaderService;
import com.library.util.AJAXResult;
import com.library.util.CheckCodeImage;
import com.library.util.EncodeCheckCode;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 登录控制器
 * @author Administrator
 *
 */
@Controller
public class LoginController {
	@Autowired
	private ReaderService readerService;
	@Autowired
	private ManagerService managerService;

	@RequestMapping("/checkcode")
	public void checkcode(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		try {
			ServletOutputStream sos = response.getOutputStream();

			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0L);

			BufferedImage image = new BufferedImage(CheckCodeImage.WIDTH, CheckCodeImage.HEIGHT, 1);
			Graphics g = image.getGraphics();
			char[] rands = CheckCodeImage.generateCheckCode();

			CheckCodeImage.drawBackground(g);
			CheckCodeImage.drawRands(g, rands);
			g.dispose();

			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ImageIO.write(image, "JPEG", bos);
			byte[] buf = bos.toByteArray();
			response.setContentLength(buf.length);
			sos.write(buf);
			bos.close();
			sos.close();

			String enCheckCode = EncodeCheckCode.encodeByMD5(new String(rands));

			session.setAttribute("check_code", enCheckCode);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/loginPage")
	public String loginPage() {
		return "/login.jsp";
	}

	@ResponseBody
	@RequestMapping("/login")
	public Object doLogin(String name, String password, String role, String checkcode, HttpSession session) {
		AJAXResult result = new AJAXResult();
		String msg = "";
		Map<String, Object> infoMap = new HashMap<String, Object>();
		infoMap.put("name", name);
		infoMap.put("password", password);
		try {
			String checkcodese = (String) session.getAttribute("check_code");
			String encheckcode = EncodeCheckCode.encodeByMD5(checkcode);
			if (checkcodese.equals(encheckcode)) {
				if ("reader".equals(role)) {
					session.setAttribute("role", "reader");
					ReaderInfo readerInfo = this.readerService.queryReaderByNameAndPwd(infoMap);
					if (readerInfo != null) {
						session.setAttribute("loginUserId", readerInfo.getId());
						session.setAttribute("loginUserName", readerInfo.getName());
						result.setSuccess(true);
					} else {
						msg = "读者名或密码错误!";
						result.setSuccess(false);
					}
				} else if ("manager".equals(role)) {
					session.setAttribute("role", "manager");
					Manager manager = this.managerService.queryManagerByNameAndPwd(infoMap);
					if (manager != null) {
						session.setAttribute("loginUserId", manager.getId());
						session.setAttribute("loginUserName", manager.getName());
						result.setSuccess(true);
					} else {
						msg = "管理员姓名或密码错误!";
						result.setSuccess(false);
					}
				} else {
					msg = "未知错误,请联系管理员!";
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

	@RequestMapping("/goMainPage")
	public String goMainPage(){
		return "/main.jsp";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:loginPage";
	}
}
