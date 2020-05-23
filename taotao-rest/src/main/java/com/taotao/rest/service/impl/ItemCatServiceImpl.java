/**
 * 
 */
package com.taotao.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.com.pojo.TaotaoResult;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.rest.pojo.ItemCatResult;
import com.taotao.rest.pojo.catNode;
import com.taotao.rest.service.ItemCatService;

/**
 * @author 盼望
 * @date 2019年6月25日下午8:47:57
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

	/* (non-Javadoc)
	 * @see com.taotao.rest.service.ItemCatService#getItemCatList()
	 */
	@Autowired 
	TbItemCatMapper itemCatMapper; 
	
	@Override
	public ItemCatResult getItemCatList() {
		// 使用递归调用
		List catList = getItemCatList(0l);
		//返回结果
		ItemCatResult result = new ItemCatResult();
		result.setData(catList);
		return result;
	}
	
	public List getItemCatList(Long parentId) {
		//根据parentId查询列表
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria= example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//执行查询
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		List resultList = new ArrayList<>();
		int index = 0;
		for(TbItemCat tbItemCat : list) {
			if(index>=14){
				break;
			}
			//is parentId
			if (tbItemCat.getIsParent()) {
				catNode node = new catNode();
				node.setUrl("/products/"+tbItemCat.getId()+".html");
				//如果当前为第一级节点
				if(tbItemCat.getParentId()== 0) {
					node.setName("<a href='/products/"+tbItemCat.getId()+".html'>"+tbItemCat.getName()+"</a>");
					index++;
				}else {
					node.setName(tbItemCat.getName());
				}
				node.setItems(getItemCatList(tbItemCat.getId()));
				//把node添加到列表
				resultList.add(node);
			}else {
				//如果是叶子节点
				String item = "/products/"+tbItemCat.getId()+".html|" + tbItemCat.getName();
				resultList.add(item);
				
			}
			
		}
		return resultList;
	}



}
