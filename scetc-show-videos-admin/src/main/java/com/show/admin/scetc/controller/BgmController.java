package com.show.admin.scetc.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.show.admin.scetc.annotation.SysLog;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.HtmlUtils;

import com.show.admin.scetc.pojo.AdminUser;
import com.show.admin.scetc.pojo.Bgm;
import com.show.admin.scetc.pojo.PageResult;
import com.show.admin.scetc.service.BgmService;
import com.show.admin.scetc.utils.XyfJsonResult;

/**
 * 
 * @author Ray
 *
 */
@RestController
@RequestMapping("/bgm")
public class BgmController extends BasicController {

	@Autowired
	private BgmService bgmService;

	/**
	 * 分页查询背景音乐的列表
	 * 
	 * @param keyword
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@SysLog
	@RequestMapping("/selectBgmList")
	public XyfJsonResult selectBgmList(String keyword, String title,
			@RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
			@RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize) {
		PageResult list = bgmService.queryAll(page, pageSize, keyword, title);
		return XyfJsonResult.ok(list);
	}

	/**
	 * 根据状态码来更新背景音乐
	 * 
	 * @param id
	 * @param status
	 * @param author
	 * @param name
	 * @return
	 */
	@SysLog
	@RequestMapping("/updateBgm")
	public XyfJsonResult updateBgm(Long id, String status, String author, String name) {

		if (status.equals(DELETE)) {
			bgmService.deleteBgm(id);
			return XyfJsonResult.ok();
		} else if (status.equals(UPDATE)) {
			bgmService.updateBgm(id, author, name);
			return XyfJsonResult.ok();
		}
		return XyfJsonResult.errorMsg("参数错误");

	}

	/**
	 * 查询一条背景音乐的详细信息
	 * 
	 * @param id
	 * @return
	 */
	@SysLog
	@PostMapping("/selectResourceById")
	public XyfJsonResult selectResourceById(Long id) {
		// 根据id查询出一个背景音乐的全部信息
		Bgm bgm = bgmService.selectOne(id);
		return XyfJsonResult.ok(bgm);

	}

	/**
	 * 上传音乐代码
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SysLog
	@PostMapping("/addSubmit.do")
	public  @ResponseBody XyfJsonResult uploadMulPic(HttpServletRequest request) throws Exception {

		AdminUser adminUserVo = (AdminUser) request.getSession().getAttribute("adminUser");
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultiValueMap<String, MultipartFile> multiFileMap = multipartRequest.getMultiFileMap();
		for (String key : multiFileMap.keySet()) {
			List<MultipartFile> MultipartFiles = multiFileMap.get(key);
			for (MultipartFile files : MultipartFiles) {
				String fileName = files.getOriginalFilename();
				String fosName = UUID.randomUUID().toString() + ".mp3";
				String finalPath = bgm_filePath + fosName;
				File saveFile = new File(finalPath);// 定义背景音乐的上传路径
				File parentFile = saveFile.getParentFile();
				if (saveFile.exists()) {
					saveFile.delete();
				} else if (!parentFile.exists()) {
					parentFile.mkdirs();
				} else if (files.getSize() != 0 && files.getSize() > 0) {
					FileOutputStream fos = new FileOutputStream(saveFile);
					Bgm bgm = new Bgm();
					fileName = HtmlUtils.htmlEscape(fileName);
					bgm.setAuthor(fileName);
					bgm.setName(fileName);
					bgm.setPath(File.separator+"bgm"+File.separator+ fosName);
					bgmService.insert(bgm);
					IOUtils.copy(files.getInputStream(), fos);// 复制流
					SimpleDateFormat formate = new SimpleDateFormat();
					String date = formate.format(new Date());
					redis.lpush(Operate_REDIS_SESSION,
							date + "&nbsp;&nbsp;&nbsp;" + adminUserVo.getRealName() + ":添加了背景音乐" + fileName);// 存放到redis

				} else {
					continue;
				}
			}
		}
		return XyfJsonResult.ok();
	}

}
