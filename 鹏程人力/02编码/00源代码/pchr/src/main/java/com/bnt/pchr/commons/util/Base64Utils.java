package com.bnt.pchr.commons.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;

public class Base64Utils {


	/**
	 * BASE64加密
	 * 
	 * @param str
	 * @return
	 */
	public static String encode(String str) {
		byte[] b = null;
		String s = null;
		try {
			b = str.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (b != null) {
			s = new BASE64Encoder().encode(b);
		}
		return s;
	}

	/**
	 * BASE64加密
	 *
	 * @param b
	 * @return
	 */
	public static String encode(byte[] b) {
		String s = null;
		if (b != null) {
			s = new BASE64Encoder().encode(b);
		}
		return s;
	}

	/**
	 * BASE64 解密
	 * @param s
	 * @return
	 */
	public static String decode(String s) {
		byte[] b = null;
		String result = null;
		if (s != null) {
			BASE64Decoder decoder = new BASE64Decoder();
			try {
				b = decoder.decodeBuffer(s);
				result = new String(b, "utf-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public static String decode(byte[] bs) {
		String result = null;
		if (bs != null) {
			BASE64Decoder decoder = new BASE64Decoder();
			try {
				String str=new String(bs,"utf-8");
				bs = decoder.decodeBuffer(str);
				result = new String(bs, "utf-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
