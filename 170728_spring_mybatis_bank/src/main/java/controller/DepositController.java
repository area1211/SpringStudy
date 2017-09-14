package controller;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bean.DepositionInfo;
import dao.AccountDao;
import logic.Bank;
import model.Account;
import util.DepositionValidator;

@Controller
public class DepositController {
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
	public ModelAndView toDepositView() {
		System.out.println("DepositView: toDepositView()");
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("selPage", "deposit_Form");
		modelAndView.setViewName("main");
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView depositMoney(DepositionInfo depositionInfo, BindingResult bindingResult) {
		System.out.println("DepositView: depositMoney()");
		System.out.println(" toString(depositionInfo): "+depositionInfo);
		depositionValidator.validate(depositionInfo, bindingResult);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("main");
		modelAndView.addObject("selPage", "deposit_Form");
		
		//무슨 에러를 갖고있는 상황이지?
		if(bindingResult.hasErrors()) {
			System.out.println("   bindingResult.hasErrors():true");
			modelAndView.getModel().putAll(bindingResult.getModel());
			return modelAndView;
		}
		
		boolean result = bank.depositMoney(depositionInfo);
		if(result) {
			System.out.println("   deposition result: true");
			bindingResult.reject("success.deposit.money"); // 성공메시지를 reject 하는건 이상하다...
		}else {
			System.out.println("   deposition result: false");
			bindingResult.reject("error.deposit.money");
		}
		modelAndView.getModel().putAll(bindingResult.getModel());
		
		
		return modelAndView;
	}
}
