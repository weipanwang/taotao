/**
 * 
 */
package com.taotao.service;

import com.taotao.com.pojo.EasyUIDateGridResult;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemParam;

/**
 * @author 盼望
 * @date 2019年5月21日下午4:25:48
 */

public interface ItemParamListService {
	
	TbItemParam getItemParamById(Long itemcatid);
	EasyUIDateGridResult getItemParamList(int page, int rows);
}
