package com.doyd.utils;

public class GeoUtil {
	public static boolean checkLng(double lng){
		return lng>=-180 && lng<=180;
	}
	
	public static boolean checkLat(double lat){
		return lat>=-90 && lat<=90;
	}
	
	public static boolean checkChnLng(double lng){
		return lng>=73 && lng<=135;
	}
	
	public static boolean checkChnLat(double lat){
		return lat>=17 && lat<=53.5;
	}
}
