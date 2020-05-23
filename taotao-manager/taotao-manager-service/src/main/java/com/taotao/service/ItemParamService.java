/**
 * 
 */
package com.taotao.service;

import com.taotao.com.pojo.TaotaoResult;

/**
 * @author 盼望
 * @date 2019年5月21日上午10:18:38
 */
public interface ItemParamService {
	TaotaoResult getItemParamByCid(Long cid);
	TaotaoResult insertItemParam(Long cid,String paramData);
	
}
