package com.example.service;

import java.util.List;

import com.example.Enitity.BuyList;
import com.example.Enitity.Products;

public interface ProductService {
	
	public List<Products> findAll();
	
	public List<Products> find(Products products);
	
	public Products findid(Integer productId);
	
	public int delete(Products products);
	
	public int update(Products products);
	
	public List<BuyList> finduserlist();
	
	public List<BuyList> listAll();

}
