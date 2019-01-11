package com.show.admin.scetc.mapper;

import java.util.List;

import com.show.admin.scetc.pojo.AdminUser;
import com.show.admin.scetc.pojo.Power;
import com.show.admin.scetc.utils.MyMapper;

public interface PowerMapper extends MyMapper<Power> {

	List<Power> queryAll();


}
