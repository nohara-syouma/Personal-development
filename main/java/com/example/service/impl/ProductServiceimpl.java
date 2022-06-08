package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Enitity.Products;
import com.example.dao.ProductDao;
import com.example.service.ProductService;

@Service
public class ProductServiceimpl implements ProductService{
	
	@Autowired
	 private ProductDao productDao;
	
	@Override
	 public List<Products> findAll() {
		 return productDao.findAll();
	 
		}
	
	@Override
	public List<Products> find(Products products){
		return productDao.find(products);
	}
	
	@Override
	public Products findid(Integer productId){
		return productDao.findid(productId);
	}
	
	@Override
    public int delete(Products products) {
        return productDao.delete(products);
    }
	
}