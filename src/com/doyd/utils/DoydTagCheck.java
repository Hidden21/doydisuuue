package com.doyd.utils;

import java.security.MessageDigest;
import java.util.Random;

import org.apache.commons.codec.digest.DigestUtils;

public class DoydTagCheck {
	private DoydTagCheck(){
	}
	public static boolean check_pageMode(String cuTag,String smTag,String pwd){
		if(StringUtil.isNotEmpty(smTag) && StringUtil.isNotEmpty(cuTag) 
				&& cuTag.length() == 16 && smTag.length() == 32){
			  String day = DateUtil.now(DateUtil.DEFAULT_DAY_FORMAT);
			  pwd = StringUtil.isNotEmpty(pwd) ? "szdoyd":pwd;
			  return smTag.equals(md5Hex(pwd+cuTag+day));
		}
		return false;
	}
	
	public static String  ctTag(String cuTag,String pwd){
			  String day = DateUtil.now(DateUtil.DEFAULT_DAY_FORMAT);
			  pwd = StringUtil.isNotEmpty(pwd) ? "szdoyd":pwd;
			  return md5Hex(pwd+cuTag+day);
	}
	public static String md5Hex(String inStr){
		return DigestUtils.md5Hex(inStr);
	}
	public static String md5(String inStr) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		char[] charArray = inStr.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];

		byte[] md5Bytes = md5.digest(byteArray);

		StringBuffer hexValue = new StringBuffer();

		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16) {
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}
	
	private static final String SECRET = "D!0@Y#D$";
	private static final String BASE_STRING = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final Random random = new Random();
	private static final int CK_MIN_LENGTH = 8;
	private static final int CK_DF_ID  = 8;
	
	
	/**
	 * 随机生成带有校验效果的标签
	 * @param length 标签长度，最低CK_MIN_LENGTH位长度
	 */
	public static String generateTag(int id, int length){
		if(id < 1){
			id = CK_DF_ID;
		}
		if(length<CK_MIN_LENGTH) length = CK_MIN_LENGTH;
		StringBuilder sb = new StringBuilder(generateRandom(length-4));
		String checkStr = md5(sb.toString()+SECRET);
		sb.append(checkStr.charAt(30));
		int pos = BASE_STRING.indexOf(checkStr.charAt(10));
		pos = pos % (length-4);
		sb.insert(pos, checkStr.charAt(20));
		sb.insert(3, checkStr.charAt(10));
		pos  = id % 32;
		sb.insert(0, checkStr.charAt(pos));
		return sb.toString();
	}
	
	public static String generateRandom(int length){
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<length; i++){
			sb.append(BASE_STRING.charAt(random.nextInt(BASE_STRING.length())));
		}
		return sb.toString();
	}
	
	/**
	 * 检查标签是否合法
	 * @param str
	 * @return
	 */
	public static boolean checkTag(int id, String str){
		if(str==null || str.length()<CK_MIN_LENGTH){
			return false;
		}
		if(id < 1){
			id = CK_DF_ID;
		}
		StringBuilder sb = new StringBuilder(str);
		char ck0 = sb.charAt(0);
		sb.deleteCharAt(0);
		char ck1 = sb.charAt(3);
		sb.deleteCharAt(3);
		int pos = BASE_STRING.indexOf(ck1);
		pos = pos % (str.length()-4);
		char ck2 = sb.charAt(pos);
		sb.deleteCharAt(pos);
		char ck3 = sb.charAt(sb.length()-1);
		sb.deleteCharAt(sb.length()-1);
		String check = md5(sb.toString()+SECRET);
		pos = id % 32;
		return check.charAt(pos)==ck0 && check.charAt(10)==ck1 && check.charAt(20)==ck2 && check.charAt(30)==ck3;
	}
	
	public static void main(String[] args) {
		String str = generateTag(8, 16);
		
		System.out.println(str);
		System.out.println(checkTag(8, str));
		System.out.println(md5Hex("5"+"doyd"));
	}
}
