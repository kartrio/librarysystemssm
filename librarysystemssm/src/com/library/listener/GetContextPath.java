package com.library.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 将项目根路径保存到application中
 * @author Administrator
 *
 */
public class GetContextPath implements ServletContextListener {
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		sc.removeAttribute("APP_PATH");
	}

	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();

		String APP_PATH = sc.getContextPath();

		sc.setAttribute("APP_PATH", APP_PATH);
	}
}
