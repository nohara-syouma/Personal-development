package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Enitity.User;
import com.example.dao.LoginDao;
import com.example.service.LoginService;

@Service
public class LoginServiceimpl implements LoginService{
	
	 @Autowired
	 private LoginDao loginDao;
	 
	 @Override
	 public User login(String id, String pass) {
		 return loginDao.login(id,pass);
	 
		}
	 
	 @Override
	 public void logininsert(String id, String pass) {
		 loginDao.logininsert(id,pass);
	 
		}

}
