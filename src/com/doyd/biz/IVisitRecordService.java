package com.doyd.biz;

public interface IVisitRecordService {
	/**
	 * 添加访问记录
	 */
	public int addVisitRecord(String vsTag,int type);
	
	/**
	 * 修改访问记录
	 */
	public int upVisitRecord(String vsTag,String ghId,String openId,String vm);
}
