package com.show.admin.scetc.service;

import java.util.List;


import com.show.admin.scetc.pojo.PageResult;
import com.show.admin.scetc.pojo.Video;

public interface VideoService {

	List<Video> queryAll();

	PageResult queryAll(Integer page, Integer pageSize,String keyword,String status);

	PageResult selectVideoType(Integer page, Integer pageSize,String keyword);

	void update(String id, String status);


	
	
}
