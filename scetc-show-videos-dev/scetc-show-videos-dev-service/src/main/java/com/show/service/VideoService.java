
package com.show.service;

import java.util.List;

import com.show.pojo.Comments;
import com.show.pojo.PageResult;
import com.show.pojo.Videos;
import com.show.pojo.VideosVo;
import com.show.vo.CommentsVo;

/**
 * 
 * @author 2016wlw2 徐塬峰 创建时间：2018年7月6日 下午3:53:21
 */
public interface VideoService {

	/**
	 * 保存
	 * 
	 * @return
	 */
	public String saveVideo(Videos video);

	/**
	 * 更新
	 * 
	 * @return
	 */
	public void updateVideo(String id,String CoverPath);

	/**
	 * 显示
	 * 分类下的视频
	 * @param video
	 * @param isSaveRecord
	 * @param page
	 * @param pageSize
	 * @param category
	 * @return
	 */
    public PageResult getAllVideos( Videos video,Integer isSaveRecord,Integer page,Integer pageSize,String category);

     /**
              * 获取热搜关键词
      * @return
      */
    public List<String> getHotWords();
    /**
     * 用户喜欢视频
     * @param userId
     * @param videoId
     * @param videoCreaterId
     */
    public void userLikeVideo(String userId,String videoId,String videoCreaterId);
    /**
     * 用户不喜欢视频
     * @param userId
     * @param videoId
     * @param videoCreaterId
     */
    public void userUnLikeVideo(String userId,String videoId,String videoCreaterId);

    /**
     * 用来保存视频的评论
     * @param userId
     * @param videoId
     * @param comment
     */
	public void saveComment(String userId,String videoId,String comment);

	public  List<CommentsVo> queryCommentsByVideoId(String videoId);
	/**
	 * 用于查询用户发布的视频
	 * @return
	 */
	public List<VideosVo> queryVideosByUser(String userId);
     /**
             *   用于举报用户视频
     * @param dealUserId
     * @param dealVideoId
     * @param userId
     * @param title
     * @param content
     */
    public void reportVideoByUser(String dealUserId,String dealVideoId,String userId,String title,String content);


  
    
    
    
}
