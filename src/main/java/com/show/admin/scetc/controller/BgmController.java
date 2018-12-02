package com.show.admin.scetc.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.HtmlUtils;

import com.show.admin.scetc.pojo.Bgm;
import com.show.admin.scetc.pojo.PageResult;
import com.show.admin.scetc.service.BgmService;
import com.show.admin.scetc.utils.CommonUtils;
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

	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome to my wolrd";
	}

	@RequestMapping("/selectBgmList")
	public XyfJsonResult selectBgmList(String keyword,
			@RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
			@RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize) {
		PageResult pageResult = bgmService.queryAll(page, pageSize, keyword);
		return XyfJsonResult.ok(pageResult);
	}

	// 查询所有bgm音乐
	@PostMapping("/queryAll")
	public XyfJsonResult queryAll() {
		List<Bgm> list = bgmService.queryAll();
		return XyfJsonResult.ok(list);
	}

	@RequestMapping("/add")
	public ModelAndView add() {
		return new ModelAndView("thymeleaf/webUploaderDemo");
	}

	@RequestMapping("/updateBgm")
	public XyfJsonResult updateBgm(Long id, String status) {

		if (status.equals(DELETE)) {
			bgmService.deleteBgm(id, status);
			return new XyfJsonResult().ok();
		} else if (status.equals(UPDATE)) {
			bgmService.updateBgm(id, status);
			return new XyfJsonResult().ok();
		}
		return null;

	}

	// 上传提交bgm音乐
	@PostMapping("/addSubmit.do")
	public synchronized @ResponseBody XyfJsonResult uploadMulPic(HttpServletRequest request) throws Exception {
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
					bgm.setPath("\\bgm\\" + fosName);
					bgmService.insert(bgm);
					IOUtils.copy(files.getInputStream(), fos);// 复制流
				} else {
					continue;
				}
			}
		}
		return new XyfJsonResult().ok();

	}

}
