package com.show.admin.scetc.utils;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

public class HttpUtils {

	private static final Logger logger = org.apache.log4j.Logger.getLogger(HttpUtils.class);

	public static String get(String url) throws Exception {
		return get(url, null);
	}

	/**
	 * 发送get请求并返回字符串形式的响应内容，注意，如果响应内容非常多可能不适合使用此方法
	 * 
	 * @param url
	 * @param params 请求参数
	 * @return
	 * @throws Exception
	 */
	public static String get(String url, Map<String, String> params) throws Exception {

		CloseableHttpClient httpClient = null;
		CloseableHttpResponse httpResponse = null;
		try {
			httpClient = HttpClients.createDefault();
			URIBuilder uriBuilder = new URIBuilder(url);// 设置请求路径
			if (params != null) {
				// 添加请求参数
				Set<Entry<String, String>> entrySet = params.entrySet();
				for (Entry<String, String> entry : entrySet) {
					uriBuilder.addParameter(entry.getKey(), entry.getValue());
				}
			}

			HttpGet httpGet = new HttpGet(uriBuilder.build());
			// 发送请求并接收响应
			httpResponse = httpClient.execute(httpGet);

			// 以字符串形式返回响应内容
			String result = EntityUtils.toString(httpResponse.getEntity());
			logger.debug("发送http get请求，url：{}，请求参数：{}，响应结果：{}");
			return result;

		} finally {
			closeQuietly(httpResponse);
			closeQuietly(httpClient);
		}
	}

	public static String post(String url) throws IOException {
		return post(url, null);
	}

	public static String post(String url, Map<String, String> params) throws IOException {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse httpResponse = null;

		List<NameValuePair> paramList = new ArrayList<NameValuePair>();
		if (params != null) {
			Set<Entry<String, String>> entrySet = params.entrySet();
			for (Entry<String, String> entry : entrySet) {
				paramList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}
		}

		try {
			httpClient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(url);
			httpPost.setEntity(new UrlEncodedFormEntity(paramList));
			httpResponse = httpClient.execute(httpPost);

			String result = EntityUtils.toString(httpResponse.getEntity());
			logger.debug("发送http post请求，url：{}，请求参数：{}，响应结果：{}");
			return result;
		} finally {
			closeQuietly(httpResponse);
			closeQuietly(httpClient);
		}
	}

	private static void closeQuietly(Closeable closeable) {
		if (closeable != null) {
			try {
				closeable.close();
			} catch (Exception e) {
				logger.warn("关闭closeable时出错误", e);
			}
		}
	}
}
