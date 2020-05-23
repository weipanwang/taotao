/**
 * 
 */
package com.taotao.service;

import java.util.List;

import com.taotao.com.pojo.EasyUITreeNode;

/**
 * @author 盼望
 * @date 2019年5月5日下午3:54:39
 */
public interface ItemCatService {
	List<EasyUITreeNode> getItemCatList(long parentId);
}
