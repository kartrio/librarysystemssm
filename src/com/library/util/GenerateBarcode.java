package com.library.util;

/**
 * 随机生成条形码
 * @author shao
 *
 */
public class GenerateBarcode {

	/**
	 * 随机生成8位条形码
	 * @return
	 */
	public static String generBarcode() {
		String chars = "0123456789";
		char[] rands = new char[12];
		for (int i = 0; i < 12; i++) {
			int rand = (int) (Math.random() * 10.0D);
			rands[i] = chars.charAt(rand);
		}
		return String.valueOf(rands);
	}
}
