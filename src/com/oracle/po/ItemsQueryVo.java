package com.oracle.po;

import java.util.List;

/**
 * 商品包装对象
 * 
 * @author L
 *
 */
public class ItemsQueryVo {
	// 商品信息
	private Items items;
	// 为了可扩展性，定义一个扩展类
	private ItemsCustom itemsCustom;
	// 批量商品信息
	private List<ItemsCustom> itemsList;

	public List<ItemsCustom> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<ItemsCustom> itemsList) {
		this.itemsList = itemsList;
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}

	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}

}
