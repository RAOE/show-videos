package com.show.admin.scetc.utils;

import java.security.MessageDigest;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import com.show.admin.scetc.pojo.AdminUser;

public class CommonUtils {

	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}

	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Collection collection) {
		return collection == null || collection.size() < 1;
	}

	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Map map) {
		return map == null || map.size() < 1;
	}

	// 检查字符串长度，字符串为null返回true
	public static boolean isLengthEnough(String str, int length) {
		if (str == null) {
			return false;
		}
		return str.length() >= length;
	}

	public static boolean isEmail(String email) {
		if (email == null) {
			return false;
		}
		return Pattern.matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", email);
	}

	public static boolean isPhone(String phoneNum) {
		if (phoneNum == null) {
			return false;
		}
		return Pattern.matches("^1(\\d{10})$", phoneNum);
	}

	// 计算一个字符串的MD5值
	public final static String calculateMD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput = s.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// 计算两个日期相差天数的绝对值
	public static long calculateApartDays(Date date1, Date date2) {
		// 一天对应的毫秒值
		long day = 1000L * 60 * 60 * 24;
		return Math.abs(date1.getTime() / day - date2.getTime() / day);
	}

	public static String StringFilter(String str) throws PatternSyntaxException {
		// 只允许字母和数字 // String regEx ="[^a-zA-Z0-9]";
		// 清除掉所有特殊字符
		String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\]<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	}

	/**
	 * 对关键字进行脱敏处理
	 * 
	 * @param adminUser
	 * @return
	 */
	public static AdminUser formate(AdminUser adminUser) {
		adminUser.setPassword("??????");
		adminUser.setSalt("??????");
		adminUser.setPhoneNumber("???????");
		return adminUser;
	}

}
