/**
 * 
 */
package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.com.pojo.EasyUITreeNode;
import com.taotao.com.pojo.TaotaoResult;
import com.taotao.service.ContentCategoryService;

/**
 * @author 盼望
 * @date 2019年7月4日下午9:13:33
 */
@Controller
@RequestMapping("/content/category")
public class CententCatController {
	@Autowired
	private ContentCategoryService contentCatagoryService;
	
	@RequestMapping("list")
	@ResponseBody
	public List<EasyUITreeNode> getCententCatList(@RequestParam(value="id",defaultValue="0") Long parentId){
		List<EasyUITreeNode> list= contentCatagoryService.getContentCatList(parentId);
		return list;
	
	}
	
	
	@RequestMapping("create")
	@ResponseBody
	public TaotaoResult createNode(Long parentId,String name){
		
		TaotaoResult result = contentCatagoryService.insertCategory(parentId, name);
		
		return result;
	}
	
	@RequestMapping("update")
	@ResponseBody
	public TaotaoResult updateNode(Long id , String name) {
		
		TaotaoResult result = contentCatagoryService.renameCategory(id,name);
		
		return result;
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public void deleteNode(Long id,Long parentId) {
		
		contentCatagoryService.deleteCategory(id,parentId);
	}
	
	
}
