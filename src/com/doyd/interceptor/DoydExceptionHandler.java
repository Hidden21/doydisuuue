package com.doyd.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.doyd.action.ControllerContext;
import com.doyd.action.MsgContext;

@Component
public class DoydExceptionHandler implements HandlerExceptionResolver {
	private static final Logger logger = Logger.getLogger(DoydExceptionHandler.class);
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, 
			Object handler, Exception exception) {
		logger.error(request.getRequestURL(), exception);
		int ajax = ControllerContext.getAjaxType(request);
		if(ajax == 2){
			ModelAndView mv = new ModelAndView("error-json");
			MsgContext msg = new MsgContext(false).setMessage("请求时出现异常");
			return mv.addObject("error", msg.toString());
		}else if(ajax == 1){
			ModelAndView mv = new ModelAndView("error-ajax");
			return mv.addObject("error", "请求时出现异常");
		}else{
			ModelAndView mv = new ModelAndView("error");
			return mv.addObject("exception", exception);
		}
	}
	
}
