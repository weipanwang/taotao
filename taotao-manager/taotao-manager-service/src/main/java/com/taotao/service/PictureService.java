/**
 * 
 */
package com.taotao.service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.taotao.com.pojo.PictureResult;

/**
 * @author 盼望
 * @date 2019年5月9日下午2:44:37
 */
public interface PictureService {
	
	PictureResult uploadPic(MultipartFile PicFile);
}
