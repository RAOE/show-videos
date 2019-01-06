package com.show.admin.scetc.serviceImpl;

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
	public PageResult queryAll(Integer page, Integer pageSize, String keyword, String title) {

		PageHelper.startPage(page, pageSize);
		List<Bgm> list = bgmMapper.queryAll(keyword, title);
		// 3、获取分页查询后的数据
		PageInfo<Bgm> pageInfo = new PageInfo<>(list);
		// 4、封装需要返回的分页实体
		PageResult result = new PageResult();
		// 设置获取到的总记录数total：
		result.setTotal(pageInfo.getPages());
		// 设置数据集合rows：
		result.setRows(list);
		result.setRecords(pageInfo.getTotal());
		result.setPage(page);
		return result;
	}

	@Transactional(propagation = Propagation.REQUIRED) // 事务
	@Override
	public void deleteBgm(Long id) {
		Bgm bgm = new Bgm();
		bgm.setId(id);
		bgm = bgmMapper.selectOne(bgm);
		String path = bgm.getPath();
		path = filePath + path;
		System.out.println(path);
		File file = new File(path);
		if (file.exists()) {
			file.delete();
		}
		bgmMapper.delete(bgm);
	}

	@Transactional(propagation = Propagation.REQUIRED) // 事务
	@Override
	public void insert(Bgm bgm) {
		// 根据名称去查询是否存在相同的歌曲
		List<Bgm> list = bgmMapper.selectBgmByName(bgm.getName());
		if (list != null && list.size() > 0) {
			Bgm example = list.get(0);
			if (example == null) { // 先判断数据库中是否存在这个字段如果不存在则 插入
				bgmMapper.insertSelective(bgm);
			} else {
			}
		} else {
			bgmMapper.insertSelective(bgm);
		}
	}

	@Override
	public Bgm selectOne(Long id) {
		Bgm bgm = new Bgm();
		bgm.setId(id);
		bgm = bgmMapper.selectOne(bgm);
		return bgm;
	}

	@Transactional(propagation = Propagation.REQUIRED) // 事务
	@Override
	public void updateBgm(Long id, String author, String name) {
		Bgm bgm = new Bgm();
		bgm.setId(id);
		Bgm example = bgmMapper.selectOne(bgm);
		example.setName(name);
		example.setAuthor(author);
		bgmMapper.updateByPrimaryKeySelective(example);

	}

}
