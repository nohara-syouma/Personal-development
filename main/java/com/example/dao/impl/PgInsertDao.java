package com.example.dao.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.Enitity.BuyList;
import com.example.Enitity.Products;
import com.example.Enitity.User;
import com.example.dao.InsertDao;

@Repository
public class PgInsertDao implements InsertDao{
	
	private static final String INSERT = "INSERT INTO products (product_id, category_id, name, price) VALUES(:product_id, :category_id, :name, :price)";
	
	private static final String INSERTBUY = "INSERT INTO list (username, product_id, category_id, name, price,img) VALUES(:username, :product_id, :category_id, :name, :price,:img)";
	

	 @Autowired
	 private NamedParameterJdbcTemplate jdbcTemplate;
	 
	 @Autowired
		HttpSession session;
	 
	    @Override
	    public void insert(Products product) {
	        String sql = INSERT;

	        MapSqlParameterSource param = new MapSqlParameterSource();
	        param.addValue("product_id", product.getProductId());
	        param.addValue("category_id", product.getCategoryId());
	        param.addValue("name", product.getName());
	        param.addValue("price", product.getPrice());

	        jdbcTemplate.update(sql, param);
	    }
	    
	    @Override
	    public void insertbuy(BuyList buyList) {
	        String sql = INSERTBUY;
	        
	        User user = (User) session.getAttribute("user");

	        MapSqlParameterSource param = new MapSqlParameterSource();
	        param.addValue("username", user.getName());
	        param.addValue("product_id", buyList.getProductId());
	        param.addValue("category_id", buyList.getCategoryId());
	        param.addValue("name", buyList.getName());
	        param.addValue("price", buyList.getPrice());
	        param.addValue("img", buyList.getImg());
	        
	        jdbcTemplate.update(sql, param);
	    }
	    


}
