package com.doyd.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class GeneratorUtil {
	public static String FILE_ENCODER = "UTF-8";

	public static boolean htmlTemplateToHtmlGenerator(String templateFileName, String targetFileName, Map<String, String> vars) {
		if (templateFileName.startsWith("/")) {
			templateFileName = templateFileName.substring(1);
		}
		if (targetFileName.startsWith("/")) {
			targetFileName = targetFileName.substring(1);
		}
		String path = getFilePath();
		FileInputStream templateFileStream = null;
		InputStreamReader reader = null;

		String htmlContent = null;
		char[] cbuf;
		try {
			templateFileStream = new FileInputStream(path + templateFileName);
			reader = new InputStreamReader(templateFileStream, FILE_ENCODER);
			int lenght = templateFileStream.available();
			cbuf = new char[lenght];
			reader.read(cbuf);
			templateFileStream.close();
			reader.close();
			htmlContent = new String(cbuf);
		} catch (FileNotFoundException e) {
			System.out.println("没有找到文件");
			return false;
		} catch (IOException e) {
			while (true)
				System.out.println("自动生成文件" + targetFileName + "时出错");
		} catch (Exception e) {
			while (true)
				System.out.println("自动生成文件" + targetFileName + "时出错");
		} finally {
			if (templateFileStream != null)
				try {
					templateFileStream.close();
				} catch (IOException localIOException3) {
				}
			if (reader != null)
				try {
					reader.close();
				} catch (IOException localIOException4) {
				}
		}
		if (templateFileStream != null)
			try {
				templateFileStream.close();
			} catch (IOException localIOException5) {
			}
		if (reader != null) {
			try {
				reader.close();
			} catch (IOException localIOException6) {
			}
		}
		for (Map.Entry<String, String> entry : vars.entrySet()) {
			htmlContent = htmlContent.replace(entry.getKey(), entry.getValue());
		}
		return generateHtml(path + targetFileName, htmlContent);
	}

	public static boolean jspToHtmlGenerator(String sourceUrl, String targetFileName) {
		if (targetFileName.startsWith("/")) {
			targetFileName = targetFileName.substring(1);
		}
		BufferedReader br = null;
		try {
			if (!sourceUrl.startsWith("http:")) {
				if (sourceUrl.startsWith("/")) {
					sourceUrl = sourceUrl.substring(1);
				}
				String basePath = "http://localhost/";
				sourceUrl = basePath + sourceUrl;
			}
			URL url = new URL(sourceUrl);
			br = new BufferedReader(new InputStreamReader(url.openStream(), FILE_ENCODER));

			StringBuffer htmlContent = new StringBuffer();
			String str = br.readLine();
			while (str != null) {
				htmlContent.append(str).append("\r\n");
				str = br.readLine();
			}

			String path = getFilePath();

			boolean bool = generateHtml(path + targetFileName, htmlContent.toString());
			return bool;
		} catch (MalformedURLException e) {
			System.out.println("没有找到模板源地址：" + sourceUrl);
			return false;
		} catch (IOException e) {
			while (true)
				System.out.println("自动生成文件" + targetFileName + "时出错");
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException localIOException3) {
				}
		}
	}

	private static boolean generateHtml(String targetFileName, String content) {
		FileOutputStream htmlFileStream = null;
		OutputStreamWriter writer = null;
		try {
			htmlFileStream = new FileOutputStream(targetFileName);
			writer = new OutputStreamWriter(htmlFileStream, FILE_ENCODER);
			int pos = content.lastIndexOf('>') + 1;
			if (pos > 0) {
				content = content.substring(0, pos);
			}

			writer.write(content);
			writer.flush();
			File file = new File(targetFileName);
			boolean bool = file.exists();
			return bool;
		} catch (Exception e) {
			return false;
		} finally {
			if (htmlFileStream != null)
				try {
					htmlFileStream.close();
				} catch (IOException localIOException4) {
				}
			if (writer != null)
				try {
					writer.close();
				} catch (IOException localIOException5) {
				}
		}
	}

	public static String getFilePath() {
		String urlPath = GeneratorUtil.class.getResource("").getPath().replaceAll("%20", " ");
		return urlPath.substring(0, urlPath.indexOf("WEB-INF"));
	}
}
