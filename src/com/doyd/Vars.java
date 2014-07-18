package com.doyd;

import com.doyd.utils.StringUtil;

public class Vars {
	
	public static final String CKVF = "CAR_LOTTERY";
	
	public static final String imgFilePath = "file/images/";
	/**
	 * 当前登录用户
	 */
	public static final String CURRENT_USER = "cu";
	
	/**
	 * 当前登录用户的ID
	 */
	public static final String CURRENT_USER_ID = "cuid";
	
	/**
	 * 页面的basePath标签
	 */
	public static final String BASE_PATH = "basePath";
	
	/**
	 * 上方导航栏
	 */
	public static final String NAV_BAR = "navBar";
	
	/**
	 * 上方导航栏中的当前导航名称
	 */
	public static final String NAV_NAME_CURRENT = "navName";
	
	/**
	 * 左侧菜单栏
	 */
	public static final String MENU_BAR = "menuBar";
	
	/**
	 * 左侧菜单栏的当前菜单ID
	 */
	public static final String MENU_ID_CURRENT = "menuId";
	/**
	 * 左侧菜单栏的当前菜单名称
	 */
	public static final String MENU_NAME_CURRENT = "menuName";
	
	public static final String ANCESTOR_RIGHTS = "aRights";
	
	/**
	 * spring mvc拦截的后缀
	 */
	public static final String SUFFIX = ".html";
	/**
	 * 无需登录就可访问的路径
	 */
	public static final String ANONYMOUS_ACCESS_PATH = "^(index|login|logout|ssologin|authorize|(reflush(/.+)*))"+SUFFIX.replace(".", "\\.")+"$";
	
	/**
	 */
	public static final String  ALLOW_URL= "^(szWelfare|loadWelfares|findsz|loadData|findActs|share)"+SUFFIX.replace(".", "\\.")+"$";
	
	/**
	 * 登陆超时、没有登录的标记
	 */
	public static final String NO_LOGIN_TAG = "session timeout";
	/************************ 正则表达式> ****************************************
	 * 正则表达式规则 rules
	 ***********************/
	
	
	/**数字、字母、下划线*/
	public static final String RULES_UID = "[\\w]+";
	
	/**中文、数字、字母、下划线*/
	public static final String RULES_UNAME = "[\\u4E00-\\u9FA5\\w]+";
	
	/**用户登录名只能输入数字、字母、下划线、@、点号*/
	public static final String RULES_LOGIN_NAME = "[\\w\\.\\-]+(@\\w+(\\.\\w+)*)?";
	
	/**数字*/
	public static final String RULES_NUMBER = "\\-?\\d+(\\.\\d+)?";
	
	/**整数*/
	public static final String RULES_INT = "\\-?\\d+";
	
	/**正整数*/
	public static final String RULES_DIGITS = "\\d+";
	
	/**货币数字*/
	public static final String RULES_MONEY = "\\d+(\\.\\d{1,2})?";
	
	/**邮箱*/
	public static final String RULES_EMAIL = "[\\w\\.\\-]+@\\w+(\\.\\w+)*";
	
	/**url地址*/
	public static final String RULES_URL = "(http(s?)|ftp)://([\\w\\-]+\\.)+[\\w]+(:\\d+)?" // 解析域名
										+ "(/([\\w\\-\\._,#%=\\*\\{\\}\\[\\]])*)*" // 解析uri
										+ "[\\?&#]?([\\w\\.\\+\\-!=#,_%&\\*\\{\\}\\[\\]]*)*";// 解析参数
	
	/**uri地址*/
	public static final String RULES_URI = "("+RULES_URL+")|"
										+ "(([\\w\\-\\._,#%=/\\*\\{\\}\\[\\]])+" // 解析uri
										+ "[\\?&#]?([\\w\\.\\+\\-!=#,_%&\\*\\{\\}\\[\\]]*)*)";// 解析参数
	
	/**时间*/
	public static final String RULES_TIME = "([01][0-9]|2[0-3]):([0-5][0-9])(:([0-5][0-9]))?";
	
	/**日期*/
	public static final String RULES_DATA = "\\d{4}\\-(0[1-9]|1[0-2])\\-(0[1-9]|[12][0-9]|3[0-1])( " +RULES_TIME + ")?";
	
	/**完整的日期格式*/
	public static final String RULES_DATA_FULL = "\\d{4}\\-(0[1-9]|1[0-2])\\-(0[1-9]|[12][0-9]|3[0-1]) ([01][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])";
	
	/**手机号码*/
	public static final String RULES_MOBILE = "(\\+86)?1\\d{10}";
	
	/**IP*/
	public static final String RULES_IP = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";
	
	/** 刷新短链服务器的短链映射信息，停止活动时使用*/
	public static final String URL_REFLUSH_URLMAPPING = "reflush.urlmapping.url";
	/************************ <正则表达式 ****************************************/
	
	/************************ 其他系统参数 ****************************************/
	public static void main(String[] args) {
		String str = "\r\n\r\n当飞机哦娃儿\r\n；口螺丝刀将覅哦\r\n\n\r";
		
		System.out.println(StringUtil.trimWhitespace(str));
		System.out.println("------");
	}
}
