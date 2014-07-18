package com.doyd.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.net.URLCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.doyd.Vars;
import com.doyd.action.ControllerContext;
import com.doyd.action.MsgContext;
import com.doyd.biz.ISysUserService;
import com.doyd.entity.SysUser;
import com.doyd.utils.CookieUtil;
import com.doyd.utils.StringUtil;


/**
 * 这个拦截器主要用来过滤黑名单用户
 * @author chenz
 *
 */
public class LoginInterceptor implements HandlerInterceptor{
	
	@Autowired
	private ISysUserService sysUserService;

	public void setSysUserService(ISysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}
	
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception exception)
			throws Exception {
	}

	@SuppressWarnings("unchecked")
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2, ModelAndView arg3) throws Exception {
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {

		ControllerContext.setBasePath(request);
		String uri = request.getServletPath();
		if(uri!=null && uri.startsWith("/")){
			uri = uri.substring(1);
		}
		//如果是当前路径属于白名单路径
		if(uri.matches(Vars.ANONYMOUS_ACCESS_PATH)){
			return true;
		}
		int suId = ControllerContext.getSuId(request);
		if(suId<=0){
			int cookiesState = CookieUtil.checkLoginCookies(request.getCookies());
			if(cookiesState==2){
				//如果cookie标识已登录
				String suName = CookieUtil.getSuNameValue(request.getCookies());
				if(suName!=null){
					SysUser su = sysUserService.getSysUser(suName);
					if(su!=null && su.getState()==1){
						suId = su.getSuId();
						request.setAttribute(Vars.CURRENT_USER, su);
						request.getSession().setAttribute(Vars.CURRENT_USER_ID, su.getSuId());
						return true;
					}
				}
				CookieUtil.deleteCookies(request, response, false);
			}else if(cookiesState==1){
				//如果未登陆，则自动登录
				String basePath = (String) request.getAttribute(Vars.BASE_PATH);
				String url = request.getQueryString();
				url = (url==null||url.length()==0)?"":("?"+url);
				url = new URLCodec().encode(request.getRequestURL().toString()+url);
				response.sendRedirect(basePath+"ssologin.html?url="+url);
				return false;
			}else{
				CookieUtil.deleteCookies(request, response, false);
			}
		}
		if(suId>0){
			SysUser su = sysUserService.getSysUser(suId);
			if(su!=null && su.getState()==1){
				request.setAttribute(Vars.CURRENT_USER, su);
				return true;
			}
		}
		/**
		 * 是否使用ajax提交请求的标志，0：无ajax，1：ajax请求页面数据，2：ajax请求json数据
		 */
		int ajax = ControllerContext.getAjaxType(request);
		String basePath = (String) request.getAttribute(Vars.BASE_PATH);
		if(ajax==0){
			String url = request.getQueryString();
			url = (url==null||url.length()==0)?"":("?"+url);
			url = new URLCodec().encode(request.getRequestURL().toString()+url);
			response.sendRedirect(basePath+"/loginHome.html?url="+url);
		}else if(ajax==1){
			//response.sendRedirect(basePath);
			String url = request.getHeader("referer");
			if(StringUtil.isNotEmpty(url)){
				url = basePath+"/loginHome.html?url="+new URLCodec().encode(url);
			}else{
				url = basePath+"/loginHome.html";
			}
			StringBuilder msg = new StringBuilder();
			msg.append("<span class=\"hint\">登陆超时，需要重新登录，如果没有自动跳转到登陆页面，")
				.append("<a href=\""+url+"\" target=\"_self\">请点这里</a></span>").append("\r\n")
				.append("<script type=\"text/javascript\">").append("\r\n")
				.append("window.location.href=\""+url+"\";").append("\r\n")
				.append("</script>").append("\r\n");
			ControllerContext.print(response, msg.toString(), "text/html;charset=utf-8");
		}else if(ajax==2){
			String url = request.getHeader("referer");
			if(StringUtil.isNotEmpty(url)){
				url = basePath+"/loginHome.html?url="+new URLCodec().encode(url);
			}else{
				url = basePath+"/loginHome.html";
			}
			MsgContext msg = new MsgContext(false).setMessage(Vars.NO_LOGIN_TAG).setInfo(url);
			ControllerContext.print(response, msg.toString(), "text/html;charset=utf-8");
		}else{
			String url = request.getHeader("referer");
			if(StringUtil.isNotEmpty(url)){
				url = basePath+"/loginHome.html?url="+new URLCodec().encode(url);
			}else{
				url = basePath+"/loginHome.html";
			}
			StringBuilder msg = new StringBuilder();
			msg.append("<span class=\"hint\">登陆超时</span>").append("\r\n")
				.append("<script type=\"text/javascript\">").append("\r\n")
				.append("window.location.href=\""+url+"\";").append("\r\n")
				.append("</script>").append("\r\n");
			ControllerContext.print(response, msg.toString(), "text/html;charset=utf-8");
		}
		return false;
	
	}
}

