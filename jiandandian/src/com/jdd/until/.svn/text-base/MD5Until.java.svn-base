package com.jdd.until;

import java.security.MessageDigest;

/*
 *@author:David admin@dxscx.com
 *@Version: 1.0
 *@Description:  What do you want to do?
 *@Time:2016-6-19  下午2:44:08
 */
public class MD5Until {
	public static String toMd5(String password) {
		char[] str = null;
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		String myinfo = password;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(myinfo.getBytes());
			byte[] bytes = md.digest();
			// 把密文转换成十六进制的字符串形式
			int j = bytes.length;
			str = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = bytes[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return new String(str);
	}
}
