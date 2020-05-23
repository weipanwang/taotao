package com.taotao.sso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.com.pojo.TaotaoResult;

import taotao.sso.service.RegisterService;

@Controller
@RequestMapping("/user")
public class RegisterController {

	@Autowired
	private RegisterService registerService;
	
	
	@RequestMapping(value="/check/{param}/{type}", method=RequestMethod.GET)
	@ResponseBody
	public Object checkInfo(@PathVariable String param, @PathVariable Integer type,
			String callback) {
		TaotaoResult taotaoResult = registerService.checkInfo(param, type);
		if (null == callback) {
			return taotaoResult;
		}
		//需要支持jsonp
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(taotaoResult);
		mappingJacksonValue.setJsonpFunction(callback);
		return mappingJacksonValue;
	}
}