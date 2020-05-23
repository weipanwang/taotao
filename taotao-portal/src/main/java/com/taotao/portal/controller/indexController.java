/**
 * 
 */
package com.taotao.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taotao.portal.service.ContentService;


/**
 * @author 盼望
 * @date 2019年6月21日上午11:40:56
 */
@Controller
public class indexController {
	

	@Autowired
	private ContentService contentService;
	
	
	@RequestMapping("/index")
	public String showIndex(Model model) {
		//取大广告位轮播图
		String json = contentService.getAd1List();
		model.addAttribute("ad1", json);
		
		return "index";
	}
	
}
