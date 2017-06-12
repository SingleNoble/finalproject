package com.cmfz.util;

import java.security.MessageDigest;


public class MD5Util {
	public static String getMd5Code(String password){
		try {
			//创建java.security包下的MessageDigest的对象 参数MD5
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			//对password进行加密运算，并返回加密后的byte数组
			byte[] digest = messageDigest.digest(password.getBytes());
			
			//将byte数组转化为16进制长度是32的字符串
			StringBuilder builder = new StringBuilder();
			for (byte b : digest) {
				int n = b & 0xff;
				if(n<16){//转化为16进制数后如果不够两位补0
					builder.append("0");
				}
				builder.append(Integer.toHexString(n));
			}
			return builder.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
