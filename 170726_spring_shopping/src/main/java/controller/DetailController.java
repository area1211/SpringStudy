package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Item;
import logic.Shop;

@Controller
public class DetailController {
	private Shop shopService;

	public void setShopService(Shop shopService) {
		this.shopService = shopService;
	}
	
	@RequestMapping//doGet, doPost...모두 실제 이 컨트롤러에 요청될때 호출되는 것 지정해준것이다. 어노테이션으로!
	public ModelAndView detailItem(Integer itemId) {
		Item item = shopService.getItemByItemId(itemId);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("item", item);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("detail");
		modelAndView.addAllObjects(model);
		return modelAndView;
	}
	
}
