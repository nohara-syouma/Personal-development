package com.example.dao;

import com.example.Enitity.BuyList;
import com.example.Enitity.Products;

public interface InsertDao {
	public void insert(Products products);
	
	public void insertbuy(BuyList buyList);
}
