package com.oracle.mapper;

import java.util.List;

import com.oracle.po.ItemsCustom;
import com.oracle.po.ItemsQueryVo;

public interface ItemsMapperCustom {
	// 商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
}