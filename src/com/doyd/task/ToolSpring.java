package com.doyd.task;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ToolSpring implements  ApplicationContextAware {
	private static Logger logger = Logger.getLogger(ToolSpring.class);
	
	private static ApplicationContext applicationContext = null;
	
	public static ApplicationContext getAppContext() {
		return applicationContext;
	}
	public static Object getBean(String name){
		return applicationContext.getBean(name);
	}
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		if(ToolSpring.applicationContext == null){
			ToolSpring.applicationContext = context;
			logger.info("---------------------------------------------------------------------");
			logger.info("========ApplicationContext配置成功,在普通类可以通过调用ToolSpring.getAppContext()获取applicationContext对象,applicationContext="+applicationContext+"========");
			logger.info("---------------------------------------------------------------------");
		}
	}
	
}
