package com.show.impl;

import java.util.Date;
import java.util.List;

import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoRestTemplateCustomizer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.show.mapper.CommentsMapper;
import com.show.mapper.SearchRecordsMapper;
import com.show.mapper.UsersLikeVideosMapper;
import com.show.mapper.UsersMapper;
import com.show.mapper.UsersReportMapper;
import com.show.mapper.VideosMapper;
import com.show.mapper.VideosVoMapper;
import com.show.pojo.Comments;
import com.show.pojo.PageResult;
import com.show.pojo.SearchRecords;
import com.show.pojo.UsersLikeVideos;
import com.show.pojo.UsersReport;
import com.show.pojo.Videos;
import com.show.pojo.VideosVo;
import com.show.service.VideoService;
import com.show.vo.CommentsVo;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * 
 * @author 2016wlw2 徐塬峰 创建时间：2018年7月6日 下午3:57:02
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS)

public class VideosServiceImpl implements VideoService {
	@Autowired
	private Sid sid;// 生成唯一主键
	@Autowired
	private VideosMapper videosMapper;
	@Autowired
	private UsersMapper usersMapper;

	@Autowired
	private VideosVoMapper videosVoMapper;
	@Autowired
	private SearchRecordsMapper searchRecordsMapper;
	@Autowired
	private UsersLikeVideosMapper usersLikeVideosMapper;
	@Autowired
	private CommentsMapper commentsMapper;
	@Autowired
	private UsersReportMapper userReportMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String saveVideo(Videos video) {

		String id = sid.nextShort();
		video.setId(id);
		videosMapper.insertSelective(video);
		return id;

	}

	/**
	 * 修改視頻的封面
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateVideo(String id, String coverPath) {
		Videos video = new Videos();
		video.setId(id);
		video.setCoverPath(coverPath);
		videosMapper.updateByPrimaryKeySelective(video);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public PageResult getAllVideos(Videos videos, Integer isSaveRecord, Integer page, Integer pageSize,
			String category) {

		// 保存热搜词
		String desc = videos.getVideoDesc();
		if (isSaveRecord != null && isSaveRecord == 1) {
			SearchRecords record = new SearchRecords();
			record.setContent(desc);
			String recordId = sid.nextShort();
			record.setId(recordId);
			searchRecordsMapper.insertSelective(record);
		}
		// 对查询进行优化
		PageHelper.startPage(page, pageSize);
		List<VideosVo> list = videosVoMapper.queryAllVideos(desc, category);
		PageInfo<VideosVo> pageList = new PageInfo<>(list);
		PageResult pageResult = new PageResult();
		pageResult.setPage(page);
		pageResult.setTotal(pageList.getPages());
		pageResult.setRows(list);
		pageResult.setRecords(pageList.getTotal());
		return pageResult;
	}
	/*
	 * @Override public PageResult getAllVideos(Integer page, Integer
	 * pageSize,String category) { //对查询进行优化 PageHelper.startPage(page, pageSize);
	 * List<VideosVo> list = videosVoMapper.queryAllVideos(null); PageInfo<VideosVo>
	 * pageList = new PageInfo<>(list); PageResult pageResult = new PageResult();
	 * pageResult.setPage(page); pageResult.setTotal(pageList.getPages());
	 * pageResult.setRows(list); pageResult.setRecords(pageList.getTotal()); return
	 * pageResult; }
	 */
//	//根据分类去查询当前视频
//	public PageResult getAllVideos(Integer page, Integer pageSize,String category) 
//	{
//		//对查询进行优化
//		PageHelper.startPage(page, pageSize);
//		List<VideosVo> list = videosVoMapper.queryAllVideos(null);
//		PageInfo<VideosVo> pageList = new PageInfo<>(list);
//		PageResult pageResult = new PageResult();
//		pageResult.setPage(page);
//		pageResult.setTotal(pageList.getPages());
//		pageResult.setRows(list);
//		pageResult.setRecords(pageList.getTotal());
//		return pageResult;
//	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void userLikeVideo(String userId, String videoId, String videoCreaterId) {

		// 1.保存用户的喜欢点赞和关联关系表
		// 2.视频喜欢的数量累加
		// 3.用户受喜欢数量的累加
		String likeId = sid.nextShort();
		UsersLikeVideos ulv = new UsersLikeVideos();
		ulv.setId(likeId);
		ulv.setUserId(userId);
		ulv.setVideoId(videoId);
		usersLikeVideosMapper.insert(ulv);
		videosVoMapper.addVideoLikeCount(videoId);
		usersMapper.addReceiveLikeCount(videoCreaterId);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void userUnLikeVideo(String userId, String videoId, String videoCreaterId) {
		/*
		 * String likeId=sid.nextShort(); UsersLikeVideos ulv=new UsersLikeVideos();
		 * ulv.setId(likeId); ulv.setUserId(userId); ulv.setUserId(videoId);
		 */

		Example example = new Example(UsersLikeVideos.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("userId", userId);
		criteria.andEqualTo("videoId", videoId);
		usersLikeVideosMapper.deleteByExample(example);
		videosVoMapper.reduceAddVideoLikeCount(videoId);
		usersMapper.reduceReceiveLikeCount(videoCreaterId);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<String> getHotWords() {
		return searchRecordsMapper.getHotWords();
	}

	/**
	 * 保存视频的评论
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED) // 事务的传播级别
	public void saveComment(String userId, String videoId, String comment) {

		Comments comments = new Comments();
		comments.setVideoId(videoId);
		comments.setCreateTime(new Date());
		comments.setFromUserId(userId);
		comments.setId(sid.nextShort());
		comments.setComment(comment);
		commentsMapper.insert(comments);// 将该评论插入数据库

	}

	@Override
	public List<CommentsVo> queryCommentsByVideoId(String videoId) {
		// 根据当前的Video的id号来查询出挡墙的视频的所有评论
		List<CommentsVo> commentsAll = commentsMapper.queryAllByVideoId(videoId);
		return commentsAll;
	}

	// 根据当前用户的id查询出当前用户所上传的所有视频
	public List<VideosVo> queryVideosByUser(String userId) {
		return videosVoMapper.queryVideosByUser(userId);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void reportVideoByUser(String dealUserId, String dealVideoId, String userId, String title, String content) {

		UsersReport userReport = new UsersReport();
		userReport.setContent(content);
		userReport.setTitle(title);
		userReport.setCreateDate(new Date());
		userReport.setDealVideoId(dealVideoId);
		userReport.setId(sid.nextShort());
		userReport.setDealUserId(dealUserId);
		userReport.setUserid(userId);
		userReportMapper.insert(userReport);

	}

}
