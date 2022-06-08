package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Enitity.BuyList;
import com.example.Enitity.Products;
import com.example.dao.InsertDao;
import com.example.service.InsertService;

@Service
public class InsertServiceimpl implements InsertService{
	
	 @Autowired
	 private InsertDao insertDao;
	
	@Override
	public void insert(Products products) {
		insertDao.insert(products);
	}
	
	public void insertbuy(BuyList buyList) {
		insertDao.insertbuy(buyList);
	}
}
