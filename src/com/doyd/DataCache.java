package com.doyd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

import com.doyd.utils.HttpClientUtil;
import com.doyd.utils.PropertiesUtil;
import com.doyd.utils.StringUtil;

public class DataCache {

	
	/**
	 * 系统管理员角色缓存
	 */
	private static Map<Integer, String> suRoles = new HashMap<Integer, String>();
	
	private static List<String> keyWrods = new ArrayList<String>();
	
	private static HttpClientUtil client = null;
	
	
	private DataCache(){};
	
	
	public static WebApplicationContext getWac(){
		return ContextLoaderListener.getCurrentWebApplicationContext();
	}
	
	
	public static List<String> getKeyWrods(){
		if(keyWrods == null || keyWrods.size() < 1){
			reflushkeyWrods();
		}
		return keyWrods;
	}
	
	public static void reflushkeyWrods(){
		String key = PropertiesUtil.getProperty("keyWord");
		 if(StringUtil.isNotEmpty(key)){
			  String[] keys = key.split(",");
			  if(keys !=null && keys.length > 0){
				  for(String s :keys){
					  if(StringUtil.isNotEmpty(s)){
						  keyWrods.add(s);
					  }
				  }
			  }
		  }
	}
	
	public static Map<Integer, String> getSuRoles(){
		if(suRoles.size()<=0){
			reflushSuRole();
		}
		return suRoles;
	}
	
	public static void reflushSuRole(){
		synchronized (suRoles) {
			suRoles.clear();
			suRoles.put(1, "超级管理员");
			suRoles.put(2, "普通管理员");
		}
	}
	
	public static HttpClientUtil getClient(){
		if(client==null){
			client = new HttpClientUtil();
		}
		return client;
	}
	

	
}
