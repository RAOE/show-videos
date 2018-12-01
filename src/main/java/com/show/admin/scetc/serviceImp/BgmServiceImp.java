package com.show.admin.scetc.serviceImp;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.show.admin.scetc.mapper.BgmMapper;
import com.show.admin.scetc.pojo.Bgm;
import com.show.admin.scetc.pojo.PageResult;
import com.show.admin.scetc.service.BgmService;

/**
 * 接口实现类
 * 
 * @author Ray
 *
 */
@Service
public class BgmServiceImp implements BgmService {

	@Value("${web.upload.path}")
	public String filePath;

	@Autowired
	private BgmMapper bgmMapper;

	@Override
	public List<Bgm> queryAll() {
		List<Bgm> list = bgmMapper.selectAll();
		return list;
	}

	/**
	 * 分页查询bgm列表
	 */
	@Override
	public PageResult queryAll(Integer page, Integer pageSize, String keyword) {

		PageHelper.startPage(page, pageSize);
		List<Bgm> list = bgmMapper.queryAll(keyword);
		PageInfo<Bgm> pageList = new PageInfo<>(list);
		PageResult pageResult = new PageResult();
		pageResult.setPage(page);
		pageResult.setTotal(pageList.getPages());
		pageResult.setRows(list);
		pageResult.setRecords(pageList.getTotal());
		return pageResult;
	}

	@Transactional(propagation = Propagation.REQUIRED) // 事务
	@Override
	public void updateBgm(Long id, String status) {

	}
	@Transactional(propagation = Propagation.REQUIRED) // 事务
	@Override
	public void deleteBgm(Long id, String status) {
		Bgm bgm = new Bgm();
		bgm.setId(id);
		bgm = bgmMapper.selectOne(bgm);
		String path = bgm.getPath();
		path = filePath + path;
		File file = new File(path);
		if (file.exists()) {
			file.delete();
		}
		bgmMapper.delete(bgm);
	}
	@Transactional(propagation = Propagation.REQUIRED) // 事务
	@Override
	public  void insert(Bgm bgm) {
		Bgm example = bgmMapper.selectOne(bgm);
		if (example == null) { // 先判断数据库中是否存在这个字段如果不存在则 插入
			bgmMapper.insertSelective(bgm);
		} else {
			//存在就不执行 避免重复插入
		}
	}

}
