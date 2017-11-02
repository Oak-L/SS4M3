package com.oracle.po;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.oracle.controller.converter.ValidGroup1;

public class Items {
	private Integer id;
	// 校验名称在1~30个字符中间
	// groups标识此校验属于哪个分组，可以定义多个分组
	@Size(min = 1, max = 30, message = "{items.name.length}", groups = { ValidGroup1.class })
	private String name;

	private Float price;

	private String pic;
	@NotNull(message = "{items.createtime.isNull}")
	private Date createtime;

	private String detail;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic == null ? null : pic.trim();
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail == null ? null : detail.trim();
	}
}