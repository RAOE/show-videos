package com.show.impl;

import java.util.List;

import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.show.mapper.BgmMapper;
import com.show.pojo.Bgm;
import com.show.service.BgmService;

@Service
public class BgmServiceImpl implements BgmService {
	@Autowired
	private BgmMapper bgmMapper;
	@Autowired
	private Sid sid;

	@Transactional(propagation = Propagation.SUPPORTS)
	/**
	 * 判断用户是否存在 Boolean
	 */
	@Override
	public List<Bgm> queryBgmList() {

		return bgmMapper.selectAll();

	}
	@Transactional(propagation = Propagation.SUPPORTS) //声明式事务管理
	@Override
	public Bgm queryBgmById(String bgmId) {

		return bgmMapper.selectByPrimaryKey(bgmId);
	}

}
