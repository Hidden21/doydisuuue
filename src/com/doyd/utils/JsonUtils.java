package com.doyd.utils;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

import javax.servlet.jsp.jstl.sql.Result;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * 转换成json的格式
 * @author Administrator
 *
 */
public class JsonUtils {
	
	public static  JSONObject parseJson(Map<String,Object> map) {
		JSONObject json = new JSONObject();
		if (map == null || map.size() < 1) {
			return json;
		}
		try {
			for (Entry<String, Object> element : map.entrySet()) {
				json.put(element.getKey() + "", element.getValue() == null ? "" : element.getValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}

	public static JSONArray parseJson(List<Map> lists){
		JSONArray array = new JSONArray();
		if(lists.size()>0) {
			for(int i  = 0;i<lists.size();i++){
				array.put(lists.get(i));
			}
		}
		return array;
	}
	
	



	public static  JSONObject parseJson(String key, Object value) {
		return parseJson(new JSONObject(), key, value);
	}
	
	public  static JSONObject parseJson(JSONObject parent, String key, Object value) {
		try {
			return parent.put(key, value);
		} catch (JSONException e) {
			return new JSONObject();
		}
	}

	
 
  
 

}
