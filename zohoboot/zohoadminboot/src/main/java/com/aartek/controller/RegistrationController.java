package com.aartek.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aartek.model.User;
import com.aartek.service.RegistrationService;
@Controller
public class RegistrationController {
	@Autowired
	private RegistrationService registrationService;

	@RequestMapping("/registration")
	public String showRegistration(Map<String, Object> map) {
		System.out.println("-----------------Inside Controller-Registration--------------------");
		map.put("registrationMap", new User());
		return "registration";
	}

	@RequestMapping(value = "/userregistration", method = RequestMethod.POST)
	public String userSignInAction(@ModelAttribute("registrationMap") User usr) {
				System.out.println("-------------------Inside Controller-userreg----------------");
			System.out.println(usr.getEmail());
			System.out.println(usr.getPassword());
			registrationService.checkLogin(usr);
			return "registration";
	}

}
