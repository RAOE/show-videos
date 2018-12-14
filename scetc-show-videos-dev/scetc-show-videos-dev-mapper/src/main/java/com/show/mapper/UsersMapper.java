package com.show.mapper;

import com.show.pojo.Users;
import com.show.utils.MyMapper;

public interface UsersMapper extends MyMapper<Users> {
	
	/**
	 * 累加
	 * @param userId
	 */
	public void addReceiveLikeCount(String userId);
	/**
	 * 累减
	 * @param userId
	 */
	public void reduceReceiveLikeCount(String userId);
	/**
	 * 粉丝累加
	 */
	public void addFansCount(String userId);
	/**
	 * 粉丝累减
	 * @param userId
	 */
	public void reduceFansCount(String userId);
	
	
	/**
	 * 用户关注的数量增加
	 * @param userId
	 */
	public void followWithAdd(String userId);
	
	/**
	 * 用户关注的数量减少
	 * @param userId
	 */
	
	public void followWithReduce(String userId);

	
}