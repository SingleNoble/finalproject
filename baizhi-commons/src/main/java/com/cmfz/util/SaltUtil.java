 package com.cmfz.util;

import java.util.Random;

public class SaltUtil {
	/**
	 * 获取随机盐
	 * @param n 随机盐长度
	 * @return 生成的随机盐
	 */
	public static String getSalt(int n){
		try {
			//随机数组
			char[] code = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz@#$%&".toCharArray();
			Random rd = new Random();
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < n; i++) {
				//随机拼接code字符数组内字符
				builder.append(code[rd.nextInt(code.length)]);
			}
			return builder.toString();
		} catch (Exception e) {
			
		}
		return null;
	}
	/**
	 * 获取纯数字的随机码
	 * @param n 随机码长度
	 * @return  
	 */
	public static String getMsgCode(int n){
		try {
			//随机数组
			char[] code = "1234567890".toCharArray();
			Random rd = new Random();
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < n; i++) {
				//随机拼接code字符数组内字符
				builder.append(code[rd.nextInt(code.length)]);
			}
			return builder.toString();
		} catch (Exception e) {
			
		}
		return null;
	}
	
	
}
