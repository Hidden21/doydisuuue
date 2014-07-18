package com.doyd.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	private static final String USER_NAME = "USER_NAME";
	private static final String LOGIN_AT = "LOGIN_AT";
	private static final String USER_RT = "USER_RT";
	private static final String USER_BL = "USER_BL";
	private static final String USER_STATE = "USER_STATE";
//	private static final String EXPIRY_AT = "EXPIRY_AT";
	
	private static final String HX1 = "doyd";
	private static final String HX2 = "!@#$";
	private static final String HX3 = "+-*/";
	private static final int MAX_AGE = 3 * 24 * 3600;
	
	public static void addCookie(HttpServletResponse response,String cookieName,String value){
		    Cookie cook = new Cookie(cookieName,String.valueOf(value));
		    cook.setPath("/");
			cook.setMaxAge(60 * 60 * 24*30*365);
		    response.addCookie(cook);	
	}
	public static String getCookie(HttpServletRequest request,String cookieName){
		String value = "";
		Cookie[] cs = request.getCookies();
		if (cs != null && cs.length >1) {//获取cookie信息
			    for(Cookie c:cs){
			    	 if(cookieName.equals(c.getName())){
			    		value = c.getValue();
			    		break;
			    	 }
			    }
		  }
		return value;
	}
	
	/**
	 * 登录成功后保存COOKIE状态
	 * @param request
	 * @param response
	 * @param loginUserName
	 * @param autoLoginState 以后访问页面时，是否自动登陆，true以后自动登陆， false以后不自动登陆
	 * @param autoLogin 当前登录时，true：cookie自动登陆， false：手动登录
	 */
	public static void addLoginCookies(HttpServletRequest request, HttpServletResponse response, 
			String loginUserName, boolean autoLoginState, boolean autoLogin){
		if(StringUtil.isEmpty(loginUserName) || response==null){
			return;
		}
		int maxAge = -1;
		if(autoLogin){
			maxAge = MAX_AGE;
		}else{
			maxAge = autoLoginState?MAX_AGE:-1;
		}
		deleteCookies(request, response, false);
		String path = request.getContextPath();
//		String domain = request.getHeader("host");
		
		//用户名
		Cookie userNameCookie = new Cookie(USER_NAME, loginUserName);
		userNameCookie.setPath(path);
		userNameCookie.setMaxAge(maxAge);
//		userNameCookie.setDomain(domain);
		response.addCookie(userNameCookie);
		//登录时间
		long loginAt = System.currentTimeMillis()/1000l;//登录时间
		Cookie loginAtCookie = new Cookie(LOGIN_AT, loginAt+"");
		loginAtCookie.setPath(path);
		loginAtCookie.setMaxAge(maxAge);
//		loginAtCookie.setDomain(domain);
		response.addCookie(loginAtCookie);
		
		//随机标签
		String userRandomTag = DoydTagCheck.generateTag((int)(loginAt%1000), 16);
		Cookie userRandomTagCookie = new Cookie(USER_RT, userRandomTag);
		userRandomTagCookie.setPath(path);
		userRandomTagCookie.setMaxAge(maxAge);
//		userRandomTagCookie.setDomain(domain);
		response.addCookie(userRandomTagCookie);
		
		//防伪标签bogus label
		String userBogusLabel = getUserBogusLabel(loginUserName, loginAt, userRandomTag);
		Cookie userBogusLabelCookie = new Cookie(USER_BL, userBogusLabel);
		userBogusLabelCookie.setPath(path);
		userBogusLabelCookie.setMaxAge(maxAge);
//		userBogusLabelCookie.setDomain(domain);
		response.addCookie(userBogusLabelCookie);
		
		//当前登录标签
		String userState = getUserState(loginUserName, loginAt, userRandomTag, userBogusLabel);
		Cookie userStateCookie = new Cookie(USER_STATE, userState);
		userStateCookie.setPath(path);
		userStateCookie.setMaxAge(-1);
//		userStateCookie.setDomain(domain);
		response.addCookie(userStateCookie);
		
	}
	
	/**
	 * 检查是否合法的COOKIE<br/>
	 * 	0：无效<br/>
	 * 	1：有效，但是还没有登录<br/>
	 * 	2：有效，且已经登录<br/>
	 * @param cookies
	 * @param checkUserState 是否检查登录标签
	 * 
	 */
	public static int checkLoginCookies(Cookie[] cookies){
		if(cookies==null || cookies.length<=0){
			return 0;
		}
		String loginUserName = null;
		long loginAt = 0l;
		String userRandomTag = null;
		String userBogusLabel = null;
		String userState = null;
		for(Cookie cookie: cookies){
			if(cookie.getMaxAge()==0){
				continue;
			}
			if(USER_NAME.equals(cookie.getName())){
				loginUserName = cookie.getValue();
			}else if(LOGIN_AT.equals(cookie.getName())){
				loginAt = StringUtil.parseLong(cookie.getValue());
			}else if(USER_RT.equals(cookie.getName())){
				userRandomTag = cookie.getValue();
			}else if(USER_BL.equals(cookie.getName())){
				userBogusLabel = cookie.getValue();
			}else if(USER_STATE.equals(cookie.getName())){
				userState = cookie.getValue();
			}
		}
		if(StringUtil.isEmpty(loginUserName) 
				|| loginAt<(System.currentTimeMillis()/1000-MAX_AGE)
				|| StringUtil.isEmpty(userRandomTag) 
				|| StringUtil.isEmpty(userBogusLabel)
		){
			return 0;
		}
		if(!DoydTagCheck.checkTag((int)(loginAt%1000), userRandomTag)){
			return 0;
		}
		String tmpUserBogusLabel = getUserBogusLabel(loginUserName, loginAt, userRandomTag);
		if(StringUtil.isNotEmpty(userState)){
			String tmpUserState = getUserState(loginUserName, loginAt, userRandomTag, userBogusLabel);
			return userBogusLabel.equals(tmpUserBogusLabel) && userState.equals(tmpUserState)?2:0;
		}else{
			return userBogusLabel.equals(tmpUserBogusLabel)?1:0;
		}
	}
	
	public static String getSuNameValue(Cookie[] cookies){
		return getValue(cookies, USER_NAME);
	}
	
	public static String getValue(Cookie[] cookies, String name){
		if(cookies==null || cookies.length<=0 || StringUtil.isEmpty(name)){
			return null;
		}
		for(Cookie cookie: cookies){
			if(name.equals(cookie.getName())){
				String value = cookie.getValue();
				return value;
			}
		}
		return null;
	}
	
	public static void deleteCookies(HttpServletRequest request, HttpServletResponse response, boolean deleteSessionId){
		String path = request.getContextPath();
//		String domain = request.getHeader("host");
		Cookie[] cookies = request.getCookies();
		if(cookies==null || cookies.length<=0){
			return;
		}
		for(Cookie cookie: cookies){
			if("JSESSIONID".equalsIgnoreCase(cookie.getName()) && !deleteSessionId){
				continue;
			}
			cookie.setMaxAge(0);
			cookie.setPath(path);
//			c.setDomain(domain);
			response.addCookie(cookie);
		}
	}
	
	private static String getUserBogusLabel(String loginUserName, long loginAt, String userRandomTag){
		return EncryptUtil.MD5(loginUserName + HX2 + loginAt + HX1 + userRandomTag);
	}
	private static String getUserState(String loginUserName, long loginAt, String userRandomTag, String userBogusLabel){
		return EncryptUtil.MD5(loginUserName + HX1 +loginAt + HX2 + userRandomTag + HX3 + userBogusLabel);
	}
	
}
