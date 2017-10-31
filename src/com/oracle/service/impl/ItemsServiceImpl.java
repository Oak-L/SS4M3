package com.oracle.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.oracle.mapper.ItemsMapper;
import com.oracle.mapper.ItemsMapperCustom;
import com.oracle.po.Items;
import com.oracle.po.ItemsCustom;
import com.oracle.po.ItemsQueryVo;
import com.oracle.service.ItemsService;

public class ItemsServiceImpl implements ItemsService {
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	@Autowired
	private ItemsMapper itemsMapper;

	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		// 通过ItemsMapperCustom查询数据库
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception {
		Items items = itemsMapper.selectByPrimaryKey(id);
		ItemsCustom itemsCustom = new ItemsCustom();
		// 调用spring自带的复制功能
		BeanUtils.copyProperties(items, itemsCustom);
		return itemsCustom;
	}

	@Override
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
		// 添加业务校验，通常在service层对关键参数进行校验
		// 对id进行校验，id为空，就抛出异常
		// 更新商品信息，使用updateByPrimaryKeyWithBLOBs可以更新items表中的所有字段，包括大文本字段
		// updateByPrimaryKeyWithBLOBs要求必须传入id
		if (id != null) {
			itemsCustom.setId(id);
		}
		System.out.println(itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom));
	}

	@Override
	public void deleteItems(Integer[] items_ids) throws Exception {
		for (Integer integer : items_ids) {
			System.out.println(itemsMapper.deleteByPrimaryKey(integer));
		}
	}
}
