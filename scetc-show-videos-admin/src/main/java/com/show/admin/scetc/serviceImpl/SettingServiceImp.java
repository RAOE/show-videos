package com.show.admin.scetc.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.show.admin.scetc.mapper.SettingMapper;
import com.show.admin.scetc.pojo.Setting;
import com.show.admin.scetc.service.SettingService;

/**
 * 接口实现类
 * 
 * @author Ray
 */
@Service
public class SettingServiceImp implements SettingService {

	@Autowired
	private SettingMapper settingMapper;

	@Override
	public String getValueByName(String name) {
		Setting setting = new Setting();
		setting.setName(name);
		setting = settingMapper.selectOne(setting);
		return setting.getValue();
	}

}
