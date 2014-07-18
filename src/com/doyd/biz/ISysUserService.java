package com.doyd.biz;

import java.util.List;
import java.util.Map;

import com.doyd.entity.Page;
import com.doyd.entity.SysUser;

public interface ISysUserService {
	public boolean createSysUser(SysUser su);
	
	public boolean updateSu(SysUser su);
	
	public boolean updatePassword(int suId, String suName, String password);
	
	public boolean updateState(int suId, String suName, int state);
	
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
	
	/**
	 * 获取所有管理员信息
	 * @return
	 */
	public List<SysUser> getSysUsers(Page page);
	
	/**
	 * 删除memcached的缓存
	 * @param suId
	 */
	public void deleteSuCache(int suId);
	public List<SysUser> getSysUsers();
	
	/**
	 * 修改密码
	 */
	public Map<String, Object> updatePwd(int suId,String pwd1,String pwd2);
	
	/**
	 * 添加新的用户
	 */
	public Map<String, Object> createSysUser(SysUser su,String suName,String pwd,String realName,int roleType);
	
	public Map<String, Object> getSysUsers(SysUser su);
	/**
	 * 修改权限
	 */
	public Map<String, Object> setPurview(SysUser su,String type,String suId,String purview,String menu);
}
