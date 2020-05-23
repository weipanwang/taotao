/**
 * 
 */
package com.taotao.service;
import com.taotao.com.pojo.EasyUIDateGridResult;
import com.taotao.com.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
/**
 * @author 盼望
 * @date 2019年5月5日下午3:54:39
 */
public interface ItemService {
	TbItem getItemById(Long itemid);
	EasyUIDateGridResult getItemList(int page, int rows);
	
	TaotaoResult createItem(TbItem item,String desc,String itemParam);
	
	String getItemParamHtml(Long itemId);
}
