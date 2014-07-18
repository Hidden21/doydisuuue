package com.doyd.dao.impl;

import org.springframework.stereotype.Repository;

import com.doyd.dao.IVisitRecordDao;

@Repository
public class VisitRecordDao extends MyDaoSupport implements IVisitRecordDao {

	/**
	 * 添加访问记录
	 */
	public int addVisitRecord(String vsTag,int type){
		String sql  = "INSERT IGNORE INTO  visit_record(type,vsTag,vsTime) VALUES(?,?,NOW())";
		return update(sql, new Object[]{type,vsTag});
	}
	
	/**
	 * 修改访问记录
	 */
	public int upVisitRecord(String vsTag,String ghId,String openId){
		String sql  = "UPDATE  visit_record SET ghId = ? ,openId = ?,state = 2  WHERE vsTag = ? AND state  = 1 ";
		return update(sql, new Object[]{ghId,openId,vsTag});
	}
}
