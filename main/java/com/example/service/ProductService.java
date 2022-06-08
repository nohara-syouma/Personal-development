package com.example.service;

import java.util.List;

import com.example.Enitity.Products;

public interface ProductService {
	
	public List<Products> findAll();
	
	public List<Products> find(Products products);
	
	public Products findid(Integer productId);
	
	public int delete(Products products);

}
