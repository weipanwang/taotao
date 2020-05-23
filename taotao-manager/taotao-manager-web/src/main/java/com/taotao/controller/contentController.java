/**
 * 
 */
package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.com.pojo.EasyUIDateGridResult;
import com.taotao.com.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;
import com.taotao.service.contentService;

/**
 * @author 盼望
 * @date 2019年7月10日下午2:33:05
 */
@Controller
@RequestMapping("/content")
public class contentController {
	
	@Autowired
	private contentService contentService;
	
	//添加内容
	@RequestMapping("/save")
	@ResponseBody
	public TaotaoResult insertContent(TbContent content) {
		TaotaoResult result = contentService.insertCentent(content);
		return result;
	}
	
	//查询内容列表
	@RequestMapping("/query/list")
	@ResponseBody
	public EasyUIDateGridResult getContentList(@PathVariable @RequestParam(value="categoryId")Long cid,int page, int rows){
		EasyUIDateGridResult list = contentService.getContentList(cid,page,rows);
		
		return list;
	}
	
	//编辑内容列表
	@RequestMapping("/edit")
	@ResponseBody
	public TaotaoResult editContent(TbContent content) {
		
		TaotaoResult result = contentService.editContent(content);
		return result;
	}
	
}
