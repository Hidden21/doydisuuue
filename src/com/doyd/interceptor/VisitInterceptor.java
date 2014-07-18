package com.doyd.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.doyd.action.ControllerContext;
import com.doyd.utils.StringUtil;


/**
 * 这个拦截器主要用来过滤黑名单用户
 * @author chenz
 *
 */
public class VisitInterceptor implements HandlerInterceptor{
	
	
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
		String userAgent  = request.getHeader("User-Agent");
		String wxKey = "MicroMessenger".toLowerCase();
		if(!(StringUtil.isNotEmpty(userAgent) && userAgent.toLowerCase().contains(wxKey))){
			response.sendRedirect(ControllerContext.getBasePath(request)+"errorUrl.html");
			return false;
		}
		return true;
	}
}

