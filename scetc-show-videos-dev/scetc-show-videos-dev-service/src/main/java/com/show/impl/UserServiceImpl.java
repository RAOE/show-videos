package com.show.impl;

import java.util.List;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.show.mapper.UserFansMapper;
import com.show.mapper.UsersLikeVideosMapper;
import com.show.mapper.UsersMapper;
import com.show.pojo.Users;
import com.show.pojo.UsersFans;
import com.show.pojo.UsersLikeVideos;
import com.show.service.UserService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UsersMapper userMapper;
	@Autowired
	private UsersLikeVideosMapper usersLikeVideosMapper;
	@Autowired
	private Sid sid;
	@Autowired
	private UserFansMapper userFansMapper;
	
	
	@Transactional(propagation = Propagation.SUPPORTS)
	/**
	 * 判断用户是否存在 Boolean
	 */
	@Override
	public boolean queryUsernameIsExist(String username) {
		Users user = new Users();
		user.setUsername(username);
		Users result = userMapper.selectOne(user);
		return result == null ? false : true;
	}

	/**
	 * 保存账号 插入数据库
	 */
	@Transactional(propagation = Propagation.REQUIRED) // 创建一个事务
	@Override
	public void saveUser(Users user) {
		String userId = sid.nextShort();
		user.setId(userId);
		userMapper.insert(user);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public Users getUser(String username) {
		Users user = new Users();
		user.setUsername(username);
		Users result = userMapper.selectOne(user);
		return result == null ? null : result;
	}

	@Override
	public void updateUserInfo(Users user) {

		Example userExample = new Example(Users.class);
		Criteria criteria = userExample.createCriteria();
		criteria.andEqualTo("id", user.getId());
		userMapper.updateByExampleSelective(user, userExample);// 字段中不为null也更新

	}

	@Override
	public Users queryUserInfo(String userId) {
		Example userExample = new Example(Users.class);
		Criteria criteria = userExample.createCriteria();
		criteria.andEqualTo("id", userId);
		Users user = userMapper.selectOneByExample(userExample);
		return user;
	}

	@Override
	public Boolean isUserLikeVideo(String userId, String videoId) {

		Example userExample = new Example(UsersLikeVideos.class);// 创建一个模板 条件
		Criteria criteria = userExample.createCriteria();
		criteria.andEqualTo("userId", userId);
		criteria.andEqualTo("videoId", videoId);
		List<UsersLikeVideos> ls = usersLikeVideosMapper.selectByExample(userExample);// 查询excample
		if (ls != null && ls.size() > 0) {
			return true;
		}

		return false;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED) // 创建一个事务
	public void userFollow(String userId, String fanId) {

		// 1.用户粉丝数增加
		// 2.插入关系表
		UsersFans userFans = new UsersFans();
		String id = Sid.next();
		userFans.setId(id);
		userFans.setUserId(userId);
		userFans.setFanId(fanId);
		userFansMapper.insert(userFans);// 增加用戶和粉絲的关系
		userMapper.addFansCount(userId); // 用户的粉丝数加1 //fanId 粉丝的关注量+1
		userMapper.followWithAdd(fanId);//增加粉丝的关注量+1
		
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED) // 创建一个事务
	public void userUnFollow(String userId, String fanId) {

		// 1.查询出用户
		// 2.删除相关的关系记录
		// 3.用户的粉丝数-1
		Example example=new Example(UsersFans.class);
		Criteria criteria=example.createCriteria();
		criteria.andEqualTo("userId",userId);
		criteria.andEqualTo("fanId",fanId);
		userFansMapper.deleteByExample(example);
		userMapper.reduceFansCount(userId);
		userMapper.followWithReduce(fanId);//粉丝的关注量-1


	}
	@Override
	public boolean queryIsFollowed(String userId, String fanId) {
		Example userExample = new Example(UsersFans.class);// 创建一个模板 条件
		Criteria criteria = userExample.createCriteria();
		criteria.andEqualTo("userId", userId);
		criteria.andEqualTo("fanId", fanId);
		List<UsersFans> ls = userFansMapper.selectByExample(userExample);// 查询excample
		if (ls != null && ls.size() > 0) {
			return true;
		}
		return false;
	}

	
	
	
	
}
