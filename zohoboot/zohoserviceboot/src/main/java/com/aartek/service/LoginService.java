package com.aartek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.model.User;
import com.aartek.repository.LoginRepository;

@Service
public class LoginService {
	@Autowired
	private LoginRepository loginrepository; 
	
//	final static Logger logger = Logger.getLogger(LoginService.class);

	public String checkLogin(User login)
	{
//		logger.warn("Inside Service : Login");
		
//		logger.warn(login.getEmail());
//		logger.warn(login.getPassword());
		
		loginrepository.checkLogin(login);
		
		return "hello";
	}
	public String checkEmailPassword(String email, String password) {

		System.out.println("Inside Service");
		String check = loginrepository.checkEmailPassword(email, password);
		System.out.println(check);
		if (check.equals("valid")) {
			System.out.println(check);
			return check;
		} else {
			System.out.println(check);
			return check;
		}
	}

}
