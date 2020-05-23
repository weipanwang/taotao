/**
 * 
 */
package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.com.pojo.EasyUIDateGridResult;
import com.taotao.service.ItemParamListService;

/**
 * @author 盼望
 * @date 2019年5月21日下午4:08:59
 */
@Controller
public class ItemParamListController {
	 
	@Autowired
	private ItemParamListService itemParamListService;
	
	@RequestMapping("/item/param/list")
	@ResponseBody
	public EasyUIDateGridResult getItemParamList(Integer page, Integer rows) {
		EasyUIDateGridResult result = itemParamListService.getItemParamList(page, rows);
		return result;
	}
}
