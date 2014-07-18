package com.doyd.dao;

public interface IVisitRecordDao {

	/**
	 * 添加访问记录
	 */
	public int addVisitRecord(String vsTag,int type);
	
	/**
	 * 修改访问记录
	 */
	public int upVisitRecord(String vsTag,String ghId,String openId);
}
