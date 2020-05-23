/**
 * 
 */
package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.com.pojo.EasyUIDateGridResult;
import com.taotao.com.pojo.TaotaoResult;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentCategoryExample.Criteria;
import com.taotao.pojo.TbContentExample;
import com.taotao.service.contentService;

/**
 * @author 盼望
 * @date 2019年7月10日上午10:02:52
 */
@Service
public class contentServiceImpl implements contentService {

	@Autowired
	private TbContentMapper contentMapper;
	/**
	 * 插入内容
	 */
	@Override
	public TaotaoResult insertCentent(TbContent content) {
		
		content.setUpdated(new Date());
		content.setCreated(new Date());
		contentMapper.insert(content);
		
		return TaotaoResult.ok();
	}
	/**
	 * 查询内容列表
	 */
	@Override
	public EasyUIDateGridResult getContentList(Long cid,int page, int rows) {
		
		PageHelper.startPage(page, rows);
		//根据cid查询
		TbContentExample example = new TbContentExample();
		com.taotao.pojo.TbContentExample.Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(cid);
		//开始查询
		List<TbContent> list = contentMapper.selectByExampleWithBLOBs(example);
		System.out.println("===============================list:"+list);
		
		PageInfo<TbContent> pageInfo = new PageInfo<>(list);
		EasyUIDateGridResult result = new EasyUIDateGridResult();
		result.setRows(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	/* 
	 * 修改内容数据
	 */
	@Override
	public TaotaoResult editContent(TbContent content) {
		content.getUpdated();
		
		contentMapper.updateByPrimaryKeyWithBLOBs(content);
		return TaotaoResult.ok();
	}
	

}
