package com.oracle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.po.ItemsCustom;

/**
 * json交互测试
 * 
 * @author L
 *
 */
@Controller
public class JsonTestCotroller {
	// 请求json,输出json(商品信息)
	// @RequestBody将请求的商品信息的json串转成ItemsCustom对象
	// @ResponseBody将itemsCustom转成json串
	@RequestMapping("/requestJson")
	public @ResponseBody ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom) {
		// @ResponseBody将itemsCustom转成json串
		return itemsCustom;
	}

	// 请求json,输出json(商品信息)
	// @RequestBody将请求的商品信息的json串转成ItemsCustom对象
	// @ResponseBody将itemsCustom转成json串
	@RequestMapping("/responseJson")
	public @ResponseBody ItemsCustom responseJson(ItemsCustom itemsCustom) {
		// @ResponseBody将itemsCustom转成json串
		return itemsCustom;
	}
}
