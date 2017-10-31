package com.oracle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.oracle.po.ItemsCustom;
import com.oracle.po.ItemsQueryVo;
import com.oracle.service.ItemsService;

/**
 * 商品的controller
 * 
 * @author L
 *
 */
@Controller
// 为了对url进行分类管理，可以在这里定义根路径，最终访问根路径+子路径,如:商品查询--/items/queryItems
@RequestMapping("/items")
public class ItemsController {
	@Autowired
	private ItemsService itemsService;

	// 商品的查询
	// @RequestMapping("/queryItems")
	// 限制http请求的方法,限制后,如果使用其他请求方式会报错
	@RequestMapping(value = "/queryItems", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView find(ItemsQueryVo itemsQueryVo) throws Exception {
		List<ItemsCustom> list = itemsService.findItemsList(itemsQueryVo);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", list);
		modelAndView.setViewName("items/listItems");
		return modelAndView;
	}

	// 商品信息需修改页面的展示
	@RequestMapping("/editItems")
	// 返回String类型，这里返回的是逻辑视图名(真正的jsp路径=前缀+逻辑视图名+后缀)
	// 方法的参数绑定：如果不使用@RequestParam，就要求request传入的要求名称和controller中的方法参数名称一致
	// 如果使用，就没有这个限制，而且还有更多功能,如:required(限定这个参数是否必须传入),defaultValue(默认值)
	public String editItems(Model model, @RequestParam(value = "id", required = true) Integer itemsId)
			throws Exception {
		// 调用service根据id查询商品信息
		ItemsCustom itemsCustom = itemsService.findItemsById(itemsId);
		// ModelAndView modelAndView = new ModelAndView();
		// modelAndView.addObject("itemsCustom", itemsCustom);
		// modelAndView.setViewName("items/editItems");
		// 使用Model形参代替ModelAndView传递参数
		model.addAttribute("itemsCustom", itemsCustom);
		// 使用返回String代替ModelAndView中的setViewName
		return "items/editItems";
	}

	// 商品的修改
	@RequestMapping("/editItemsSubmit")
	// 在需要检验的pojo前面添加@Validated，后面添加BindingResult，用于接收错误信息
	// 注意：这两个配对使用，有几个加几个，位置必须一前一后
	public String editItemsSubmit(Model model, Integer id, @Validated ItemsCustom itemsCustom,
			BindingResult bindingResult) throws Exception {
		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			for (ObjectError objectError : allErrors) {
				System.out.println(objectError.getDefaultMessage());
			}
			model.addAttribute("allErrors", allErrors);
			// 出错就重新到商品修改页面
			return "items/editItems";
		}
		// 调用service更新商品信息，页面需要将商品信息传到此方法
		itemsService.updateItems(id, itemsCustom);
		// ModelAndView modelAndView = new ModelAndView();
		// 返回一个成功页面
		// modelAndView.setViewName("success");
		// return modelAndView;
		// 重定向到商品查询列表
		return "redirect:queryItems.action";
		// 页面转发
		// return "forword:queryItems.action";
	}

	// 商品的批量删除
	@RequestMapping("/deleteItems")
	public String deleteItems(Integer[] items_ids) throws Exception {
		itemsService.deleteItems(items_ids);
		return "redirect:queryItems.action";
	}

	// 商品的批量修改展示
	@RequestMapping("/listEditItems")
	public String listEditItems(Model model, ItemsQueryVo itemsQueryVo) throws Exception {
		List<ItemsCustom> list = itemsService.findItemsList(itemsQueryVo);
		model.addAttribute("list", list);
		return "items/listEditItems";
	}

	// 商品的批量修改提交
	@RequestMapping("/listEditItemsSubmit")
	public String listEditItemsSubmit(ItemsQueryVo itemsQueryVo) throws Exception {
		for (ItemsCustom itemsCustom : itemsQueryVo.getItemsList()) {
			itemsService.updateItems(itemsCustom.getId(), itemsCustom);
		}
		return "redirect:queryItems.action";
	}
}
