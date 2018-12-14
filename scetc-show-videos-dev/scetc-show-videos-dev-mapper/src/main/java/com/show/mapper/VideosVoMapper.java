package com.show.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.show.pojo.Videos;
import com.show.pojo.VideosVo;
import com.show.utils.MyMapper;

public interface VideosVoMapper extends MyMapper<Videos> {
	
	public List<VideosVo> queryAllVideos(@Param("videoDesc") String videoDesc,@Param("videoCategory") String videoCategory);
	public void addVideoLikeCount(String videoId);
	public void reduceAddVideoLikeCount(String videoId);
	public List<VideosVo> queryVideosByUser(String userId);
	

}