package com.doyd.utils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

public class HttpClientUtil {
	private static Logger logger = Logger.getLogger(HttpClientUtil.class);
	private final HttpClient client;
	public HttpClientUtil(){
		client = getHttpClient();
	}
	public HttpClientUtil(HttpClient client){
		this.client = client;
	}
	public HttpClientUtil(String ip, int port){
		client = getHttpClient();
		HttpHost host = new HttpHost(ip, port);
		client.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, host);
	}
	
	public void setProxy(String ip, int port){
		if(isEmpty(ip)){
			client.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, null);
		}else{
			HttpHost host = new HttpHost(ip, port);
			client.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, host);
		}
	}
	
	public String get(String url, Map<String, Object> params, Map<String,Object> headers){
		url = getQueryString(url, params);
		HttpGet get = new HttpGet(url);
		try {
			if(headers!=null && headers.size()>0){
				for(Map.Entry<String, Object> header: headers.entrySet()){
					get.setHeader(header.getKey(), header.getValue()==null?"":header.getValue().toString());
				}
			}
			HttpResponse response = client.execute(get);
			int status = response.getStatusLine().getStatusCode();
			String content = EntityUtils.toString(response.getEntity());
			if (status == 200) {
				return content;
			}
		} catch (Exception e) {
			logger.error(e);
		} finally {
			get.abort(); 
		}
		return null;
	}
	
	public String post(String url, Map<String, Object> params, Map<String,Object> headers){
		HttpPost post = new HttpPost(url);
		try {
			//设置body
			post.setEntity(getPostBody(params));
			//设置header
			if(headers!=null && headers.size()>0){
				for(Map.Entry<String, Object> header: headers.entrySet()){
					post.setHeader(header.getKey(), header.getValue()==null?"":header.getValue().toString());
				}
			}
			//访问
			HttpResponse response = client.execute(post);
			int status = response.getStatusLine().getStatusCode();
			String content = EntityUtils.toString(response.getEntity());
			if (status == 200) {
				return content;
			}
		} catch (Exception e) {
			logger.error(e);
		} finally {
			post.abort();
		}
		return null;
	}
	
	public String upload(String url, Map<String, Object> params, Map<String,Object> headers){
		HttpPost post = new HttpPost(url);
		try {
			//设置body
			post.setEntity(getEntityBody(params));
			
			//设置header
			if(headers!=null && headers.size()>0){
				for(Map.Entry<String, Object> header: headers.entrySet()){
					post.setHeader(header.getKey(), header.getValue()==null?"":header.getValue().toString());
				}
			}
			//访问
			HttpResponse response = client.execute(post);
			int status = response.getStatusLine().getStatusCode();
			String content = EntityUtils.toString(response.getEntity());
			if (status == 200) {
				return content;
			}
		} catch (Exception e) {
			logger.error(e);
		} finally {
			post.abort();
		}
		return null;
	}
	
	//---------- tools---------
	public static String getQueryString(String url, Map<String, Object> params) {
		if (params == null || params.isEmpty()) {
			return url;
		}
		if(url==null){
			return null;
		}
		StringBuffer str = new StringBuffer();
		for (Map.Entry<String, Object> param : params.entrySet()) {
				str.append("&").append(param.getKey()).append("=")
					.append(encode(param.getValue()==null?null:param.getValue().toString()));
		}
		if(url.lastIndexOf("?")<0){
			str.setCharAt(0, '?');
		}
		return url + str.toString();
	}
	
	public HttpEntity getPostBody(Map<String, Object> params) {
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
		for (Map.Entry<String, Object> param : params.entrySet()) {
			formparams.add(new BasicNameValuePair(param.getKey(), param.getValue()==null?null:param.getValue().toString()));
		}
		UrlEncodedFormEntity entity = null;
		try {
			entity = new UrlEncodedFormEntity(formparams, "UTF-8");
		} catch (UnsupportedEncodingException e) {
		}
		return entity;
	}
	
	private static Charset charset = Charset.forName("UTF-8");
	public static HttpEntity getEntityBody(Map<String, Object> params) {
		if(params==null || params.size()<=0){
			return null;
		}
		MultipartEntity entity = new MultipartEntity(); 
		if(params!=null && params.size()>0){
			for(Map.Entry<String, Object> param: params.entrySet()){
				try {
					if(param.getValue()==null){
						StringBody sb = new StringBody(null, "form-data", charset);
						entity.addPart(param.getKey(), sb);
					}else{
						if(param.getValue() instanceof File){
							FileBody fileBody = new FileBody((File) param.getValue());
							entity.addPart(param.getKey(), fileBody);
						}else{
							StringBody sb = new StringBody(encode(param.getValue().toString()), "form-data", charset);
							entity.addPart(param.getKey(), sb);
						}
					}
				} catch (Exception e) {
				}
			}
		}
		return entity;
	}
	
	public static String formEncode(String str){
		if(str==null){
			return "";
		}
		return str.replace("+", "%20").replace("*", "%2A").replace("%7E", "~").replace("#", "%23");
	}
	
	public static String encode(String str){
		return encode(str, "UTF-8");
	}
	
	public static String encode(String str, String encode){
		if(isEmpty(str)){
			return "";
		}
		try {
			str = URLEncoder.encode(str, encode);
			str = formEncode(str);
		} catch (UnsupportedEncodingException e) {
		}
		return str;
	}
	
	public static boolean isEmpty(String str) {
		return str == null || "".equals(str.trim());
	}
	
	public static DefaultHttpClient getHttpClient() {
		HttpParams params = new BasicHttpParams();
		params.setIntParameter("http.conn-manager.max-total", 20);//同时允许100个访问
//		params.setIntParameter(HttpConnectionParams.SO_TIMEOUT, 10000);//套接字超时10秒
		params.setIntParameter(HttpConnectionParams.CONNECTION_TIMEOUT, 10000);//链接超时10秒
		ClientConnectionManager ccm = new ThreadSafeClientConnManager();
		return new DefaultHttpClient(ccm, params);
	}
	
	/**
	 * 打印Cookie信息
	 * @param client
	 * @author 郑德湖
	 * @date Oct 22, 2011 2:54:13 PM
	 */
	public static void printCookie(DefaultHttpClient client){
		for(Cookie cookie : client.getCookieStore().getCookies()){
			StringBuffer sb = new StringBuffer();
			sb.append("cookie:")
				.append(cookie.getName()).append("=").append(cookie.getValue()).append(", ")
				.append("domain=").append(cookie.getDomain()).append(", ")
				.append("path=").append(cookie.getPath()).append(", ")
				.append("version=").append(cookie.getVersion()).append(", ")
				.append("expiryDate=").append(cookie.getExpiryDate());
			System.out.println(sb.toString());
		}
	}
	
	/**
	 * 打印Cookie信息
	 * @param client
	 * @author 郑德湖
	 * @date Oct 22, 2011 2:54:13 PM
	 */
	public static void printHeaders(HttpResponse response){
		for(Header header:response.getAllHeaders()){
			StringBuffer sb = new StringBuffer();
			sb.append("header:").append(header.getName()).append("=").append(header.getValue());
			System.out.println(sb.toString());
		}
	}
	
	public String getShortUrl(String url){
		String shortUrl  = url;
		if(StringUtil.isNotEmpty(url)){
			try {
				String longUrl = "http://api.t.sina.com.cn/short_url/shorten.json?source=1681459862&url_long="+URLEncoder.encode(url,"utf-8")+"&callback=jsonpshorturlcount123";
				String json = new HttpClientUtil().get(longUrl, null, null);
				if(StringUtil.isNotEmpty(json)){
					String key  = "\"url_short\":\"";
					int index  = json.indexOf(key)+key.length();
					int endIndex = json.indexOf("\",\"url_long\"");
					if(index > 0 && endIndex > index){
						shortUrl = json.substring(index, endIndex);
					}
				}
			} catch (UnsupportedEncodingException e) {
			}
		}
		
		return shortUrl;
	}
	
	public static void main(String[] args) {
		System.out.println(new HttpClientUtil().getShortUrl("http://t.vdaiyan.com/rdt/2013122701.html?dl.app.qq.com&r="+Math.random()));
		System.out.println(new HttpClientUtil().getShortUrl("http://t.wbgj.cn/rdt/2013122701.html?dl.app.qq.com&r="+Math.random()));
		System.out.println(new HttpClientUtil().getShortUrl("http://t.xianjiaosuo.com/rdt/2013122701.html?dl.app.qq.com&r="+Math.random()));
		System.out.println(new HttpClientUtil().getShortUrl("http://t.kdwaimai.com/rdt/2013122701.html?dl.app.qq.com&r="+Math.random()));
		
	}
}
