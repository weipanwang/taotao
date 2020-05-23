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
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemExample.Criteria;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.pojo.TbItemParamItemExample;
import com.taotao.service.ItemService;
import com.taotao.utils.IDUtils;

/**
 * 商品列表
 * @author 盼望
 * @date 2019年5月4日下午6:03:52
 */
@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private TbItemMapper itemMapper;
	
	@Autowired
	private TbItemDescMapper itemDescMapper;
	
	@Autowired
	private TbItemParamItemMapper itemParamItemMapper;
	
	@Override
	public TbItem getItemById(Long itemId) {
		//1.根据组件查询
		//TbItem item = itemMapper.selectByPrimaryKey(itemId);
		TbItemExample example = new TbItemExample();
		//2.根据查询条件查询
		//创建查询条件
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> list = itemMapper.selectByExample(example);
		//判断list中是否为空
		TbItem item = null;
		if (list != null && list.size() > 0) {
			item = list.get(0);
		}
		return item;
	}
	/* (non-Javadoc)
	 * @see com.taotao.service.ItemService#getItemList(int, int)
	 */
	@Override
	public EasyUIDateGridResult getItemList(int page, int rows) {
		//分页处理
				PageHelper.startPage(page, rows);
				//执行查询
				TbItemExample example = new TbItemExample();
				List<TbItem> list = itemMapper.selectByExample(example);
				//取分页信息
				PageInfo<TbItem> pageInfo = new PageInfo<>(list);
				//返回处理结果
				EasyUIDateGridResult result = new EasyUIDateGridResult();
				result.setTotal(pageInfo.getTotal());
				result.setRows(list);
				
				return result;
	}
	/* (non-Javadoc)
	 * @see com.taotao.service.ItemService#createItem(com.taotao.pojo.TbItem, java.lang.String)
	 */
	@Override
	public TaotaoResult createItem(TbItem item, String desc,String itemParam) {
		// TODO Auto-generated method stub
				// 生成商品id
				long itemId = IDUtils.genItemId();
				// 补全TbItem属性
				item.setId(itemId);
				// '商品状态，1-正常，2-下架，3-删除'
				item.setStatus((byte) 1);
				// 创建时间和更新时间
				Date date = new Date();
				item.setCreated(date);
				item.setUpdated(date);
				// 插入商品表
				itemMapper.insert(item);
				// 商品描述
				TbItemDesc itemDesc = new TbItemDesc();
				itemDesc.setItemId(itemId);
				itemDesc.setItemDesc(desc);
				itemDesc.setCreated(date);
				itemDesc.setUpdated(date);
				// 插入商品描述数据
				itemDescMapper.insert(itemDesc);
				//添加商品规格参数
				TbItemParamItem itemParamItem= new	TbItemParamItem();
				itemParamItem.setItemId(itemId);
				itemParamItem.setParamData(itemParam);
				itemParamItem.setCreated(date);
				itemParamItem.setUpdated(date);
				//插入数据
				itemParamItemMapper.insert(itemParamItem);
				
				
				return TaotaoResult.ok();	
		
		
	}
	/* (non-Javadoc)
	 * @see com.taotao.service.ItemService#getItemParam(java.lang.Long)
	 */
	//根据商品id查询规格参数并返回html
	@Override
	public String getItemParamHtml(Long itemId)  {
		// 根据商品id查询规格参数
				TbItemParamItemExample example = new TbItemParamItemExample();
				com.taotao.pojo.TbItemParamItemExample.Criteria criteria = example.createCriteria();
				criteria.andItemIdEqualTo(itemId);
				//执行查询
				List<TbItemParamItem>list = itemParamItemMapper.selectByExampleWithBLOBs(example);
				if (list == null || list.isEmpty()) {
					return"";
				}
				//取规格参数
				TbItemParamItem itemParamItem = list.get(0);
				//取json数据
				String paramData = itemParamItem.getParamData();
//				//转换成java对象
//				List<Map>mapList = JsonUtils.jsonToList(paramData, Map.class);
//				//遍历list生成html
//				StringBuffer sb = new StringBuffer();
//				
//				sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"0\" class=\"Ptable\">\n");
//				sb.append("	<tbody>\n");
//				for (Map map : mapList) {
//					sb.append("		<tr>\n");
//					sb.append("			<th class=\"tdTitle\" colspan=\"2\">"+map.get("group")+"</th>\n");
//					sb.append("		</tr>\n");
//					//取规格项
//					List<Map>mapList2 = (List<Map>) map.get("params");
//					for (Map map2 : mapList2) {
//						sb.append("		<tr>\n");
//						sb.append("			<td class=\"tdTitle\">"+map2.get("k")+"</td>\n");
//						sb.append("			<td>"+map2.get("v")+"</td>\n");
//						sb.append("		</tr>\n");
//					}
//				}
//				sb.append("	</tbody>\n");
//				sb.append("</table>");
//				
//				return sb.toString();
				return paramData;
	}
	
}
