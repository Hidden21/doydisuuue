package com.doyd.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class PropertiesUtil {
	private static Properties properties = null;
	private static final String file = "/config.properties";
	/**
	 * 读取配置文件信息
	 * 
	 * @param file
	 *            配置文件路径名称，相对于/WEB-INF/classes
	 * @return 
	 */
	private static void loadProperties(){
		URL resource = PropertiesUtil.class.getClassLoader().getResource(file);
		InputStream input = null;
		try {
			input = resource.openStream();
			properties = new Properties();
			properties.load(input);
		} catch (FileNotFoundException e) {
			System.err.println("找不到配置文件：" + file);
		} catch (IOException e) {
			System.err.println("读取配置文件时出错：" + file);
		} finally {
			try {
				if (input != null) {
					input.close();
				}
			} catch (Exception e) {
				System.err.println("关闭配置文件：" + file + " 时出错！");
			}
		}
	}
	
	/**
	 * 读取配置文件信息
	 * 
	 * @param fileName
	 *            配置文件路径名称，相对于/WEB-INF/classes
	 * @return Properties
	 */
	public static Properties loadProperties(String fileName){
		URL resource = PropertiesUtil.class.getClassLoader().getResource(fileName);
		InputStream input = null;
		try {
			if(resource==null){
				return null;
			}
			input = resource.openStream();
			Properties properties = new Properties();
			properties.load(input);
			return properties;
		} catch (FileNotFoundException e) {
			System.err.println("找不到配置文件：" + fileName);
		} catch (IOException e) {
			System.err.println("读取配置文件时出错：" + fileName);
		} finally {
			try {
				if (input != null) {
					input.close();
				}
			} catch (Exception e) {
				System.err.println("关闭配置文件：" + fileName + " 时出错！");
			}
		}
		return null;
	}
	
	public static String getProperty(String key){
		if(properties==null){
			loadProperties();
		}
		return properties==null ? null : properties.getProperty(key);
	}
	
	
	public static void refresh(){
		loadProperties();
	}
	
	public static void setProperty(String key, String value){
		if(properties==null){
			loadProperties();
		}
		if(properties==null){
			return;
		}
		properties.setProperty(key, value);
	}
	
	public static void setPropertyToFile(String key, String value){
		if(properties==null){
			loadProperties();
		}
		if(properties==null){
			return;
		}
		properties.setProperty(key, value);
		FileOutputStream out = null;
		try {
			URL resource = PropertiesUtil.class.getClassLoader().getResource(file);
			out = new FileOutputStream(resource.getPath());
			properties.store(out, null);
		} catch (FileNotFoundException e) {
			System.err.println("找不到配置文件：" + file);
		} catch (IOException e) {
			System.err.println("设置配置文件时出错：" + file);
		} finally{
			if(out!=null){
				try {
					out.close();
				} catch (IOException e) {
					System.err.println("关闭配置文件：" + file + " 时出错！");
				}
			}
		}
	}
}
