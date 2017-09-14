package controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bean.DepositionInfo;
import logic.Bank;
import util.DepositionValidator;

@Controller
public class WithdrawController {
	private Bank bank;
	private DepositionValidator depositionValidator;
	
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	public void setDepositionValidator(DepositionValidator depositionValidator) {
		this.depositionValidator = depositionValidator;
	}

	@ModelAttribute
	public DepositionInfo setUpForm() {
		return new DepositionInfo();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView toWithdrawView() {
		System.out.println("DepositView: toWithdrawView()");
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("selPage", "withdraw_Form");
		modelAndView.setViewName("main");
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView withdrawMoney(DepositionInfo depositionInfo, BindingResult bindingResult) {
		System.out.println("DepositView: withdrawMoney()");
		System.out.println(" toString(depositionInfo): "+depositionInfo);
		depositionValidator.validate(depositionInfo, bindingResult);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("main");
		modelAndView.addObject("selPage", "withdraw_Form");
		
		//무슨 에러를 갖고있는 상황이지?
		if(bindingResult.hasErrors()) {
			System.out.println("   bindingResult.hasErrors():true");
			modelAndView.getModel().putAll(bindingResult.getModel());
			return modelAndView;
		}
		
		boolean result = bank.withdrawMoney(depositionInfo);
		if(result) {
			System.out.println("   deposition result: true");
			bindingResult.reject("success.withdraw.money"); // 성공메시지를 reject 하는건 이상하다...
		}else {
			System.out.println("   deposition result: false");
			bindingResult.reject("error.withdraw.money");
		}
		modelAndView.getModel().putAll(bindingResult.getModel());
		
		
		return modelAndView;
	}
	
}
