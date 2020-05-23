/**
 * 
 */
package com.taotao.rest.service;

import java.util.List;

import com.taotao.pojo.TbContent;

/**
 * @author 盼望
 * @date 2019年7月10日下午8:02:56
 */
public interface ContentService {
	List<TbContent> getContentList(Long cid);
}
