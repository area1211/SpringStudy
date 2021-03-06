package controller;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.Shop;
import logic.User;

@Controller
public class LoginFormController {
	private Shop shopService;
	private Validator loginValidator;
	public void setShopService(Shop shopService) {
		this.shopService = shopService;
	}
	public void setLoginValidator(Validator loginValidator) {
		this.loginValidator = loginValidator;
	}
	
	
	@ModelAttribute
	public User setUpForm() {
		return new User();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String toLoginView() {
		return "login";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView onSubmit(User user, BindingResult bindingResult) {
		loginValidator.validate(user, bindingResult);
		ModelAndView modelAndView = new ModelAndView();
		if(bindingResult.hasErrors()) {
			modelAndView.getModel().putAll(bindingResult.getModel());
			return modelAndView;
		}
		
	
		System.out.println(user);
		User loginUser=shopService.getUserByUserIdAndPassword(user.getUserId(), user.getPassword());
		if(loginUser==null) {
			bindingResult.reject("error.login.user");
			modelAndView.getModel().putAll(bindingResult.getModel());
		}
		else {
			modelAndView.setViewName("loginSuccess");
			modelAndView.addObject("loginUser", loginUser);
		}
		return modelAndView;
		
	}
}
