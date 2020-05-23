/**
 * 
 */
package com.taotao.service;

import com.taotao.com.pojo.EasyUIDateGridResult;
import com.taotao.com.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

/**
 * @author 盼望
 * @date 2019年7月10日上午10:00:05
 */
public interface contentService {
	//插入内容
	TaotaoResult insertCentent(TbContent content);
	//查询内容列表
	
	EasyUIDateGridResult getContentList(Long cid,int page, int rows);
	
	//修改内容
	TaotaoResult editContent(TbContent content);
	
	//删除内容
	
}
