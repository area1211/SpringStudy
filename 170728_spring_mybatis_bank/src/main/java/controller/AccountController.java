package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.AccountDao;
import model.Account;

@Controller
public class AccountController {
	private AccountDao accountDao;
	
	
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@ModelAttribute
	public Account setUpForm() {
		return new Account();
	}
	
	@RequestMapping(value = "/allAccInfo.bk", method = RequestMethod.GET)
	public ModelAndView getAccounts() {
		ModelAndView modelAndView = new ModelAndView();
		
		List<Account> accountList= accountDao.getAccountList();
		
		modelAndView.setViewName("main");
		modelAndView.addObject("accountList", accountList);
		modelAndView.addObject("selPage", "allAccInfo");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/makeAccountAction.bk", method = RequestMethod.POST)
	public ModelAndView makeAccount(Account account) {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(account);
		accountDao.insertAccount(account);
		
		modelAndView.setViewName("main");
		modelAndView.addObject("account", account);
		modelAndView.addObject("selPage", "accInfo");
		
		return modelAndView;
	}

	@RequestMapping(value = "/accInfoAction.bk", method = RequestMethod.POST)
	public ModelAndView getAccount(String id) {
		ModelAndView modelAndView = new ModelAndView();
		
		Account account= accountDao.getAccount(Integer.parseInt(id));
		
		modelAndView.setViewName("main");
		modelAndView.addObject("account", account);
		modelAndView.addObject("selPage", "accInfo");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/allAccInfo.mobile", method = RequestMethod.GET)
	public ModelAndView goHome(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		
		List<Account> accountList= accountDao.getAccountList();
		
		modelAndView.setViewName("allAccInfo_mb");
		modelAndView.addObject("accountList", accountList);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/makeAccountAction.mobile", method = RequestMethod.GET)
	public ModelAndView makeAccount(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("makeAccount_Form_mb");
		
		return modelAndView;
	}
	@RequestMapping(value = "/makeAccountAction.mobile", method = RequestMethod.POST)
	public ModelAndView makeAccountMobile(Account account, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(account);
		System.out.println(response);
		accountDao.insertAccount(account);
		
		modelAndView.setViewName("home");
		
		response.setHeader("pragma","No-cache");
		response.setHeader("Cache-Control","no-cache");
		response.addHeader("Cache-Control","No-store");
		response.setDateHeader("Expires",1L);


		return modelAndView;
	}
	
	
	@RequestMapping(value = "/accInfo.mobile", method = RequestMethod.GET)
	public ModelAndView goAccForm(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		
		
		modelAndView.setViewName("accInfo_Form_mb");
		
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/accInfo.mobile", method = RequestMethod.POST)
	public ModelAndView getAccountMobile(String id, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("찾고자하는 계좌 : "+id);
		Account account = accountDao.getAccount(Integer.parseInt(id));
		System.out.println(account);
		
		modelAndView.setViewName("accInfo_Form_mb");
		modelAndView.addObject("account", account);
		
		response.setHeader("pragma","No-cache");
		response.setHeader("Cache-Control","no-cache");
		response.addHeader("Cache-Control","No-store");
		response.setDateHeader("Expires",1L);


		return modelAndView;
	}
	
//	@RequestMapping(value = "/depositAction.bk", method = RequestMethod.POST)
//	public ModelAndView depositMoney(String id, String money) {
//		ModelAndView modelAndView = new ModelAndView();
//		
//		Account account= accountDao.getAccount(Integer.parseInt(id));
//		if(Integer.parseInt(money)<=0) {
//			// 에러메시지보내주기...
//		}
//		account.setBalance(account.getBalance());
//		
//		modelAndView.setViewName("main");
//		modelAndView.addObject("account", account);
//		modelAndView.addObject("selPage", "accInfo");
//		
//		return modelAndView;
//	}
}
