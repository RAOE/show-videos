package com.show.service;

import com.show.pojo.Users;
public interface UserService 
{
	//判断用户是否存在
	public boolean queryUsernameIsExist(String username);
	//保存用户名
	public void saveUser(Users user);
	//查询一个用户
	public Users getUser(String user);
	//修改用户信息
	public void updateUserInfo(Users user);
	//查询用户的信息
	public Users queryUserInfo(String userid);
	//查询用户是否喜欢点赞视频
	public Boolean isUserLikeVideo(String userId,String videoId);
	//用户跟随
	public void userFollow(String userId, String fanId);
    //用户取消追随
	public void userUnFollow(String userId, String fanId);
    //查詢视频的发布者是否被我追随
	public boolean queryIsFollowed(String userId, String fanId);

}
