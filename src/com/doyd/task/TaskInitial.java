package com.doyd.task;


import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import com.doyd.utils.ExecutorsManager;
public class TaskInitial extends HttpServlet {
	
	private static final long serialVersionUID = 7597890384250334790L;
	private static Logger logger  = Logger.getLogger(TaskInitial.class);
	private static ScheduledExecutorService timer = ExecutorsManager.newScheduledThreadPool(3);
	private static final TimeUnit unit = TimeUnit.MILLISECONDS;
	
	/**
	 * 初始化
	 */
	@Override
	public void init() throws ServletException {
		run();
	};
	/**
	 * 执行
	 */
	public void run() {
		logger.info("启动回收门票定时器");
		timer.scheduleWithFixedDelay(new RecoverAward(),10*1000,1000*60*10, unit);
	}
	@Override
	public void destroy() {
		timer.shutdown();
		ExecutorsManager.shutdownNow();
	}

}
