package com.show.admin.scetc.controller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.show.admin.scetc.pojo.Category;
import com.show.admin.scetc.service.CategoryService;
import com.show.admin.scetc.utils.XyfJsonResult;

/**
 * 
 * @author Ray
 *
 */
@RestController
@RequestMapping("/category")
public class CategoryController extends BasicController {

	@Autowired 
	private  CategoryService categoryService;
	// 返回首页
	@PostMapping("/queryAll")
	public XyfJsonResult queryAll() {
	List<Category> list=categoryService.queryAll();
	return new XyfJsonResult(list);
	}
	/**
	 * @param name
	 * @param description
	 * @param file
	 * @return
	 */
	/**
	 * @param name
	 * @param description
	 * @param file
	 * @return
	 */
	@PostMapping("/add")
	public @ResponseBody XyfJsonResult add(String name,String description,MultipartFile file)
	{
		
		
		System.out.println(name+description+file);
		String savePath=filePath+"//"+"images";
        File saveFile=new File(savePath);
        if(!saveFile.exists())
        {
        	saveFile.mkdirs();
        }
        if(file!=null&&file.getSize()>0)
        {
            InputStream inputStream=null;
            FileOutputStream fos = null;
            String houzhui=file.getOriginalFilename().toString().substring(file.getOriginalFilename().toString().length()-4, file.getOriginalFilename().toString().length());
            String saveName=UUID.randomUUID().toString()+houzhui;
            try {
				inputStream = file.getInputStream();
				String finalPath=saveFile+"//"+saveName;
                fos =new FileOutputStream(finalPath);
                Category category =new Category();
                category.setContent(description);
                category.setCreateTime(new Date());
                category.setIsDeleted(false);
                category.setName(name);
                category.setImageUrl("/images/"+saveName);
				IOUtils.copy(inputStream, fos);
                categoryService.add(category);
			    
			} catch (IOException e1) {
               throw new RuntimeException(e1);//抛出异常
			}
        }
		
		return new XyfJsonResult().ok();
	}
	
	
	

}
