package com.show.admin.scetc.utils;

import java.text.SimpleDateFormat;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 使用Jackson完成JSON操作 ObjectMapper是线程安全的，可以作为并推荐作为单例使用
 * 注意，把对象转换成json字符串时要保证对象中不存在循环（递归）引用，如A引用B，而B引用同一个A 转换时默认的日期格式是yyyy-MM-dd
 * HH:mm:ss，如果想使用其他格式，需要调用getNewInstance()创建一个新的ObjectMapper对象自己手动设置
 * 值为null的字段不参与生成json格式字符串
 */
public class JsonUtils {

	private static ObjectMapper objectMapper = new ObjectMapper();
	static {
		// 设置转换时日期格式
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		// 字段为null时不参与序列化
		objectMapper.setSerializationInclusion(Include.NON_NULL);
	}

	public static String toJson(Object obj) {
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	// 为了避免对list元素中的str再次进行处理从而导致转换结果不可用
	public static String toJson(Collection<String> strs) {
		if (strs == null) {
			return "[]";
		}
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		for (String str : strs) {
			builder.append(str);
			builder.append(",");
		}
		if (strs.size() > 0) {
			builder.deleteCharAt(builder.length() - 1);
		}
		builder.append("]");

		return builder.toString();
	}

	/**
	 * 可以转换普通类型，如User、Card等，也可以转换带泛型的类，比如List<T>、Map<K,V>、Xxx<T>等
	 * 
	 * @param jsonStr         json字符串
	 * @param beanClass
	 * @param parametricTypes 泛型的具体类型
	 * @return
	 */
	@SuppressWarnings("all")
	public static <T> T toBean(String jsonStr, Class<T> beanClass, Class... parametricTypes) {
		try {
			if (parametricTypes == null || parametricTypes.length == 0) {
				return objectMapper.readValue(jsonStr, beanClass);
			} else {
				JavaType javaType = objectMapper.getTypeFactory().constructParametricType(beanClass, parametricTypes);
				return objectMapper.readValue(jsonStr, javaType);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
