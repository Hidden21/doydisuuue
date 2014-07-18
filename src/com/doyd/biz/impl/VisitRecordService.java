package com.doyd.biz.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doyd.biz.IVisitRecordService;
import com.doyd.dao.IVisitRecordDao;
import com.doyd.utils.StringUtil;

@Service
public class VisitRecordService implements IVisitRecordService {

	@Autowired
	private IVisitRecordDao visitDao;
	public int addVisitRecord(String vsTag,int type) {
		if(StringUtil.isNotEmpty(vsTag)){
			return this.visitDao.addVisitRecord(vsTag,type);
		}
		return  0 ;
	}

	public int upVisitRecord(String vsTag, String ghId, String openId,String sm) {
		if(verify(sm, openId, ghId) && StringUtil.isNotEmpty(vsTag)){
			return this.visitDao.upVisitRecord(vsTag, ghId, openId);
		};
		return 0;
	}
	/**
	 * 校验验证码
	 */
	 public static boolean verify(String sm,String openId,String ghId){
		 boolean flag = false;
		 if(StringUtil.isNotEmpty(sm) &&  sm.length() == 8 ){
			 char a = sm.charAt(1);
			 char b  = sm.charAt(6);
			 String newUrl  = sm.substring(0, 1) + sm.substring(2, 6)+sm.substring(7);
			 String md5  = DigestUtils.md5Hex(newUrl+ghId+openId);
			 char c  = md5.charAt(0);
			 char d = md5.charAt(7);
			 return (a==c && b == d);
		 }
		 return flag; 
	 }
}
