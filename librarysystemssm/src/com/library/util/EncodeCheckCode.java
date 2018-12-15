package com.library.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 使用MD5进行加密
 * @author Administrator
 *
 */
public class EncodeCheckCode {
	public static String encode(String str, String algorithm) {
		if (str == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		try {
			MessageDigest code = MessageDigest.getInstance(algorithm);

			code.update(str.getBytes());

			byte[] bs = code.digest();
			for (int i = 0; i < bs.length; i++) {
				int v = bs[i] & 0xFF;
				if (v < 16) {
					sb.append(0);
				}
				sb.append(Integer.toHexString(v));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static String encodeByMD5(String str) {
		return encode(str, "MD5");
	}

	public static boolean isValidInput(String str) {
		return str.matches("[a-z0-9]+");
	}
}
