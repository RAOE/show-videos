package com.show.admin.scetc.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.show.admin.scetc.annotation.SysLog;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.show.admin.scetc.pojo.Category;
import com.show.admin.scetc.pojo.PageResult;
import com.show.admin.scetc.service.CategoryService;
import com.show.admin.scetc.utils.JSONResult;
import com.show.admin.scetc.utils.XyfJsonResult;

/**
 * 专栏查询
 * 
 * @author Ray
 *
 */
@RestController
@RequestMapping("/category")
public class CategoryController extends BasicController {

	@Autowired
	private CategoryService categoryService;

	/**
	 * 分页查询
	 * 
	 * @param keyword
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@SysLog
	@PostMapping("/queryAll")
	public XyfJsonResult queryAll(String keyword, String title, Integer page, Integer pageSize) {
		PageResult list = categoryService.queryAll(title, keyword, page, pageSize);
		return XyfJsonResult.ok(list);
	}

	/**
	 * 根据id查询 出专栏的全部信息
	 * 
	 * @param id
	 * @return
	 */
	@SysLog
	@PostMapping("/selectResourceById")
	public XyfJsonResult selectResourceById(Long id) {
		Category category = categoryService.selectOne(id);
		return XyfJsonResult.ok(category);
	}

	/**
	 * 编辑根据id
	 * 
	 * @param id
	 * @return
	 */
	@SysLog
	@RequestMapping("/editById")
	public ModelAndView edit(Long id) {
		Category category = categoryService.selectOne(id);
		return new ModelAndView("thymeleaf/column/column_edit").addObject("category", category);
	}

	/**
	 * 根据状态吗来更新专栏
	 * 
	 * @param id
	 * @param status
	 * @return
	 */
	@SysLog
	@PostMapping("/updateCategory")
	public XyfJsonResult updateOne(Long id, String status, MultipartFile file, String title, String description) {
		if (status.equals(DELETE)) {
			categoryService.delete(id);
			return XyfJsonResult.ok("delete ok");
		} else if (status.equals(UPDATE)) {
			categoryService.update(id, title, description, file, filePath + File.separator + "images");
			return XyfJsonResult.ok("update ok");
		}
		return XyfJsonResult.errorMsg("参数错误");
	}

	/**
	 * 添加新的专栏
	 * 
	 * @param name
	 * @param description
	 * @param file
	 * @return
	 */
	@PostMapping("/add")
	@ResponseBody
	public JSONResult add(String name, String description, MultipartFile file) {
		String savePath = filePath + File.separator + "images";
		File saveFile = new File(savePath);
		if (!saveFile.exists()) {
			saveFile.mkdirs();
		}
		if (file != null && file.getSize() > 0) {
			InputStream inputStream = null;
			FileOutputStream fos = null;
			String houzhui = file.getOriginalFilename().toString().substring(
					file.getOriginalFilename().toString().length() - 4, file.getOriginalFilename().toString().length());
			String saveName = UUID.randomUUID().toString() + houzhui;
			try {
				inputStream = file.getInputStream();
				String finalPath = saveFile + File.separator + saveName;
				fos = new FileOutputStream(finalPath);
				Category category = new Category();
				category.setContent(description);
				category.setCreateTime(new Date());
				category.setIsDeleted(false);
				category.setName(name);
				category.setImageUrl("/images/" + saveName);
				IOUtils.copy(inputStream, fos);
				categoryService.add(category);
			} catch (IOException e1) {
				throw new RuntimeException(e1);// 抛出异常
			}
		}
		return JSONResult.ok();
	}

}
