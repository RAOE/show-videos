package com.show.admin.scetc.serviceImpl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.show.admin.scetc.mapper.VideoMapper;
import com.show.admin.scetc.mapper.VideoVoMapper;
import com.show.admin.scetc.pojo.PageResult;
import com.show.admin.scetc.pojo.Video;
import com.show.admin.scetc.pojo.VideosVo;
import com.show.admin.scetc.service.VideoService;

/**
 * 接口实现类
 * 
 * @author Ray
 *
 */
@Service
public class VideoServiceImp implements VideoService {
	@Autowired
	private VideoMapper videoMapper;
	@Autowired
	private VideoVoMapper videoVoMapper;

	private String filePath = "D:\\show_videos_dev";

	@Override
	public List<Video> queryAll() {
		List<Video> list = videoMapper.selectAll();
		return list;
	}

	@Override
	public PageResult queryAll(Integer page, Integer pageSize, String keyword, String title) {

		PageHelper.startPage(page, pageSize);
		List<VideosVo> list = videoVoMapper.queryAll(keyword, title);
		PageInfo<VideosVo> pageList = new PageInfo<>(list);
		PageResult pageResult = new PageResult();
		pageResult.setPage(page);
		pageResult.setTotal(pageList.getPages());
		pageResult.setRows(list);
		pageResult.setRecords(pageList.getTotal());
		return pageResult;
	}

	@Override
	public PageResult selectVideoType(Integer page, Integer pageSize, String keyword) {
		PageHelper.startPage(page, pageSize);
		List<VideosVo> list = videoVoMapper.selectVideoType(keyword);
		PageInfo<VideosVo> pageList = new PageInfo<>(list);
		PageResult pageResult = new PageResult();
		pageResult.setPage(page);
		pageResult.setTotal(pageList.getPages());
		pageResult.setRows(list);
		pageResult.setRecords(pageList.getTotal());
		return pageResult;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(String id) {

		Video video = new Video();
		video.setId(id);
		video = videoMapper.selectByPrimaryKey(video);
		String path = video.getVideoPath();
		path = filePath + "//" + path;
		File file = new File(path);
		if (file.exists()) {
			file.delete();
		}
		videoMapper.deleteByPrimaryKey(video);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(String id) {

	}

	@Override
	public int selectCountAll() {

		return videoMapper.selectCount(null);
	}

}
