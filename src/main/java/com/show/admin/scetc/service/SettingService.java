package com.show.admin.scetc.service;

import com.show.admin.scetc.pojo.Setting;

/**
 * 配置文件 以键值对的方式来存储数据 主要保存邮箱账号等数据
 * 
 * @author Ray
 */
public interface SettingService {

	/**
	 * 根据配置文件中的名称获取键
	 * 
	 * @return
	 */
	public String getValueByName(String name);

}
