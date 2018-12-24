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

	/**
	 * 生成验证码
	 * @param request
	 * @param response
	 */
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

	/**
	 * 跳转到登录页面
	 * @return
	 */
	@RequestMapping("/loginPage")
	public String loginPage() {
		return "login";
	}

	/**
	 * 登录
	 * @param name
	 * @param password
	 * @param role
	 * @param checkcode
	 * @param session
	 * @return
	 */
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
						session.setAttribute("loginUserStatus", readerInfo.getStatus());
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

	/**
	 * 跳转到主界面
	 * @return
	 */
	@RequestMapping("/goMainPage")
	public String goMainPage(){
		return "main";
	}
	
	/**
	 * 登出
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:loginPage";
	}
	
	/**
	 * 跳转到修改密码界面
	 * @return
	 */
	@RequestMapping("/updatePwdPage")
	public String updatePwdPage(){
		return "updatePwd";
	}
	
	/**
	 * 修改密码
	 * @param id
	 * @param role
	 * @param initalPwd
	 * @param newPwd
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updatePwd")
	public Object updatePwd(Integer id, String role, String initalPwd, String newPwd){
		AJAXResult result = new AJAXResult();
		String msg = "";
		try {
			if("reader".equals(role)){
				ReaderInfo readerInfo = readerService.getReaderInfoById(id);
				if(readerInfo != null){
					if(initalPwd.equals(readerInfo.getPwd())){
						Map<String, Object> infoMap = new HashMap<>();
						infoMap.put("id", id);
						infoMap.put("pwd", newPwd);
						readerService.updateReaderInfo(infoMap);
						result.setSuccess(true);
					}else{
						msg = "初始密码错误!";
						result.setSuccess(false);
					}
				}else{
					msg = "未知错误,请联系管理员!";
					result.setSuccess(false);
				}
			}else if("manager".equals(role)){
				Manager manager = managerService.getManagerById(id);
				if(manager != null){
					if(initalPwd.equals(manager.getPWD())){
						Manager m2 = new Manager();
						m2.setId(id);
						m2.setPWD(newPwd);
						managerService.editManager(m2);
						result.setSuccess(true);
					}else{
						msg = "初始密码错误!";
						result.setSuccess(false);
					}
				}else{
					msg = "未知错误,请联系管理员!";
					result.setSuccess(false);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = "未知错误,请联系管理员!";
			result.setSuccess(false);
		}
		result.setData(msg);
		return result;
	}
	
	/**
	 * 根据角色判断需要加载的用户信息页面种类
	 * 1. 读者
	 * 2. 管理员
	 * @param role
	 * @return
	 */
	@RequestMapping("/userInfoPage")
	public String userInfoPage(String role){
		if("reader".equals(role)){
			return "reader/findReaderInfoById";
		}else if("manager".equals(role)){
			return "library/findManagerById";
		}else{
			return "redirect:loginPage";
		}
	}
}
