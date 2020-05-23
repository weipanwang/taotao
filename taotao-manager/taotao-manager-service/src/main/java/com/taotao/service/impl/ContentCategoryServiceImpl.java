/**
 * 
 */
package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.com.pojo.EasyUITreeNode;
import com.taotao.com.pojo.TaotaoResult;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.pojo.TbContentCategoryExample.Criteria;
import com.taotao.service.ContentCategoryService;

/**
 * 内容分类
 * @author 盼望
 * @date 2019年7月11日上午9:12:02
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	@Autowired
	private TbContentCategoryMapper contentCategoryMapper;
	
	//查询内容分类列表
	@Override
	public List<EasyUITreeNode> getContentCatList(Long parentId) {
		// TODO Auto-generated method stub
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		
		List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
		
		List<EasyUITreeNode> resultList = new ArrayList<>();
		for (TbContentCategory tbContentCategory : list) {
			EasyUITreeNode node = new EasyUITreeNode();
			node .setId(tbContentCategory.getId());
			node.setText(tbContentCategory.getName());
			node.setState(tbContentCategory.getIsParent()?"closed":"open");
			
			resultList.add(node);
		}
		
		
		return resultList;
	}

	/* 
	 * 添加内容分类
	 */
	@Override
	public TaotaoResult insertCategory(Long parentId, String name) {
		
		TbContentCategory cententCategory = new TbContentCategory();
		cententCategory.setName(name);
		cententCategory.setParentId(parentId);
		//"1"(正常)"2"(删除)
		cententCategory.setStatus(1);
		cententCategory.setIsParent(false);
		cententCategory.setSortOrder(1);
		cententCategory.setCreated(new Date());
		cententCategory.setUpdated(new Date());
		
		contentCategoryMapper.insert(cententCategory);
		Long id = cententCategory.getId();
		
		TbContentCategory parentNode = contentCategoryMapper.selectByPrimaryKey(parentId);
		if (!parentNode.getIsParent()) {
			parentNode.setIsParent(true);
			contentCategoryMapper.updateByPrimaryKey(parentNode);
		}
		
		
		return TaotaoResult.ok(id);
	}

	/* 
	 * 重命名内容分类名称
	 * 
	 */
	@Override
	public TaotaoResult renameCategory(Long id, String name) {
		
		
		TbContentCategory Node = contentCategoryMapper.selectByPrimaryKey(id);
		Node.setName(name);
		contentCategoryMapper.updateByPrimaryKey(Node);
		
		return TaotaoResult.ok(name);
	
	}

	/*
	 * 删除内容分类
	 */
	@Override
	public void deleteCategory(Long id,Long parentId) {
		System.out.println("praentId="+parentId);
		Set<Long> ids = new HashSet<Long>();
		ids = this.findDeleteId(id, ids);
		System.out.println("需要删除的条数："+ids.size());
		if(ids!=null && ids.size()>0) {
			for(Long contendId : ids) {
				System.out.println("需要删除的id："+contendId);
				contentCategoryMapper.deleteByPrimaryKey(contendId);
			}
		}
		
		//判断父分类是否还有子分类
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
		if(list!=null && list.size()>0) {
			System.out.println("该父类还有子节点！");
		}else {
			TbContentCategory Node = contentCategoryMapper.selectByPrimaryKey(parentId);
			Node.setIsParent(false);
			contentCategoryMapper.updateByPrimaryKeySelective(Node);
			System.out.println("修改了父节点的isparent状态");
		}
		
	}
	
	/**
	 * 
	 * @param id
	 * @param ids
	 * @return
	 */
	private Set<Long> findDeleteId(Long id,Set<Long> ids){
		System.out.println("id="+id+","+ids.size());
		// 查询要删除的分类
		TbContentCategory Node = contentCategoryMapper.selectByPrimaryKey(id);
		//判断是否为父节点
		if(Node.getIsParent()) {
			ids.add(id);
			//遍历子分类
			TbContentCategoryExample example = new TbContentCategoryExample();
			Criteria criteria = example.createCriteria();
			criteria.andParentIdEqualTo(Node.getId());
			System.out.println(Node.getId());
			List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
			if(list!=null && list.size()>0) {
				for(TbContentCategory content : list) {
					ids.addAll(this.findDeleteId(content.getId(), ids));
				}
			}
		}else {
			ids.add(id);
		}
		return ids;
	}

}
