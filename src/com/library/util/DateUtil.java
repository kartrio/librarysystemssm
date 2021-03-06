package com.library.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间处理工具类
 * @author Administrator
 *
 */
public class DateUtil {

	/**
	 * 返回给定时间加上指定的天数后的日期
	 * 使用long存在long溢出的问题
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date addDays(Date date, int days){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return new Date(cal.getTimeInMillis());
	}
	
	/**
	 * 将日期转换为字符串
	 * @param date
	 * @return
	 */
	public static String dateToStr(Date date){
		String str = "";
		if(date != null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 	str = sdf.format(date);
		}
		return str;
	}
}
