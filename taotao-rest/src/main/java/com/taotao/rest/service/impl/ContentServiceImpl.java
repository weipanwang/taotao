/**
 * 
 */
package com.taotao.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.rest.service.ContentService;

/**
 * 内容查询
 * @author 盼望
 * @date 2019年7月10日下午8:17:56
 */
@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contenMapper;
	
	@Override
	public List<TbContent> getContentList(Long cid) {
		
		
		//根据cid查询
		TbContentExample example = new TbContentExample();
		com.taotao.pojo.TbContentExample.Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(cid);
		//执行查询
		List<TbContent> list = contenMapper.selectByExampleWithBLOBs(example);
		
		
		return list;
	}

}
