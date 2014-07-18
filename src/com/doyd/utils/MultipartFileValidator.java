package com.doyd.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


import org.springframework.web.multipart.MultipartFile;

import com.doyd.Vars;

public class MultipartFileValidator {
	private final static long MAX_SIZE = 3024 * 3024;

	/**
	 * 文件大小上限
	 */
	private long maxSize = MAX_SIZE;
	private String type = "all";
	/**
	 * 可接受的文件content-type
	 */
	private String allowedContentTypes = setAllowedContentTypes("*/*");
	
	public MultipartFileValidator() {
		this("all");
	}

	public MultipartFileValidator(String type) {
		this.type = type;
		if ("image".equals(type)) {
			maxSize = MAX_SIZE * 2;
			allowedContentTypes = setAllowedContentTypes("image/*");
		} else if ("all".equals(type)) {
			maxSize = MAX_SIZE;
			allowedContentTypes = setAllowedContentTypes("*/*");
		} else {
			maxSize = MAX_SIZE;
			allowedContentTypes = setAllowedContentTypes("");
		}
	}
	
	private String setAllowedContentTypes(String allowedContentTypes){
		return allowedContentTypes==null?"":allowedContentTypes.replace("*", ".*");
	}

	/**
	 * 验证上传文件是否合法，如果不合法那么会抛出异常
	 * 
	 * @param file 用户上传的文件封装类
	 * @return 返回null时，表示检验通过，否则表示校验不通过原因
	 */
	public String validate(MultipartFile file){
		if (file.getSize() > maxSize)
			return "文件太大!";

		if (!file.getContentType().matches(allowedContentTypes)) {
			return "只能上传 " + getTypeName();
		}
		return null;
	}

	/**
	 * 设置文件上传大小上限
	 * 
	 * @param maxSize 文件上传大小上限
	 */
	public void setMaxSize(long maxSize) {
		this.maxSize = maxSize;
	}

	public long getMaxSize() {
		return this.maxSize;
	}

	public String getTypeName() {
		if ("all".equals(type)) {
			return "所有格式文件";
		} else if ("image".equals(type)) {
			return "图片";
		} else {
			return type + "类型的文件";
		}
	}

	public String saveImage(MultipartFile file, String fileName){
		return saveFile(file, Vars.imgFilePath, fileName);
	}

	public String saveFile(MultipartFile file, String fileName){
		return saveFile(file, "file/", fileName);
	}

	/**
	 * 
	 * @param file
	 * @param path 相对路径以/开头，以/结尾
	 * @param fileName 文件名称，为null时，自动随机生成一个文件名
	 * @return
	 * @throws CpcException
	 */
	public String saveFile(MultipartFile file, String path, String fileName) {
		// 没有接收到文件
		if (file == null || file.isEmpty()) {
			return null;
		}
		FileOutputStream fileOutput = null;
		try {
			byte[] bytes = file.getBytes();
			int pos = file.getOriginalFilename().lastIndexOf(".");
			fileName = path + (fileName==null?getName():fileName) + (pos >= 0 ? file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")) : "");
			fileOutput = new FileOutputStream(new File(getBaseFilePath() + fileName));
			fileOutput.write(bytes);
			return fileName;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (fileOutput != null) {
				try {
					fileOutput.flush();
					fileOutput.close();
				} catch (IOException e) {
				}
				fileOutput = null;
			}
		}
	}
	
	public String getName() {
		return EncryptUtil.MD5(System.currentTimeMillis() + StringUtil.getRandomString(4, "0123456789"));
	}

	public String getBaseFilePath() {
		StringBuffer sb = new StringBuffer(this.getClass().getClassLoader().getResource("").getPath().replace("%20", " "));
		sb.delete(sb.indexOf("WEB-INF"), sb.length());
		return sb.toString();
	}
}
