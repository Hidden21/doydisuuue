package com.doyd.dao;

import java.util.List;

import com.doyd.entity.Page;
import com.doyd.entity.SysUser;

public interface ISysUserDao {
	public boolean createSysUser(SysUser su);
	
	public boolean updateSu(SysUser su);
	
	/**
	 * 修改密码
	 */
	public int updatePwd(int suId,String pwd1,String pwd2);
	
	public boolean updatePassword(int suId, String suName, String password);
	
	public boolean updateState(int suId, String suName, int state);
	
	public boolean updateState(int suId, int state);
	
	public boolean updateRealName(int suId, String suName, String suRealName);

	public boolean setLoginAt(int suId, String ip);
	
	public boolean deleteSu(int suId, String suName);
	
	/**
	 * 获取管理员的信息
	 * @param suId
	 * @return
	 */
	public SysUser getSysUser(int suId);
	
	public SysUser getSysUser(String suName);
	
	public List<SysUser> getSysUsers(Page page);
	public List<SysUser> getSysUsers();
	
	
}
