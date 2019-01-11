package com.show.admin.scetc.serviceImpl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.show.admin.scetc.mapper.BgmMapper;
import com.show.admin.scetc.mapper.PowerMapper;
import com.show.admin.scetc.mapper.RolesMapper;
import com.show.admin.scetc.pojo.Bgm;
import com.show.admin.scetc.pojo.PageResult;
import com.show.admin.scetc.pojo.Power;
import com.show.admin.scetc.pojo.Roles;
import com.show.admin.scetc.service.BgmService;
import com.show.admin.scetc.service.PowerService;
import com.show.admin.scetc.service.RolesService;

/**
 * 接口实现类
 * 
 * @author Ray
 *
 */
@Service
public class PowerServiceImp implements PowerService {

	@Autowired
	private PowerMapper powerMapper;

	@Override
	public List<Power> queryAll() {
		return powerMapper.selectAll();
	}



}
