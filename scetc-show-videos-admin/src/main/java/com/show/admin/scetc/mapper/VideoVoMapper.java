package com.show.admin.scetc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.show.admin.scetc.pojo.VideosVo;
import com.show.admin.scetc.utils.MyMapper;

public interface VideoVoMapper extends MyMapper<VideosVo> {
	/**
	 * 查询出全部的短视频列表
	 * 
	 * @param video_desc
	 * @return
	 */
	List<VideosVo> queryAll(@Param("keyword") String video_desc, @Param("title") String publishName);// a

	/**
	 * 查询出选中的视频列表
	 * 
	 * @param video_desc
	 * @return
	 */
	List<VideosVo> selectVideoType(@Param("keyword") String video_desc);
}
