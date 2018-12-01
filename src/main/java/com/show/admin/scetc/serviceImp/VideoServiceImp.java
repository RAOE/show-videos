package com.show.admin.scetc.serviceImp;

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
	private VideoVoMapper  videoVoMapper;
	
	private String filePath="D:\\show_videos_dev";

	@Override
	public List<Video> queryAll() {
		List<Video> list = videoMapper.selectAll();
		return list;
	}
	@Override
	public PageResult queryAll(Integer page, Integer pageSize,String keyword,String status) {
		
		PageHelper.startPage(page, pageSize);
        List<VideosVo> list=videoVoMapper.queryAll(keyword);
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
		return pageResult;	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED) // 创建一个事务
	public void update(String id, String status) {
		
		if(status.equals("2")) //删除
		{
			Video video=new Video();
			video.setId(id);
			video.setStatus(Integer.parseInt(status));
            video =videoMapper.selectByPrimaryKey(video);	
            String path=video.getVideoPath();
            path=filePath+"//"+path;
            File file =new File(path);
            if(file.exists())
            {
            	file.delete();
            }
            videoMapper.deleteByPrimaryKey(video);
		}
		
	}

}
