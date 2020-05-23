/**
 * 
 */
package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.com.pojo.EasyUIDateGridResult;
import com.taotao.com.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

/**
 * 商品查询
 * @author 盼望
 * @date 2019年5月4日下午6:21:30
 */
@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	//商品详情
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	private TbItem getItemById(@PathVariable Long itemId) {
		TbItem item = itemService.getItemById(itemId);
		return item;
	}
	//商品列表
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDateGridResult getItemList(Integer page, Integer rows) {
		EasyUIDateGridResult result = itemService.getItemList(page, rows);
		return result;
	}
	//添加商品
	@RequestMapping(value="/item/save", method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult createItem(TbItem item, String desc,String itemParams) {
		TaotaoResult result = itemService.createItem(item, desc,itemParams);
		return result;
	}
	@RequestMapping(value="page/item/{itemId}")
	public String showItemParam(@PathVariable Long itemId,Model modle) {
		String html = itemService.getItemParamHtml(itemId);
		modle.addAttribute("myhtml", html);
		
		return "itemParam";
	}
	
}