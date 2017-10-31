package com.oracle.service;

import java.util.List;

import com.oracle.po.ItemsCustom;
import com.oracle.po.ItemsQueryVo;

public interface ItemsService {
	// 商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;

	// 根据id查询商品
	public ItemsCustom findItemsById(Integer id) throws Exception;

	/**
	 * 修改商品信息
	 * 
	 * @param id
	 *            需要修改的商品的id
	 * @param itemsCustom
	 *            需要修改的商品的信息
	 * @throws Exception
	 */
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception;

	public void deleteItems(Integer[] items_ids) throws Exception;
}
