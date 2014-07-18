package com.doyd.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.doyd.Vars;
import com.doyd.entity.SysUser;
import com.doyd.utils.RegexUtil;
import com.doyd.utils.StringUtil;

public class ControllerContext {
	
	public static MsgContext validateCode(HttpServletRequest request){
		String code = request.getParameter("code");//用户输入的验证码
		String validateCode = (String) request.getSession().getAttribute("validateCode");//真正的验证码，最后13位是时间戳
		
		request.getSession().removeAttribute("validateCode");
		
		if(StringUtil.isEmpty(validateCode) || validateCode.length()<=13){
			return new MsgContext(false, null, "验证码失效");
		}
		if(StringUtil.isEmpty(code)){
			return new MsgContext(false, null, "请填写验证码");
		}
		long t = StringUtil.parseLong(validateCode.substring(0, 13));
		if(System.currentTimeMillis()-t>200000){
			return new MsgContext(false, null, "验证码过期");
		}
		validateCode = validateCode.substring(13);
		if(!code.equalsIgnoreCase(validateCode)){
			return new MsgContext(false, null, "验证码错误，请重新填写");
		}
		return new MsgContext(true, null);
	}
	
	public static final String REFLUSH_DEFAULT = "reflush_server";
	public static final String REFLUSH_PRODUCT = "reflush_server_product";
	public static boolean flushClientCache(HttpServletRequest request, boolean reflush){
		return flushClientCache(request, reflush, REFLUSH_DEFAULT);
	}
	
	public static boolean flushClientCache(HttpServletRequest request, boolean reflush, String reflushName){
		if(reflush){
			request.setAttribute(REFLUSH_DEFAULT, reflushName);
		}
		return reflush;
	}
	
	public static String noexist(HttpServletRequest request, String error, boolean simple){
		request.setAttribute("error", error);
		if(simple){
			request.setAttribute("error", simple);
			return "error-view";
		}else{
			request.setAttribute("uri", "error-view.jsp");
			return "index";
		}
	}
	
	public static int getSuId(HttpServletRequest request){
		Integer uid = (Integer) request.getSession().getAttribute(Vars.CURRENT_USER_ID);
		if(uid==null){
			return 0;
		}
		return uid.intValue();
	}
	
	public static SysUser getSu(HttpServletRequest request){
		SysUser su = (SysUser) request.getAttribute(Vars.CURRENT_USER);
		return su;
	}
	
	public static String getIp(HttpServletRequest request){
		String ip = request.getHeader("x-forwarded-for");
		String regex = Vars.RULES_IP;
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}else{
			ip = RegexUtil.getMatchString(ip, regex, 0);
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}else{
			ip = RegexUtil.getMatchString(ip, regex, 0);
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	public final static String getBasePath(HttpServletRequest request) {
		StringBuffer basePath = new StringBuffer();
		basePath.append(request.getScheme()).append("://");
		basePath.append(request.getServerName());
		if(request.getServerPort()!=80){
			basePath.append(":").append(request.getServerPort());
		}
		basePath.append(request.getContextPath()).append("/");
		return basePath.toString();
	}
	
	public final static String getBasePathWithoutContextPath(HttpServletRequest request) {
		StringBuffer basePath = new StringBuffer();
		basePath.append(request.getScheme()).append("://");
		basePath.append(request.getServerName());
		if(request.getServerPort()!=80){
			basePath.append(":").append(request.getServerPort());
		}
		basePath.append("/");
		return basePath.toString();
	}
	
	/**
	 * 设置basePath路径
	 * 
	 * @param request
	 */
	public final static void setBasePath(HttpServletRequest request) {
		StringBuffer basePath = new StringBuffer();
		basePath.append(request.getScheme()).append("://");
		basePath.append(request.getServerName());
		if(request.getServerPort()!=80){
			basePath.append(":").append(request.getServerPort());
		}
		basePath.append(request.getContextPath()).append("/");
		request.setAttribute(Vars.BASE_PATH, basePath.toString());
	}
	
	public final static void print(HttpServletResponse response, String msg, String contentType){
		if(contentType!=null){
			response.setContentType(contentType);
		}else{
			response.setContentType("text/html;charset=utf-8");
		}
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(msg.toString());
		} catch (IOException e) {
			System.err.println("向页面打印的时候出错：\n" + e + "\n所要打印的内容：" + msg);
		} finally {
			if (out != null) {
				out.flush();
				out.close();
			}
		}
	}
	
	public static String getCookies(HttpServletRequest request){
		String cookie = null;
		Cookie[] cs = request.getCookies();
		if (cs != null && cs.length >1) {//获取cookie信息
			    for(Cookie c:cs){
			    	 if(Vars.CKVF.equals(c.getName())){
			    		cookie = c.getValue();
			    		break;
			    	 }
			    }
		  }
		return cookie;
	}
	public static String getCookies(HttpServletRequest request,String name){
		String cookie = null;
		Cookie[] cs = request.getCookies();
		if (cs != null && cs.length >1) {//获取cookie信息
			    for(Cookie c:cs){
			    	 if(name.equalsIgnoreCase(c.getName())){
			    		cookie = c.getValue();
			    		break;
			    	 }
			    }
		  }
		return cookie;
	}
	public static String setCookies(HttpServletResponse response,String cookie){
	    Cookie cook = new Cookie(Vars.CKVF,cookie );
		cook.setMaxAge(60 * 60 * 24*365);
		cook.setPath("/");
	    response.addCookie(cook);	
		return cookie;
	}
	public static String setCookies(HttpServletResponse response,String name,String cookie){
	    Cookie cook = new Cookie(name,cookie );
		cook.setMaxAge(60 * 60 * 24*365);
		cook.setPath("/");
	    response.addCookie(cook);	
		return cookie;
	}
	/**
	 * 
	 * @param request
	 * @return
	 * 	0：非ajax请求
	 * 	1：普通ajax请求页面数据
	 *  2：ajax请求json数据
	 */
	public final static int getAjaxType(HttpServletRequest request){
		int ajax = StringUtil.isEmpty(request.getHeader("X-Requested-With"))?0:1;
		if(ajax!=0){
			String accept = request.getHeader("accept");
			ajax = StringUtil.isNotEmpty(accept) && accept.indexOf("application/json")>=0?2:1;
		}
		return ajax;
	}
}
