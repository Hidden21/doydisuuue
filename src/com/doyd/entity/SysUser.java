package com.doyd.entity;

import java.io.Serializable;

public class SysUser implements Serializable {

	private static final long serialVersionUID = 5413411404985386411L;
		private int suId;
		private String suName;
		private String suPwd;
		private String suRealName;
		private int roleType;
		private int state;
		private String loginAt;
		private String loginIp;
		private String ctime;
		
		
		public int getSuId() {
			return suId;
		}
		public void setSuId(int suId) {
			this.suId = suId;
		}
		public String getSuName() {
			return suName;
		}
		public void setSuName(String suName) {
			this.suName = suName;
		}
		public String getSuPwd() {
			return suPwd;
		}
		public void setSuPwd(String suPwd) {
			this.suPwd = suPwd;
		}
		public String getSuRealName() {
			return suRealName;
		}
		public void setSuRealName(String suRealName) {
			this.suRealName = suRealName;
		}
		public int getRoleType() {
			return roleType;
		}
		public void setRoleType(int roleType) {
			this.roleType = roleType;
		}
		public int getState() {
			return state;
		}
		public void setState(int state) {
			this.state = state;
		}
		public String getLoginAt() {
			return loginAt;
		}
		public void setLoginAt(String loginAt) {
			this.loginAt = loginAt;
		}
		public String getLoginIp() {
			return loginIp;
		}
		public void setLoginIp(String loginIp) {
			this.loginIp = loginIp;
		}
		public String getCtime() {
			return ctime;
		}
		public void setCtime(String ctime) {
			this.ctime = ctime;
		}
		
		
		
		
}
