package com.show.admin.scetc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.show.admin.scetc.pojo.VideosVo;
import com.show.admin.scetc.utils.MyMapper;
public interface VideoVoMapper extends MyMapper<VideosVo> {
	List<VideosVo> queryAll(@Param("keyword") String video_desc);//a

	List<VideosVo> selectVideoType(@Param("keyword") String video_desc);

}
