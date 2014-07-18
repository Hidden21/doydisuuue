package com.doyd.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 操作数组的工具
 * @author chenz
 *
 */
public class NumberUtils {

	/**
	 * 让double数字按照指定的模式显示
	 * @param num
	 * @return
	 */
	public static String formatDouble(double num){
		//String pattern = "#,##0.00";
		String pattern = "#.00";
		DecimalFormat df  = new DecimalFormat(pattern); 
		String temp = df.format(num);
		return temp; 
	}
	public static String formatDouble2(double num){
		String pattern = "#,##0.00";
		DecimalFormat df  = new DecimalFormat(pattern); 
		String temp = df.format(num);
		return temp; 
	}
	public static String formatDouble3(double num){
		String pattern = "000000";
		DecimalFormat df  = new DecimalFormat(pattern); 
		String temp = df.format(num);
		return temp; 
	}
	public static double  formatDouble2Str(double num){
		String temp = formatDouble(num);
		return Double.valueOf(temp); 
	}
	
	/**  
     * 对double数据进行取精度.  
     * @param value  double数据.  
     * @param scale  精度位数(保留的小数位数).  
     * @param roundingMode  精度取值方式.  
     * @return 精度计算后的数据.  
     */  
    public static double round(double value, int scale, 
             int roundingMode) {   
        BigDecimal bd = new BigDecimal(value);   
        bd = bd.setScale(scale, roundingMode);   
        double d = bd.doubleValue();   
        bd = null;   
        return d;   
    }   


     /** 
     * double 相加 
     * @param d1 
     * @param d2 
     * @return 
     */ 
    public static double sum(double d1,double d2){ 
        BigDecimal bd1 = new BigDecimal(Double.toString(d1)); 
        BigDecimal bd2 = new BigDecimal(Double.toString(d2)); 
        return bd1.add(bd2).doubleValue(); 
    } 


    /** 
     * double 相减 
     * @param d1 
     * @param d2 
     * @return 
     */ 
    public static double sub(double d1,double d2){ 
        BigDecimal bd1 = new BigDecimal(Double.toString(d1)); 
        BigDecimal bd2 = new BigDecimal(Double.toString(d2)); 
        return bd1.subtract(bd2).doubleValue(); 
    } 

    /** 
     * double 乘法 
     * @param d1 
     * @param d2 
     * @return 
     */ 
    public static double mul(double d1,double d2){ 
        BigDecimal bd1 = new BigDecimal(Double.toString(d1)); 
        BigDecimal bd2 = new BigDecimal(Double.toString(d2)); 
        return bd1.multiply(bd2).doubleValue(); 
    } 

    /** 
     * double 除法 
     * @param d1 
     * @param d2 
     * @param scale 四舍五入 小数点位数 
     * @return 
     */ 
    public static double div(double d1,double d2,int scale){ 
        //  当然在此之前，你要判断分母是否为0，   
        //  为0你可以根据实际需求做相应的处理 

        BigDecimal bd1 = new BigDecimal(Double.toString(d1)); 
        BigDecimal bd2 = new BigDecimal(Double.toString(d2)); 
        return bd1.divide (bd2,scale,BigDecimal.ROUND_HALF_UP).doubleValue(); 
    } 
	public static void main(String[] args) {
		String d1 = NumberUtils.formatDouble3(1.456456);
		System.out.println(d1);
	}
}
