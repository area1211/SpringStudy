package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController{

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse arg1) throws Exception {
//		request.get
//      ModelAndView modelAndView = new ModelAndView();
//      modelAndView.setViewName("main");
//      return modelAndView;
//	}
	@RequestMapping(value = "/home.mobile", method = RequestMethod.GET)
	public String goHome(HttpServletRequest request, HttpServletResponse response) {
		String view = request.getRequestURI();
		String ctx = request.getContextPath();
		
		return "home";
	}
	@RequestMapping(value = "/*.html", method = RequestMethod.GET)
	public String goMain(HttpServletRequest request, HttpServletResponse response) {
		String view = request.getRequestURI();
		String ctx = request.getContextPath();
		
		return "main";
	}
	@RequestMapping(method = RequestMethod.GET)
	public String goForm(HttpServletRequest request, HttpServletResponse response) {
		String view = request.getRequestURI();
		String ctx = request.getContextPath();
		
		System.out.println("view : "+view);
		System.out.println("ctx  : "+ctx);
		
		String jspName=view.substring(1+ctx.length(), view.length()-3)+"_Form";
		if(jspName.equals("allAccInfo")) {
			return "allAccInfo";
		}
		
		request.setAttribute("selPage", jspName);
		
		return "main";
	}

//	@RequestMapping(value = "/*.bk", method = RequestMethod.POST) 
//	public ModelAndView go(){
//       //반환값인 ModelAndView 인스턴스 생성
//      ModelAndView modelAndView = new ModelAndView();
//      modelAndView.setViewName("main");
//      return modelAndView;
//		
//	}
}
