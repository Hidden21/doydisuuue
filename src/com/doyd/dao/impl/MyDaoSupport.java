package com.doyd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Statement;
@Repository
public class MyDaoSupport {
	@Autowired
	protected NamedParameterJdbcTemplate namedParameterJdbc;
	private static final Logger logger = Logger.getLogger(MyDaoSupport.class);
	
	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.namedParameterJdbc = jdbcTemplate;
	}
	
	public void setDataSource(DataSource dataSource) {
	    this.namedParameterJdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public JdbcOperations getJdbc(){
		return this.namedParameterJdbc.getJdbcOperations();
	}
	public <T> T queryForObject(String sql, Object[] params, RowMapper<T> rowMapper){
		try{
			List<T> list = namedParameterJdbc.getJdbcOperations().query(sql, params, rowMapper);
			if(list==null || list.size()<1){
				return null;
			}else{
				return list.get(0);
			}
		}catch (Exception e) {
			logger.error(e);
			return null;
		}
	}
	
	public int update(final String sql, final Object... params){
		try{
			return namedParameterJdbc.getJdbcOperations().update(sql, params);
		}catch (Exception e) {
			logger.error(e);
			return 0;
		}
	}
	
	
	public int insert(final String sql, final Object... params){
		KeyHolder keyHolder = new GeneratedKeyHolder();
		this.namedParameterJdbc.getJdbcOperations().update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				if (params != null && params.length > 0) {
					for (int i = 0; i < params.length; i++) {
						pstmt.setObject(i + 1, params[i]);
					}
				}
				return pstmt;
			}
		}, keyHolder);
		return keyHolder.getKey().intValue();
	}
	
	public String queryForString(String sql, Object[] params){
		try{
			SqlRowSet rs = namedParameterJdbc.getJdbcOperations().queryForRowSet(sql, params);
			if(rs.first()){
				String str = rs.getString(1);
				return str;
			}
			return null;
		}catch (Exception e) {
			logger.error(e);
			return null;
		}
	}
	
	public int queryForInt(String sql, Object[] params){
		try{
			int rs = namedParameterJdbc.getJdbcOperations().queryForInt(sql, params);
			return rs;
		}catch (Exception e) {
			logger.error(e);
			return 0;
		}
	}
	
	public boolean queryForExist(String sql, Object[] params){
		try{
			int rs = namedParameterJdbc.getJdbcOperations().queryForInt(sql, params);
			return rs>0;
		}catch (Exception e) {
			logger.error(e);
			return false;
		}
	}
	public <T> List<T> query(String sql, Object[] params, RowMapper<T> rowMapper){
		try{
			return namedParameterJdbc.getJdbcOperations().query(sql, params, rowMapper);
		}catch (Exception e) {
			logger.error(e);
			return null;
		}
	}
	
	public List<Map<String, Object>> queryForList(String sql, Object... params){
		try{
			List<Map<String, Object>> list = namedParameterJdbc.getJdbcOperations().queryForList(sql, params);
			return list;
		}catch (Exception e) {
			logger.error(e);
			return null;
		}
	}
	
	public Map<String, Object> queryForMap(String sql, Object... params){
		try{
			List<Map<String, Object>> list  = namedParameterJdbc.getJdbcOperations().queryForList(sql,params);
			if(list != null && list.size() > 0){
				return list.get(0);
			}
			//Map<String, Object> map = namedParameterJdbc.getJdbcOperations().queryForMap(sql, params);
			return null;
		}catch (Exception e) {
			logger.error(e);
			return null;
		}
	}
	
}
