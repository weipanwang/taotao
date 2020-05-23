/**
 * 
 */
package com.taotao.service;

import java.util.List;

import com.taotao.com.pojo.EasyUITreeNode;
import com.taotao.com.pojo.TaotaoResult;

/**
 * @author 盼望
 * @date 2019年7月4日下午7:37:22
 */
public interface ContentCategoryService {
	//查询cententCategory列表a
	List<EasyUITreeNode> getContentCatList(Long parentId);
	//插入子节点
	TaotaoResult insertCategory(Long parentId,String name);
	//重命名
	TaotaoResult renameCategory(Long id, String name);
	//删除
	void deleteCategory(Long id,Long parentId);
	
}
