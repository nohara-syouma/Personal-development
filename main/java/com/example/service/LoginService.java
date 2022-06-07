package com.example.service;

import com.example.Enitity.User;

public interface LoginService {
	
	public User login(String id, String pass);
	
	public void logininsert(String id, String pass);

}
