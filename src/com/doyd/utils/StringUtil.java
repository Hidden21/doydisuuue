package com.doyd.utils;

import java.text.DecimalFormat;
import java.util.Random;

import org.springframework.util.StringUtils;

public class StringUtil extends StringUtils{
	private static Random random = new Random();
	
	public static String trim(String str){
		return isEmpty(str)?null:str.trim();
	}
	public static boolean isEmpty(String str){
		return str==null || str.trim().length()==0 || "null".equals(str);
	}
	public static boolean isNotEmpty(String str){
		str = trim(str);
		return str!=null && str.length()>0;
	}
	public static int parseInt(String str){
		return parseInt(str, 0);
	}
	public static int parseInt(String str, int defaultValue){
		try{
			return Integer.parseInt(trim(str));
		}catch (Exception e) {
			return defaultValue;
		}
	}
	
	public static long parseLong(String str){
		return parseLong(str, 0l);
	}
	public static long parseLong(String str, long defaultValue){
		try{
			return Long.parseLong(trim(str));
		}catch (Exception e) {
			return defaultValue;
		}
	}
	
	public static float parseFloat(String str, float defaultValue){
		try{
			return Float.parseFloat(trim(str));
		}catch (Exception e) {
			return defaultValue;
		}
	}
	
	public static double parseDouble(String str, double defaultValue){
		try{
			return Double.parseDouble(trim(str));
		}catch (Exception e) {
			return defaultValue;
		}
	}
	
	public static boolean parseBoolean(String str){
		str = trim(str);
		return "true".equalsIgnoreCase(str) || "1".equalsIgnoreCase(str);
	}
	
	public static String toLikeStr(String str){
		if(isEmpty(str)){
			return null;
		}else{
			return "%"+str+"%";
		}
	}
	
	public static int getRandomInteger(int max) {
		return random.nextInt(max);
	}
	
	public static String getRandomString(int length) {
		String baseStr = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append(baseStr.charAt(random.nextInt(baseStr.length())));
		}
		return sb.toString();
	}
	public static String getRandomInt(int length) {
		String baseStr = "0123456789";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append(baseStr.charAt(random.nextInt(baseStr.length())));
		}
		return sb.toString();
	}
	
	public static String getRandomString(int length, String baseStr) {
		if(isEmpty(baseStr)){
			return getRandomString(length);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append(baseStr.charAt(random.nextInt(baseStr.length())));
		}
		return sb.toString();
	}
	
	public static String toFieldString(String str){
		if(str==null){
			return null;
		}else{
			return "'"+str.replace("\\'", "'").replace("'", "\\'") + "'";
		}
	}
	
	public static String formatNumber(double number, String format){
		DecimalFormat df = new DecimalFormat(format);
		return df.format(number);
	}
	
	/**
	 * 转化为两位数的货币数值
	 * 如number=11.2345,结果为11.23
	 * @param number
	 * @return
	 */
	public static String formatMoney(double number){
		DecimalFormat df = new DecimalFormat("#0.00");
		return df.format(number);
	}
	
	/**
	 * 转化为两位数的货币数值，数值前加上货币符号
	 * 如number=11.2345,currency=￥时，结果为￥11.23
	 * @param number
	 * @param currency 货币符号
	 * @return
	 */
	public static String formatMoney(double number, String currency){
		DecimalFormat df = new DecimalFormat(currency+"#0.00");
		return df.format(number);
	}
	
	/**
	 * 保留8位数数字
	 * @param number
	 * @return
	 */
	public static String format8Decimal(double number){
		DecimalFormat df = new DecimalFormat("#.########");
		return df.format(number);
	}
}
