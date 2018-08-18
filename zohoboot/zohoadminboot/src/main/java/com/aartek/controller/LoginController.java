package com.aartek.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aartek.model.User;
import com.aartek.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginservice;

	/*@RequestMapping(value="/", method=RequestMethod.GET)
	public String index()
	{
		System.out.println("Inside Index");
		return "index";//without all this method its working
	}*/
	
/*	@RequestMapping(value="/welcome", method=RequestMethod.GET)
	public String redirect()
	{
		System.out.println("Inside Welcome: Get");
		return "welcome";
	}*/
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	   public String showLogin(Model model){
//		logger.info("Inside controller");
//		   logger.info("Inside controller : log");
		   model.addAttribute("userMap", new User());
		   return "login";
	   }
	@RequestMapping(value="/userSignIn", method=RequestMethod.POST)
	  public String signInAction(@ModelAttribute("userMap")User user, HttpServletResponse res)
	  {
		  /*Boolean status= false;
			loginvalidator.validate(login, result);
			if(result.hasErrors())
			{
				return "login";
			}
			else*/
//		logger.info("inside SignIn Action");
//		logger.info(login.getEmail());
//		logger.info(login.getPassword());
		System.out.println("-------------------------Inside Post Controller--------------------------");
		String check = loginservice.checkEmailPassword(user.getEmail(), user.getPassword());
		System.out.println(check);
		if (check.equals("valid")) {
			System.out.println(check);
			return "redirect:/product";
		} 
		  return "login";
	  }
}
