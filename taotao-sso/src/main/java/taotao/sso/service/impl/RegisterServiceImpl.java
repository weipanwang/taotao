package taotao.sso.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.com.pojo.TaotaoResult;
import com.taotao.mapper.TbUserMapper;
import com.taotao.pojo.TbUser;
import com.taotao.pojo.TbUserExample;
import com.taotao.pojo.TbUserExample.Criteria;

import taotao.sso.service.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private TbUserMapper userMapper;
	
	/**
	 * 数据有效性校验
	 * <p>Title: checkInfo</p>
	 * <p>Description: </p>
	 * @param data
	 * @param type
	 * @return
	 * @see com.taotao.sso.service.RegisterService#checkInfo(java.lang.String, int)
	 */
	@Override
	public TaotaoResult checkInfo(String data, int type) {
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		//设置查询条件
		//用户名
		if (type == 1) {
			criteria.andUsernameEqualTo(data);
		//电话
		} else if (type == 2) {
			criteria.andPhoneEqualTo(data);
		//email
		} else if (type == 3) {
			criteria.andEmailEqualTo(data);
		}
		List<TbUser> list = userMapper.selectByExample(example);
		//没查到可以使用
		if (list == null || list.isEmpty()) {
			return TaotaoResult.ok(true); 
		}
		return TaotaoResult.ok(false);
	}
}