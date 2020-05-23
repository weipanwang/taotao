/**
 * 
 */
package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.com.pojo.PictureResult;
import com.taotao.service.PictureService;
import com.taotao.utils.JsonUtils;

/**
 * @author 盼望
 * @date 2019年5月9日下午2:57:45
 */
@Controller
public class PictureController {
	@Autowired
	private PictureService pictureService;
	
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String uploadFile(MultipartFile uploadFile) {
		PictureResult result = pictureService.uploadPic(uploadFile);
		String json = JsonUtils.objectToJson(result);
		return json;
	}
}
