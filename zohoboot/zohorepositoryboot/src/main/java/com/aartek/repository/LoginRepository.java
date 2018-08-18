package com.aartek.repository;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aartek.model.User;

@Repository
@Transactional
public class LoginRepository {

	@Autowired
	private HibernateTemplate hibernatetemplate;
	
//	final static Logger logger = Logger.getLogger(LoginRepository.class);
	public String checkLogin(User login)
	{
//		logger.debug("Inside Repository : Login");
		
//		logger.debug(login.getEmail());
//		logger.debug(login.getPassword());
		hibernatetemplate.save(login);
		return "user";
	}
	public Boolean loginRepoCheck(String email,String password)
	{
		System.out.println("Inside LoginRepository : loginRepoCheck() ");
		System.out.println(email);
		System.out.println(password);
		return true;
	}

	public String checkEmailPassword(String email, String password) {
		System.out.println("-----------------------Inside Login Repository----------------------");
		List list = hibernatetemplate.find("from User u where u.email=? and u.password=?", email, password);
		Iterator itr = list.iterator();
		String email1 = null;
		String password1 = null;
		String check = null;
		while (itr.hasNext()) {
			User usr = (User) itr.next();
			email1 = usr.getEmail();
			password1 = usr.getPassword();
		}
		System.out.println(email1);
		System.out.println(password1);
        System.out.println(email);
		if (email1.equals(email) && password1.equals(password)) {
			System.out.println(email + " Login successfully");
			check = "valid";
		} else {
			System.out.println(" Invalid email password");
			check = "not valid";
		}
		//System.out.println(check);
		return check;
	}

}
