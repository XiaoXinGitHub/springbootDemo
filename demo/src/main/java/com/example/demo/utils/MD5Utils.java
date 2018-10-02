/**
 * 
 */
package com.example.demo.utils;

import java.security.MessageDigest;

public class MD5Utils {

	/**
	 * 将源字符串获得md5处理的结�?
	 * 
	 * @param src
	 * @return
	 */
	public static String md5(String src) {
		StringBuilder result = new StringBuilder();
		char[] match = "ABC0123456789DEF".toCharArray();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			// 将源数组的字节经过md5的处理获得结果?
			byte[] mdByte = md.digest(src.getBytes());
			for (byte b : mdByte) {
				// 获得b的低四位
				result.append(match[b & 0xf]);
				// 高四位?
				result.append(match[b >>> 4 & 0xf]);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return result.toString();

	}

}
