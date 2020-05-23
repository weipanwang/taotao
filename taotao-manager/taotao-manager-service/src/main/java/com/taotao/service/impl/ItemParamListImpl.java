/**
 * 
 */
package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.com.pojo.EasyUIDateGridResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.pojo.TbItemExample.Criteria;
import com.taotao.service.ItemParamListService;

/**
 * 
 * @author 盼望
 * @date 2019年5月22日上午11:22:26
 */
@Service
public class ItemParamListImpl implements ItemParamListService {

	@Autowired
	private TbItemParamMapper itemParamMapper;
	
	@Override
	public TbItemParam getItemParamById(Long itemcatid) {
		// TODO Auto-generated method stub
		TbItemParamExample example = new TbItemParamExample();
		
		com.taotao.pojo.TbItemParamExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemcatid);
		
		List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);
		
		
				TbItemParam item = null;
				if (list != null && list.size() > 0) {
					item = list.get(0);
				}
				return item;
		}
		
	

	/* (non-Javadoc)
	 * @see com.taotao.service.ItemParamListService#getItemParamList(int, int)
	 */
	@Override
	public EasyUIDateGridResult getItemParamList(int page, int rows) {
		
		PageHelper.startPage(page, rows);
		
		TbItemParamExample example = new TbItemParamExample();
		List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);
		//System.out.println("===============================list:"+list);
		
		PageInfo<TbItemParam> pageInfo = new PageInfo<>(list);
		
		EasyUIDateGridResult result = new EasyUIDateGridResult();
		result.setTotal(pageInfo.getTotal());
		result.setRows(list);
		
		return result;
		
	}

}
