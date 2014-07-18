package com.doyd.task;

import org.apache.log4j.Logger;

public class RecoverAward extends Thread {

	private static Logger logger  = Logger.getLogger(RecoverAward.class);
	public void run() {
		recover();
	}
	
	public void recover(){
		
		logger.info("---------------------over------------------------");
	}
}
