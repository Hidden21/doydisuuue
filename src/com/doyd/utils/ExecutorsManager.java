package com.doyd.utils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorsManager {
	
	/**
	 * 数据分析
	 */
	private static ThreadPoolExecutor taskPool = null;
	

	/**
	 * 数据分析
	 * @return
	 */
	public static ThreadPoolExecutor getTaskPool() {
		if(taskPool==null){
			taskPool = newFixedThreadPool(3);
		}
		return taskPool;
	}

	
	public static void shutdownNow(){
		if(taskPool!=null){
			try{
				taskPool.shutdownNow();
			}catch (Exception e) {
			}
			taskPool = null;
		}
	}
	
	public static int getAllTaskSize(){
		return getActiveAndQueueSize(taskPool);
	}
	
	public static ThreadPoolExecutor newFixedThreadPool(int nThreads) {
		return (ThreadPoolExecutor) Executors.newFixedThreadPool(nThreads);
	}

	public static ThreadPoolExecutor newCachedThreadPool() {
		return (ThreadPoolExecutor) Executors.newCachedThreadPool();
	}
	
	public static ThreadPoolExecutor newCachedThreadPool(int corePoolSize) {
		return new ThreadPoolExecutor(corePoolSize, Integer.MAX_VALUE,
									5L, TimeUnit.SECONDS,
									new SynchronousQueue<Runnable>());
	}
	
	public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize) {
		return (ScheduledExecutorService) Executors.newScheduledThreadPool(corePoolSize);
	}
	
	public static int getActiveSize(ThreadPoolExecutor exe){
		if(exe==null){
			return 0;
		}
		return exe.getActiveCount();
	}
	
	public static int getQueueSize(ThreadPoolExecutor exe){
		if(exe==null){
			return 0;
		}
		return exe.getQueue().size();
	}
	
	public static int getActiveAndQueueSize(ThreadPoolExecutor exe){
		if(exe==null){
			return 0;
		}
		return exe.getActiveCount() + exe.getQueue().size();
	}
	
	public static int getPoolSize(ThreadPoolExecutor exe){
		if(exe==null){
			return 0;
		}
		return exe.getPoolSize();
	}
	
	public static int prestartAllCoreThreads(ThreadPoolExecutor exe){
		if(exe==null){
			return 0;
		}
		if(getActiveAndQueueSize(exe)>exe.getCorePoolSize() && exe.getPoolSize()<=exe.getCorePoolSize()/2){
			try{
				return exe.prestartAllCoreThreads();
			}catch (Exception e) {
			}
		}
		return 0;
	}
	
}
