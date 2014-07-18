package com.doyd.entity;

import javax.servlet.http.HttpServletRequest;

import com.doyd.utils.StringUtil;


public class Page {
	
	private final int defaultSize = 10; //默认的每页记录条数
	private int page = 1; //当前页面
	private int perSize = defaultSize; //每页记录条数
	private int totalPage = 1; //总的页码
	private int totalSize = 0; //总的记录条数
	private String orderBy = null;//排序的字段
	private String orderType = "asc";//是否按升序排序
	public Page(){
	}
	
	public Page(HttpServletRequest request){
		String page = request.getParameter("page");
		if(StringUtil.isNotEmpty(page)){
			try{
				setPage(Integer.parseInt(page));
			}catch (Exception e) {
				// 当前页码不是正确的数字
				setPage(1);
			}
		}
		
		String perSize = request.getParameter("perSize");
		if(StringUtil.isNotEmpty(perSize)){
			try{
				setPerSize(Integer.parseInt(perSize));
			}catch (Exception e) {
				// 记录条数不是正确的数字
				setPage(defaultSize);
			}
		}
		setOrderBy(request.getParameter("orderBy"));
		setOrderType(request.getParameter("orderType"));
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page<1?1:page;
	}
	public int getPerSize() {
		return perSize;
	}
	public void setPerSize(int perSize) {
		this.perSize = perSize<1?defaultSize:perSize;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize<0?0:totalSize;
		totalPage = this.totalSize/perSize + (this.totalSize%perSize==0?0:1);
		page = totalPage<page?totalPage:page;
		page = page<1?1:page;
	}
	
	/**
	 * 下标从0开始
	 * @return
	 */
	public int getCursor(){
		return (page-1)*perSize;
	}
	
	/**
	 * 下标从1开始
	 * @return
	 */
	public int getCursorFrom1(){
		return (page-1)*perSize+1;
	}
	
	public int getTotalPage() {
		return totalPage;
	}
	
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		if(orderBy!=null && orderBy.matches("[a-zA-Z_][a-zA-Z_0-9]*"))
		this.orderBy = orderBy;
	}
	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = "desc".equalsIgnoreCase(orderType)?"desc":"asc";
	}
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("{\"page\":").append(page)
			.append(",\"perSize\":").append(perSize)
			.append(",\"totalPage\":").append(totalPage)
			.append(",\"totalSize\":").append(totalSize)
			.append(",\"orderBy\":").append(orderBy!=null?("\""+orderBy+"\""):null)
			.append(",\"orderType\":\"").append(orderType).append("\"")
			.append("}");
		return sb.toString();
	}
}