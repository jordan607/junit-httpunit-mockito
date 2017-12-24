package com.nt.service;

import com.nt.dao.LoginDAO;

public class LoginServiceImpl implements LoginService {
	private LoginDAO dao;
	

	public void setDao(LoginDAO dao) {
		this.dao = dao;
	}


	@Override
	public String authenticate(String user, String pwd) throws Exception {
		int count=0;
		if(user.equalsIgnoreCase("") || pwd.equalsIgnoreCase(""))
			throw new IllegalArgumentException("provide inputs");
		//use DAO
		count=dao.verify(user, pwd);
		if(count==0)
			return "InValid Crendetials";
		else
			return "Valid Crendetials";
	}//method
}//class
