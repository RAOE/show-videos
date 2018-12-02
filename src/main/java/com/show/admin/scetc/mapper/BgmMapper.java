package com.show.admin.scetc.mapper;

import java.util.List;

import com.show.admin.scetc.pojo.Bgm;
import com.show.admin.scetc.utils.MyMapper;
public interface BgmMapper extends MyMapper<Bgm> {

	List<Bgm> queryAll(String keyword);

	List<Bgm> selectBgmByName(String name);
	

}
