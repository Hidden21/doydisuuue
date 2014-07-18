package com.doyd.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doyd.biz.ISysUserService;
import com.doyd.dao.ISysUserDao;
import com.doyd.entity.Page;
import com.doyd.entity.SysUser;
import com.doyd.utils.DoydTagCheck;

@Service
public class SysUserService implements ISysUserService {
	@Autowired
	private ISysUserDao sysUserDao;
	public boolean createSysUser(SysUser su){
		su.setSuPwd(DigestUtils.md5Hex(su.getSuPwd()));
		return sysUserDao.createSysUser(su);
	}
	
	public boolean updateSu(SysUser su){
		deleteSuCache(su.getSuId());
		return sysUserDao.updateSu(su);
	}
	
	public boolean updatePassword(int suId, String suName, String password){
		deleteSuCache(suId);
		return sysUserDao.updatePassword(suId, suName, password);
	}
	
	public boolean updateState(int suId, String suName, int state){
		deleteSuCache(suId);
		return sysUserDao.updateState(suId, suName, state);
	}
	
	public boolean updateRealName(int suId, String suName, String suRealName){
		deleteSuCache(suId);
		return sysUserDao.updateRealName(suId, suName, suRealName);
	}
	
	public boolean deleteSu(int suId, String suName){
		deleteSuCache(suId);
		return sysUserDao.deleteSu(suId, suName);
	}
	
	public boolean setLoginAt(int suId, String ip){
		return sysUserDao.setLoginAt(suId, ip);
	}
	
	public SysUser getSysUser(int suId){
		return sysUserDao.getSysUser(suId);
	}
	
	public SysUser getSysUser(String suName){
		return sysUserDao.getSysUser(suName);
	}
	
	public List<SysUser> getSysUsers(Page page){
		return sysUserDao.getSysUsers(page);
	}
	public List<SysUser> getSysUsers(){
		return sysUserDao.getSysUsers();
	}
	public void deleteSuCache(int suId){
	}
	/**
	 * 修改密码
	 */
	public Map<String, Object> updatePwd(int suId,String pwd1,String pwd2){
		 Map<String, Object> map  = new HashMap<String, Object>();
		 pwd1 = DoydTagCheck.md5Hex(pwd1);
		 pwd2 = DoydTagCheck.md5Hex(pwd2);
		 map.put("status", sysUserDao.updatePwd(suId, pwd1, pwd2));
		 return map;
	}
	/**
	 * 添加新的用户
	 */
	public Map<String, Object> createSysUser(SysUser su,String suName,String pwd,String realName
			,int roleType){
		Map<String, Object>  map = new HashMap<String, Object>();
		int status  = - 1;
		String msg = ""	;
		if(su.getRoleType() == 1){
			SysUser user = new SysUser();
			user.setSuName(suName);
			user.setSuPwd(DoydTagCheck.md5Hex(pwd));
			user.setSuRealName(realName);
			user.setState(1);
			user.setRoleType(roleType);
			status  = sysUserDao.createSysUser(user) ? 1 : -1;
			msg  = status > 0 ? "添加用户成功！":"添加用户失败！";
		}else{
			msg = " 不是系统管理员，没有添加权限！" ;
		}
		map.put("status", status);
		map.put("msg", msg);
		return map;
	}
	public Map<String, Object> getSysUsers(SysUser su){
		Map<String, Object>  map = new HashMap<String, Object>();
		int status  = - 1;
		String msg = ""	;
//		if(su.getRoleType() == 1){
//			status  = 1 ;
			map.put("rs", sysUserDao.getSysUsers());
		/*}else{
			msg = " 不是系统管理员，没有该权限！" ;
		}*/
		map.put("status", status);
		map.put("msg", msg);
		return map;
	}

	public Map<String, Object> setPurview(SysUser su, String type, String suId,
			String purview, String menu) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
