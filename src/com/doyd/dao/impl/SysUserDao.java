package com.doyd.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.doyd.dao.ISysUserDao;
import com.doyd.entity.Page;
import com.doyd.entity.SysUser;
import com.doyd.utils.StringUtil;

@Repository
public class SysUserDao extends MyDaoSupport implements ISysUserDao, RowMapper<SysUser> {
	public boolean createSysUser(SysUser su){
		String sql = "insert into sys_user (suName,suPwd,suRealName,roleType,state,ctime)"
			+ " values (?,?,?,?,?,now())";
		Object[] params = new Object[]{su.getSuName(), su.getSuPwd(), su.getSuRealName(), 
				su.getRoleType(), su.getState()};
		su.setSuId(update(sql, params));
		return su.getSuId()>0;
	}
	
	public boolean updateSu(SysUser su){
		String sql = "update sys_user set suRealName=?,roleType=?,state=?"
			+ " where suId=? and suName=? and state<>2";
		Object[] params = new Object[]{ su.getSuRealName(), su.getRoleType(), su.getState(), 
				su.getSuId(), su.getSuName()};
		return update(sql, params)>0;
	}
	
	public boolean updatePassword(int suId, String suName, String password){
		String sql = "update sys_user set suPwd=? where suId=? and suName=? and state<>2";
		Object[] params = new Object[]{password, suId, suName};
		return update(sql, params)>0;
	}
	/**
	 * 修改密码
	 */
	public int updatePwd(int suId,String pwd1,String pwd2){
		String sql = "update sys_user set suPwd=? where suId=? and suPwd=? ";
		Object[] params = new Object[]{pwd2, suId, pwd1};
		return update(sql, params);
	}
	public boolean updateState(int suId, String suName, int state){
		String sql = "update sys_user set state=? where suId=? and suName=? and state<>2";
		Object[] params = new Object[]{state, suId, suName};
		return update(sql, params)>0;
	}
	public boolean updateState(int suId, int state){
		String sql = "update sys_user set state=? where suId=? ";
		Object[] params = new Object[]{state, suId};
		return update(sql, params)>0;
	}
	
	public boolean updateRealName(int suId, String suName, String suRealName){
		String sql = "update sys_user set suRealName=? where suId=? and suName=? and state<>2";
		Object[] params = new Object[]{suRealName, suId, suName};
		return update(sql, params)>0;
	}
	
	public boolean setLoginAt(int suId, String ip){
		String sql = "update sys_user set loginAt=now(), loginIp=? where suId=? and state<>2";
		Object[] params = new Object[]{ip, suId};
		return update(sql, params)>0;
	}
	
	/**
	 * 不能删除admin管理员
	 */
	public boolean deleteSu(int suId, String suName){
		String sql = "update sys_user set state=2 where suId=? and suName=? and state<>2 and suName<>'admin'";
		Object[] params = new Object[]{suId, suName};
		return update(sql, params)>0;
	}
	
	public SysUser getSysUser(int suId){
		String sql = "select * from sys_user where suId=? and state<>2";
		return queryForObject(sql, new Object[]{suId}, this);
	}
	
	public SysUser getSysUser(String suName){
		String sql = "select * from sys_user where suName=? and state<>2";
		return queryForObject(sql, new Object[]{suName}, this);
	}
	
	public List<SysUser> getSysUsers(Page page){
		StringBuilder sql = new StringBuilder("select * from sys_user where state<>2");
		if(StringUtil.isNotEmpty(page.getOrderBy())){
			sql.append(" order by ").append(page.getOrderBy()).append(" ").append(page.getOrderType());
		}
		List<SysUser> sus = query(sql.toString(), null, this);
		int total = sus!=null?sus.size():0;
		page.setPerSize(total);
		page.setTotalSize(total);
		return sus;
	}
	public List<SysUser> getSysUsers(){
		StringBuilder sql = new StringBuilder("select * from sys_user ");
		List<SysUser> sus = query(sql.toString(), null, this);
		return sus;
	}
	public SysUser mapRow(ResultSet rs, int rowNum) throws SQLException {
		SysUser su = new SysUser();
		su.setSuId(rs.getInt("suId"));
		su.setSuName(rs.getString("suName"));
		su.setSuPwd(rs.getString("suPwd"));
		su.setSuRealName(rs.getString("suRealName"));
		su.setRoleType(rs.getInt("roleType"));
		su.setState(rs.getInt("state"));
		su.setCtime(rs.getString("ctime"));
		su.setLoginAt(rs.getString("loginAt"));
		su.setLoginIp(rs.getString("loginIp"));
		return su;
	}
}
