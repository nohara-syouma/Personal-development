package com.example.dao;

import com.example.Enitity.User;

public interface LoginDao {
	
	public User login(String id, String pass);
	
	public void logininsert(String id, String pass);

}
